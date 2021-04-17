package com.company;

import java.lang.annotation.*;
import java.lang.reflect.Type;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation{
    double koeff() default 2.71;

}

public class Main {

    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        Class classes = myClass.getClass();
        Annotation [] annotations = classes.getAnnotations();
        System.out.println("Аннотации класса " + classes.getName());
        for (Annotation ann:annotations) {
            System.out.println(ann);
        }
        System.out.println("------------------Следующий пример------------------");
        LibraryClass libraryClass = new LibraryClass();
        libraryClass.doIt(myClass);
        Example example = new Example();
        libraryClass.doIt(example);
    }
}

@MyAnnotation
class MyClass{
    public String write(){
        return "Method without annotation";
    }
    @NeedMethod
    public String writeOther(){
        return "Method with annotation";
    }
}

class Example{
    int a = 4, b = 7;
    @NeedMethod
    public String print(){
        return a + ", " + b;
    }
    @NeedMethod
    public int summ(){
        return a+b;
    }
}