package com.ihappyk.dp;
/*Method 1: using Static */
class Singleton
{
    private static Singleton singleton;

    private Singleton(){

    }

    public static Singleton getInstance() {
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

}

/*Method 2: using Synchronized */
class SingletonThreadSafe
{
    private static SingletonThreadSafe obj;

    private SingletonThreadSafe(){

    }

    public static synchronized SingletonThreadSafe getInstance() {
        if(obj == null) {
            obj = new SingletonThreadSafe();
        }
        return obj;
    }

}

/*Method 3: using Synchronized more efficient */
class SingletonThreadSafeEff
{
    private static volatile SingletonThreadSafeEff obj;

    private SingletonThreadSafeEff(){

    }

    public static SingletonThreadSafeEff getInstance() {
        if (obj == null) {
            synchronized(SingletonThreadSafeEff.class) {
                if (obj == null) {
                    obj = new SingletonThreadSafeEff();
                }
            }
        }
        return obj;
    }
}

/* Eager initialisation */
class SingletonThreadSafeEager
{
    private static SingletonThreadSafeEager obj = new SingletonThreadSafeEager();

    private SingletonThreadSafeEager(){

    }

    public static SingletonThreadSafeEager getInstance() {
        return obj;
    }
}

public class SingletonPattern
{

}
