package com.example.demo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FuWoChen {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if(sc.hasNext()){
            // N 个同学
            int n=sc.nextInt();
            //最大数 k-1
            int k=sc.nextInt();
            // 做了多少圈了
             int t=sc.nextInt();
            //这个是前面T-1轮
            int reTotal=t*n;
            int pre=0;
            int total =0;
            //第几次数
            for(int i=0;i<reTotal;i++){
                if(i==0){
                    pre=1;
                }else {
                    pre+=i;
                }
                pre=pre%k;
                //如果是第一个同学数的 那么就全加上
                if((i+1)%n==1){
                    total+=pre;
                }

            }
            System.out.println(total);

        }

    }
}
