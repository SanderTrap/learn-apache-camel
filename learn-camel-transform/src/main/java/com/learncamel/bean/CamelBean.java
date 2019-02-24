package com.learncamel.bean;

public class CamelBean {

    public String map(String input) {
        System.out.println("Print me pls!");
        return input.replace(",", "*");
    }

    public String notThisMethod(String input) {
        System.out.println("Don't print me!");
        return input.replace(",", "*");
    }
}
