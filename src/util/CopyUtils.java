package util;

import java.util.IdentityHashMap;

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
        return null;
    }
}
