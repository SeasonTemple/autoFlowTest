package com.st.srcreview.bean;

public class A {
    private int anInt;
//    private B b;
//
//    public void setB(B b) {
//        this.b = b;
//    }
    public A() {
        System.out.println("[A]: constructor method");
    }

    public A(int anInt) {
        this.anInt = anInt;
    }

    public void init() {
        System.out.println("[A]: init method");
    }

    @Override
    public String toString() {
        return "A{" +
                "anInt=" + anInt +
                '}';
    }
}
