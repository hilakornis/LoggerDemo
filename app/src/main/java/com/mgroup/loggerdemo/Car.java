package com.mgroup.loggerdemo;

public class Car {

    public Car(){
        MGLog.d("HERE", "checkpoint 1 ");
    }

    public void function(){
        MGLog.d("HERE", "checkpoint 2 ");
        f();
    }

    public void f(){
        MGLog.d("HERE", "checkpoint 3");
    }
}
