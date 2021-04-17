package com.company;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class LibraryClass {
    public void doIt(Object object){
        String s = "";
        Class objectClass = object.getClass();
        Method [] method = objectClass.getMethods();
        for (Method m: method) {
            //System.out.println(m.getName());
            Annotation ann = m.getAnnotation(NeedMethod.class);
            if (ann != null){
                try {
                    s = (String) m.invoke(object);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                } catch (ClassCastException e){
                    System.out.println("Читай документацию, придурок!!!! Неправильно выбрал тип");
                }
                System.out.println(s);
            }
        }
    }
}
