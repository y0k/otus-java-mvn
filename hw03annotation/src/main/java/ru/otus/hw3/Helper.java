package ru.otus.hw3;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
class Helper {
    static Object instantiate(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

     static void runMethod(Object instance, Method method, Object... methodParameters)
            throws InvocationTargetException, IllegalAccessException {
        method.invoke(instance, methodParameters);
    }

     static void runMethods(Object instance, List<Method> methods)
            throws InvocationTargetException, IllegalAccessException {
        for (Method method : methods) {
            runMethod(instance, method, null);
        }
    }

     static List<Method> getMethodsByAnnotations(Class<?> clazz, Class<? extends Annotation> annotation) {
        List<Method> methods = new ArrayList<>();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(annotation))
                methods.add(method);
        }
        return methods;
    }
}