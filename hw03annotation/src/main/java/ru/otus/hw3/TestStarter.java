package ru.otus.hw3;



import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("ALL")
public class TestStarter {

    static void runTest(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        List<TestInfo> generalResult = new ArrayList<>();
        Class<?> clazz = Class.forName(className);
        List<Method> beforeMethods = getMethodsByAnnotations(clazz, Before.class);
        List<Method> testMethods = getMethodsByAnnotations(clazz, Test.class);
        List<Method> afterMethods = getMethodsByAnnotations(clazz, After.class);

        for (Method testMethod : testMethods) {
            Object instance = instantiate(clazz);
            try {
                runMethods(instance, beforeMethods);
                runMethod(instance, testMethod);
                runMethods(instance, afterMethods);
                addResultToLog(testMethod, TestInfo.PASSED);
                generalResult.add(TestInfo.PASSED);
            } catch (IllegalAccessException e) {
                addResultToLog(testMethod, TestInfo.BROKEN);
                generalResult.add(TestInfo.BROKEN);
            } catch (InvocationTargetException e) {
                addResultToLog(testMethod, TestInfo.FAILED);
                generalResult.add(TestInfo.FAILED);
            }
        }
        for (Method testMethod : testMethods) {
            Object instance = instantiate(clazz);
            try {
                runMethods(instance, afterMethods);
                addResultToLog(testMethod, TestInfo.PASSED);
                generalResult.add(TestInfo.PASSED);
            } catch (IllegalAccessException e) {
                addResultToLog(testMethod, TestInfo.BROKEN);
                generalResult.add(TestInfo.BROKEN);
            } catch (InvocationTargetException e) {
                addResultToLog(testMethod, TestInfo.FAILED);
                generalResult.add(TestInfo.FAILED);
            }
        }
        addGeneralResultToLog(clazz, generalResult);
    }

    private static Object instantiate(Class<?> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

    private static void runMethod(Object instance, Method method, Object... methodParameters)
            throws InvocationTargetException, IllegalAccessException {
        method.invoke(instance, methodParameters);
    }

    private static void runMethods(Object instance, List<Method> methods)
            throws InvocationTargetException, IllegalAccessException {
        for (Method method : methods) {
            runMethod(instance, method, null);
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
    private static void addResultToLog(Method method, TestInfo status) {
        String message = "End: [" + method.getName() + "] Status: [" + status + "]";
        System.out.println(message);
    }

    private static void addGeneralResultToLog(Class clazz, List<TestInfo> testStatuses) {
        String message = "Testing completed. " +
                clazz.getName() + ": " +
                Collections.frequency(testStatuses, TestInfo.PASSED) + " PASSED, " +
                Collections.frequency(testStatuses, TestInfo.BROKEN) + " BROKEN, " +
                Collections.frequency(testStatuses, TestInfo.FAILED) + " FAILED. \n";
        System.out.println(message);
    }
}
