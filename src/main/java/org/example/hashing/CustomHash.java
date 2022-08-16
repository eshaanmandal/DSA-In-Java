package org.example.hashing;

public class CustomHash{
    static int MAX = 100;
    static boolean[][] hashTable = new boolean[MAX+1][2];
    public static void insert(int[] arr, int n){
        for(int i=0; i<n; i++){
            if(arr[i] >= 0){
                hashTable[arr[i]][0] = true;
            }
            else{
                hashTable[Math.abs(arr[i])][1] = true;
            }
        }
    }
    public static boolean search(int x){
        if(x >= 0 && x <= MAX){
            if(hashTable[x][0] == true){
                return true;
            }
        } 
        else if(x < 0 && Math.abs(x) <= MAX){
            if(hashTable[Math.abs(x)][1] == true){
                return true;
            }
        }

        return false;
    }
    public static void main(String[] args){
        int[] arr = {1,8,9,10,-16, -65,33};

        insert(arr, arr.length);


        if(search(-16) == true){
            System.out.println("Element exists");
        }
        else{
            System.out.println("It doesnt exist");
        }
    }
}
