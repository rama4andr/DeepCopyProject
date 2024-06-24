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

        if (origObject instanceof Integer || origObject instanceof Double || origObject instanceof Boolean ||
                origObject instanceof Byte || origObject instanceof Character || origObject instanceof Float ||
                origObject instanceof Long || origObject instanceof Short) {
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

        if (origObject instanceof Collection<?> collection) {

            Collection<Object> collectionCopy;
            if (origObject instanceof List<?>) {
                collectionCopy = new ArrayList<>();
            } else {
                collectionCopy = new HashSet<>();
            }

            visitedObjectMap.put(origObject, collectionCopy);

            for (Object element : collection) {
                collectionCopy.add(recursiveCopy(element, visitedObjectMap));
            }

            return collectionCopy;
        }

        if (origObject instanceof Map<?, ?> map) {

            Map<Object, Object> mapCopy = new HashMap<>();

            visitedObjectMap.put(origObject, mapCopy);

            for (Map.Entry<?, ?> element : map.entrySet()) {
                mapCopy.put(
                        recursiveCopy(element.getKey(), visitedObjectMap),
                        recursiveCopy(element.getValue(), visitedObjectMap)
                );
            }

            return mapCopy;
        }

        Constructor<?> defaultConstructor;
        try {
            defaultConstructor = origObject.getClass().getDeclaredConstructor();

            Object objectCopy = defaultConstructor.newInstance();

            visitedObjectMap.put(origObject, objectCopy);

            for (Field field : origObject.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                Object fieldValue = field.get(origObject);

                if (field.getType().isPrimitive()) {
                    if (field.getType() == boolean.class) {
                        field.setBoolean(objectCopy, field.getBoolean(origObject));
                    } else if (field.getType() == byte.class) {
                        field.setByte(objectCopy, field.getByte(origObject));
                    } else if (field.getType() == char.class) {
                        field.setChar(objectCopy, field.getChar(origObject));
                    } else if (field.getType() == short.class) {
                        field.setShort(objectCopy, field.getShort(origObject));
                    } else if (field.getType() == int.class) {
                        field.setInt(objectCopy, field.getInt(origObject));
                    } else if (field.getType() == long.class) {
                        field.setLong(objectCopy, field.getLong(origObject));
                    } else if (field.getType() == float.class) {
                        field.setFloat(objectCopy, field.getFloat(origObject));
                    } else if (field.getType() == double.class) {
                        field.setDouble(objectCopy, field.getDouble(origObject));
                    }
                } else {
                    field.set(objectCopy, recursiveCopy(fieldValue, visitedObjectMap));
                }
            }
            return objectCopy;

        } catch (NoSuchMethodException |
                 InvocationTargetException |
                 InstantiationException |
                 IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
