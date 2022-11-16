package com.st.srcreview.bean;

public class B {
    private A a;
    private String str;

    public void setA(A a) {
        this.a = a;
    }

    public B(String str) {
        this();
        this.str = str;
    }

    public B() {
        System.out.println("[B]: constructor method");
    }

    public void init() {
        System.out.println("[B]: init method");
    }

    @Override
    public String toString() {
        return "B{" +
                "a=" + a +
                '}';
    }
}
