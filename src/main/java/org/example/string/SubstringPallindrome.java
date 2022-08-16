package org.example.string;

public class SubstringPallindrome {
    public static boolean isSubstring(String s){
        int i=0, j=s.length()-1;
        while(i<=j){
            char f = s.charAt(i);
            char l = s.charAt(j);

            if(f != l)
                return false;

            i++;
            j--;
        }

        return true;
    }


    public static void main(String[] args){
        String s = "ra";

        for(int i=0; i<s.length(); i++){
            for(int j=i+1; j<=s.length(); j++){
                if(isSubstring(s.substring(i,j))){
                    System.out.println(s.substring(i,j));
                }
            }
        }
    }
}
