package com.example.demo;

import java.util.*;
public class MainClass{
    public static void main(String args[]){
        String reg="\\d+";
        Scanner sc = new Scanner(System.in);
        int incount=0;
        int max=0;
        List<Student> list=new ArrayList<>();
        while(sc.hasNext()){

            incount++;
            String s=sc.next();
            if(s.matches(reg)) {
                max=Integer.valueOf(s);
            }  else {
                list.add(new Student(s,sc.nextInt(),sc.nextInt(),sc.nextInt()));
            }
            if((incount-1)==max){
                Collections.sort(list);
                for(Student ss:list){
                    System.out.println(ss.name+" "+ss.yu+" "+ss.math+" "+ss.eng+" ");
                }
                System.out.println(list);
                incount=0;
            }



        }
    }
    static class Student implements Comparable{
        public String name;
        public Integer yu;
        public  Integer math;
        public  Integer eng;
        Student(String name,int yu,int math,int eng){
            this.name=name;
            this.yu=yu;
            this.math=math;
            this.eng=eng;
        }
        Integer all(){
            return yu+math+eng;
        }
        @Override
        public String toString(){
            return this.name+" "+this.yu+" "+this.math+" "+this.eng+" ";
        }
        @Override
        public int compareTo(Object o) {
            Student s=(Student) o;
            if(all().compareTo(s.all())!=0){
                return -all().compareTo(s.all());
            }else if(this.yu.compareTo(s.yu)!=0){
                return -this.yu.compareTo(s.yu);
            }else if(this.math.compareTo(s.math)!=0){
                return -this.math.compareTo(s.math);
            }else {
                return 0;
            }

        }
    }

}
