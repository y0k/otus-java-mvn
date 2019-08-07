package ru.otus.hw3;

import org.junit.jupiter.api.TestInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

public class TestStarter {
    public static void main(String[] args) throws ClassNotFoundException {
        runTest ("ru.otus.hw3.MyTest");
    }
    public static void runTest(String className) throws ClassNotFoundException {
        List<TestInfo> generalResult = new ArrayList<>();
        Class<?> clazz = Class.forName(className);
        List<Method> beforeMethods = getMethodsByAnnotations(clazz, Before.class);
        List<Method> testMethods = getMethodsByAnnotations(clazz, Test.class);
        List<Method> afterMethods = getMethodsByAnnotations(clazz, After.class);

        for (Method testMethod : testMethods) {
            Object instance = instantiate(clazz);
        }

    }

    private static List<Method> getMethodsByAnnotations(Class<?> clazz, Class<? extends Annotation> annotation) {
        List<Method> methods = new ArrayList<>();
        for (Method method: clazz.getDeclaredMethods()) {
            if(method.isAnnotationPresent(annotation))
                methods.add(method);
        }
        return methods;
    }
    private static void addResultToLog(Method method, TestStatus status) {
        String message = "End: [" + method.getName() + "] Status: [" + status + "]";
        System.out.println(message);
    }
    private static void addGeneralResultToLog(Class clazz, List<Tes>)
}
