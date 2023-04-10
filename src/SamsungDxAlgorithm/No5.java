package SamsungDxAlgorithm;

import java.util.Scanner;

class No5 {
    public static void main(String args[]) throws Exception {

        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            Node head = new Node();
            Node cursor = head;
            int n = sc.nextInt();
            int m = sc.nextInt();
            int l = sc.nextInt();
            for(int i=0; i<n; i++){
                Node temp = new Node(sc.next());
                cursor.next = temp;
                cursor = temp;
            }
            for(int i=0; i<m; i++){
                String command = sc.next();
                int idx = sc.nextInt();
                cursor = head;
                for(int j=0; j<idx; j++){
                    cursor = cursor.next;
                }
                switch(command){
                    case "I":{
                        String value = sc.next();
                        insert(cursor,value);
                        break;
                    }
                    case "D":{
                        delete(cursor);
                        break;
                    }
                    case "C":{
                        String value = sc.next();
                        change(cursor,value);
                        break;
                    }
                }
            }
            cursor = head;
            int idx=-1;
            for(; idx<l; idx++){
                if(cursor.next!=null)
                    cursor = cursor.next;
                else
                    break;
            }
            sb.append("#").append(test_case).append(" ");
            if(idx==l){
                sb.append(cursor.value);
            }else{
                sb.append("-1");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void insert(Node node,String value){
        Node tempNext = node.next;
        node.next = new Node(value);
        node.next.next = tempNext;
    }
    static void delete(Node node){
        Node tempNext = node.next.next;
        node.next=tempNext;
    }
    static void change(Node node, String value){
        node.next.value = value;
    }

    static class Node {
        Node next=null;
        String value;
        public Node(){
            this.value = "";
        }
        public Node(String value){
            this.value = value;
        }
    }
}