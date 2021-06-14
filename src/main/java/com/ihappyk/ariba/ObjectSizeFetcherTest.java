package com.ihappyk.ariba;

import java.lang.instrument.*;

class ObjectSizeFetcher {
    private static Instrumentation instrumentation;

    public static long getObjectSize(Object o)
    {
        return instrumentation.getObjectSize(o);
    }
}

public class ObjectSizeFetcherTest
{
    private int x;
    private int y;
    public static void main(String [] args)
    {
        System.out.println("main()");
    }

    public static void premain(String args, Instrumentation inst)
    {
        System.out.println("calling premain...");
        //System.out.println(i.getObjectSize(new A()));
    }
}