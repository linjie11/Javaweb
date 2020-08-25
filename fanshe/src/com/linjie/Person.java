package com.linjie;

public class Person {
    private String name;
    private String id;
    public Person(){};
    public Person(String name,String id){
        this.name = name;
        this.id = id;
    }
    //普通方法

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
