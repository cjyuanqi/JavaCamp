package com.es.camp.trap.reflect;

import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {



    private static void reflectDeclaredMethod() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Boss> clazz = Boss.class;
        Method[] declaredMethods = clazz.getDeclaredMethods();

        // 方法的参数是基本类型, 则反射获取的方法参数类型必须与其一致.
        Method method = clazz.getMethod("numeric", int.class);
//        Method method = clazz.getMethod("numeric", Integer.class);
        Object result = method.invoke(clazz.newInstance(), 19);
        System.out.println(result);
    }

    private static void reflectParentMethod() throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Class<Boss> clazz = Boss.class;

        // 使用 getDeclaredMethod 获取父类的方法会抛出异常  NoSuchMethodException
//        Method people = clazz.getDeclaredMethod("people", String.class);
//        String result  = (String)people.invoke(clazz.newInstance(), "execute by reflect");
//        System.out.println(result);

        Method method = getMethod(clazz, "people", String.class);
        String result = (String)method.invoke(clazz.newInstance(), "from get method");
        System.out.println(result);

    }



    // 获取类及其父类中的 某个method
    private static Method getMethod(Class<?> target, String name, Class<?>... args) {
        Method method = null;
        try {
            method = target.getDeclaredMethod(name, args);
            method.setAccessible(true);
        } catch (NoSuchMethodException e) {
            System.out.println("Cannot get method from class " + target.getName());
        }

        if (method == null && target != Object.class) {
           return getMethod(target.getSuperclass(),name, args);
        }

        return method;
    }


    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        reflectParentMethod();
    }


}
