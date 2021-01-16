package com.example.demo;

import java.util.Scanner;

public class FuWoCheng2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, k, t;
        n = scanner.nextInt();
        k = scanner.nextInt();
        t = scanner.nextInt();
        int count =2*n;
        int num =1;
        int sum=1;
        for(int i= n;i<n*t;i=i+n){
            num= (num+count)%k;
            sum +=num;
            count= count +n*n;
        }
        System.out.println(sum);
    }
}
