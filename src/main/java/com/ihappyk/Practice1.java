package com.ihappyk;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Practice1
{
    public static void main(String args[]) {
        Set<Integer> set1 = new HashSet<Integer>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        Set<Integer> set2 = new HashSet<Integer>();
        set2.add(2);
        set2.add(3);


        Set<Integer> diff = new HashSet<>(set1);
        diff.removeAll(set2);
        set2.removeAll(set1);
        diff.addAll(set2);

        System.out.println(diff.toString());


    }
}
