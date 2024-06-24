package util;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;

public class CopyUtils {

    public static <N> N deepCopy(N object) {

        try {
            IdentityHashMap<Object, Object> objectMap = new IdentityHashMap<>();
            return (N) recursiveCopy(object, objectMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object recursiveCopy(Object origObject, IdentityHashMap<Object, Object> visitedObjectMap) {
        if (origObject == null || origObject.getClass().isPrimitive() ||
                origObject.getClass().isEnum() || origObject instanceof String) {

            return origObject;
        }

        if (visitedObjectMap.containsKey(origObject)) {

            return visitedObjectMap.get(origObject);
        }

        if (origObject.getClass().isArray()) {
            int arrayLength = Array.getLength(origObject);

            Object arrayCopy = Array.newInstance(origObject.getClass().getComponentType(), arrayLength);
            visitedObjectMap.put(origObject, arrayCopy);

            for (int i = 0; i < arrayLength; i++) {
                Array.set(arrayCopy, i, recursiveCopy(Array.get(origObject, i), visitedObjectMap));
            }

            return arrayCopy;
        }
        return null;
    }
}
