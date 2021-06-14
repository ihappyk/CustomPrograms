package com.ihappyk;

import java.util.*;

import java.util.Scanner;

abstract class Shape {
    int width;
    abstract void area();
}
//your code goes here

class Square extends Shape {

    Square(int w){
        this.width = w;
    }

    public void area(){
        System.out.println(this.width * this.width);
    }

}

class Circle extends Shape {

    Circle(int w){
        this.width = w;
    }

    public void area(){
        System.out.println(Math.PI*this.width*this.width);
    }

}

class Program {
    public static void main(String args[]) {
        int n = countPrimes(100);
            System.out.println(n);
    }

    public static int countPrimes(int n) {
        int count = 0;
        if (n == 0) return count;
        if (n == 1) return count;
        else {
            for(int i = 2;i<= n;i++){
                boolean flag = true;
                for(int j = 2; j <= i/2; j++) {
                    if (i%j == 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    count += 1;
                }
            }
        }
        return count;
    }
}

//public class Bowling {
//    HashMap<String, Integer> players;
//    Bowling() {
//        players = new HashMap<String, Integer>();
//    }
//    public void addPlayer(String name, int p) {
//        players.put(name, p);
//    }
//    //your code goes here
//
//    public String getWinner(){
//        int max = 0;
//        String name = "";
//        Iterator iterator = players.entrySet().iterator();
//        while(iterator.hasNext()) {
//            Map.Entry mapElement = (Map.Entry)iterator.next();
//            if((int)mapElement.getValue() > max){
//                name = (String)mapElement.getKey();
//            }
//        }
//        return name;
//
//    }
//
//}

//public class Program {
//    public static void main(String[ ] args) {
//        Bowling game = new Bowling();
//        Scanner sc = new Scanner(System.in);
//
//        for(int i=0;i<3;i++) {
//            String input = sc.nextLine();
//            String[] values = input.split(" ");
//            String name = values[0];
//            int points = Integer.parseInt(values[1]);
//            game.addPlayer(name, points);
//        }
//        game.getWinner();
//    }
//}


//public class Program {
//    public static void main(String[ ] args) {
//        Scanner sc = new Scanner(System.in);
//        int x = 5;
//        int y = 2;
//
//        Square a = new Square(x);
//        Circle b = new Circle(y);
//        a.area();
//        b.area();
//    }
//}

//class Converter {
//    public static String toBinary (int num){
//        String binary = "";
//        while(num>0) {
//            binary = (num % 2) + binary;
//            num = num / 2;
//        }
//        return binary;
//    }
//
//}
//
//
//public class Program {
//    public static void main(String[ ] args) {
//        Scanner sc = new Scanner(System.in);
//        int x = sc.nextInt();
//        System.out.print(Converter.toBinary(x));
//    }
//}

//public class Program
//{
//    public static void main(String[] args) {
//        /*Scanner scanner = new Scanner(System.in);
//        int amount = scanner.nextInt();
//        int payback = 0;
//        for (int i=0;i<=5;i++) {
//            payback = (int)((int) amount * 0.10);
//            amount = amount - payback;
//            // System.out.println(amount);
//        }
//        System.out.println(amount);*/
//
////        String text = "Hello";
////        char[] arr = text.toCharArray();
////        char ch;
////        //your code goes here
////        int n = arr.length;
////        for(int i=0;i<(int)n/2;i++){
////            ch = arr[i];
////            arr[i] = arr[n-i-1];
////            arr[n-i-1] = ch;
////        }
////        System.out.println(arr);
//    }
//}