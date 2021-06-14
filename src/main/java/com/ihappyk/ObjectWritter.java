package com.ihappyk;

import java.io.*;
import java.util.Objects;

class Student implements Serializable
{
    private String Name;
    private int Age;

    public Student ()
    {
    }

    public Student (String name, int age)
    {
        Name = name;
        Age = age;
    }

    public String getName ()
    {
        return Name;
    }

    public void setName (String name)
    {
        Name = name;
    }

    public int getAge ()
    {
        return Age;
    }

    public void setAge (int age)
    {
        Age = age;
    }

    @Override
    public boolean equals (Object o)
    {
        if (this == o)
            return true;

        if (o == null || getClass() != o.getClass())
            return false;

        Student student = (Student)o;

        return Age == student.Age && Objects.equals(Name, student.Name);
    }

    @Override
    public int hashCode ()
    {
        return Objects.hash(Name, Age);
    }
}

public class ObjectWritter
{
    public static final String FILE_PATH = "/Users/I339964/Documents/student.txt";

    public static void main(String args[]) throws IOException
    {
        Student s = new Student();
        FileOutputStream fileOutputStream = new FileOutputStream(FILE_PATH);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(s);
    }
}
