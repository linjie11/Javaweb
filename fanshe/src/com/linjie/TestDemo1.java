package com.linjie;

import org.junit.Test;

import java.io.File;
import java.io.FileDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取Class类
        Class class1 = Person.class;
        Class class2 = new Person().getClass();
        Class class3 = Class.forName("com.linjie.Person");
    }
    //操作无参数的构造方法
    @Test
    public void test1() throws Exception {
        //得到Class
        Class c1 = Class.forName("com.linjie.Person");
        //得到Person类的实例
        Person p1 = (Person) c1.newInstance();
        //设置值
        p1.setName("zhangsan");
        System.out.println(p1.getName());
    }

    //操作有参数的构造方法
    @Test
    public void test2() throws Exception {
        //得到Class
        Class c2 = Class.forName("com.linjie.Person");
        //使用有参的构造方法
        Constructor cs = c2.getConstructor(String.class,String.class);
        //通过有参数的构造方法设置值
        Person p2 = (Person) cs.newInstance("lisi","100");
        System.out.println(p2.getName()+ ":" +p2.getId());
    }

    //操作name属性
    @Test
    public void test3(){
        //得到Class类
        try {
            Class c3 = Class.forName("com.linjie.Person");
            //得到name属性
            Field f1 = c3.getDeclaredField("name");
            //设置可以操作私有属性
            f1.setAccessible(true);
            //得到实例
            Person p3 = (Person) c3.newInstance();
            //设置name值
            f1.set(p3,"wangwu");
            System.out.println(f1.get(p3));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //操作普通方法
    @Test
    public void test4(){
        //得到Class类
        try {
            Class c4 = Class.forName("com.linjie.Person");
            //得到name属性
            Method m1 = c4.getDeclaredMethod("setName", String.class);
            //得到实例
            Person p4 = (Person) c4.newInstance();
            //设置name值
            m1.invoke(p4,"zhaomazi");
            System.out.println(p4.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
