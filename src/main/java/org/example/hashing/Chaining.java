package org.example.hashing;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
} 
public class Chaining{
    
    static int tableSize = 19;
    static Node[] hashTable = new Node[tableSize];
    public static void insert(int[] arr, int n){
        for(int i=0; i<n; i++){
            int m = arr[i]%tableSize;
            if(hashTable[m] == null){
                hashTable[m] = new Node(arr[i]);
            }
            else{
                Node temp = null;
                for(temp = hashTable[m]; temp.next != null; temp=temp.next);
                temp.next  = new Node(arr[i]);
            }
        }
    }

    public static boolean search(int x){
        int m = x % tableSize;
        for(Node temp=hashTable[m]; temp.next != null; temp=temp.next){
            if(temp.data == x){
                return true;
            }
        }

        return false;
    }

    public static void showTable(){
        System.out.println("Tableindex"+"\tElements");
        for(int i=0; i<tableSize; i++){
            System.out.print(i+"\t\t");
            Node temp = hashTable[i];
            while(temp != null){
                System.out.print(temp.data + "-->");
                temp = temp.next;
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[] numbers = {50,21,58,17,15,49,56,22,23,25};

        insert(numbers, numbers.length);

        System.out.println(search(58));

        showTable();
    }
}
