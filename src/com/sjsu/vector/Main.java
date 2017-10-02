package com.sjsu.vector;

public class Main {

    public static void main(String[] args)
    {
        Algorithm a = new Algorithm();
        (new Thread(new Executor1(a))).start();
        (new Thread(new Executor2(a))).start();
        (new Thread(new Executor3(a))).start();


    }
}
