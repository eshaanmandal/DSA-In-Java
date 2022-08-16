package org.example.string;

public class StringCompression2 {
    public static void main(String[] args){
        char[] chars = {'a','a','b','b','c','c','c'};

        StringBuilder s = new StringBuilder();
        int count = 1;

        s.append(chars[0]);
        for(int i=1; i<chars.length; i++){
            char curr = chars[i];
            char prev = chars[i-1];

            if(curr ==  prev){
                count++;
            }
            else{
                if(count > 1){
                    s.append(count);
                    count=1;
                    s.append(curr);
                }
                else{
                    s.append(curr);
                }
            }
        }

        if(count > 1){
            s.append(count);
        }

        System.out.println(s);
        System.out.println(s.length());
    }
}
