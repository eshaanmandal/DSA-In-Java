package org.example.codingexams;

import java.util.Scanner;

public class LostInForest {
    static int findJumps(int idx, String s){
        if(s.charAt(idx) == 'D' || s.charAt(idx) == '_'){
            return idx;
        }
        return findJumps(idx+1, s);
    }
    static String findPath(String s){
       StringBuilder path = new StringBuilder();

       for(int i=1; i<s.length(); i++){
           // check it its a regular path
           if(s.charAt(i) == '_'){
               path.append("W");
           }
           if(s.charAt(i) == '*'){
               int idx = findJumps(i,s);
               path.append("J");
               i = idx;
           }
//           if(s.charAt(i) == 'D'){
//               path.append("W");
//               break;
//           }
       }

       return path.toString();
    }
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        String ip = scn.nextLine();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<ip.length(); i++){
            if(ip.charAt(i)!= ' '){
                sb.append(ip.charAt(i));
            }
        }

        String path = findPath(sb.toString());
        System.out.println(path);

    }
}
