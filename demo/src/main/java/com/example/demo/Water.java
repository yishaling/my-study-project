package com.example.demo;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author  yihsaling
 */
public class Water {
    public static void main(String[] args) {
        Scanner cin=new Scanner(System.in);
        int n=0;
        n=cin.nextInt();
        double[] r=new double[n];
        int i=0;
        while(cin.hasNextDouble()){
            r[i++]=cin.nextDouble();
        }
        Arrays.sort(r);
        double length=0;
        int num=0;
        for(int j=n-1;j>=0;j--){
            length+=Math.sqrt(r[j]*r[j]-1);
            num++;
            if(length>=10.0){
                break;
            }

        }
        System.out.println(num);
    }
}
