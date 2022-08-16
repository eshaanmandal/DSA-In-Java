package org.example.string;



public class Stringbuilder {
    public static void main(String[] args){
       StringBuilder sb = new StringBuilder("hello");
       System.out.println(sb);
       sb.setCharAt(0,'d');

       sb.insert(2,'y');
       sb.deleteCharAt(2);
       System.out.println(sb);
    }
}
