package com.example.demo;

import java.util.Scanner;

public class MainClass2 {

    public static final String reg="\\d+";
    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int j=0;
        while(sc.hasNext()){
            if(sc.next().matches(reg)){
                sc.next();
            }




        }
    }
}

