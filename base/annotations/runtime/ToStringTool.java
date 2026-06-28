package base.annotations.runtime;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

// 工具类：通过反射读取 @ToString 并拼接字段
public class ToStringTool {
    public static String toString(Object obj) throws IllegalArgumentException, IllegalAccessException {
        if (obj == null) {
            return "null";
        }

        Class<?> clazz = obj.getClass();
        ToString annotation = clazz.getAnnotation(ToString.class);
        if (annotation == null) {
            return obj.toString();
        }

        String label = annotation.value().isEmpty() ? clazz.getSimpleName() : annotation.value();
        StringBuilder result = new StringBuilder(label).append('{');

        List<Field> fields = collectFields(clazz);
        for (int i = 0; i < fields.size(); i++) {
            Field field = fields.get(i);
            field.setAccessible(true);
            if (i > 0) {
                result.append(", ");
            }
            result.append(field.getName()).append('=').append(field.get(obj));
        }

        return result.append('}').toString();
    }

    private static List<Field> collectFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<>();
        for (Class<?> c = clazz; c != null && c != Object.class; c = c.getSuperclass()) {
            for (Field field : c.getDeclaredFields()) {
                fields.add(field);
            }
        }
        return fields;
    }
}
