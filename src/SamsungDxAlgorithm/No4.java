package SamsungDxAlgorithm;

import java.util.Scanner;

class No4 {
    public static void main(String args[]) throws Exception {

        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T=10;
        for (int test_case = 1; test_case <= T; test_case++) {
            Node head = new Node();
            Node tail = null;
            Node cursor = head;
            int nodeLength = sc.nextInt();
            for(int i=0; i<nodeLength; i++){
                Node newNode = new Node(sc.next());
                cursor.next=newNode;
                cursor = newNode;
            }
            tail = cursor;
            cursor = head;
            int commandLength = sc.nextInt();
            int commandIdx = 0;
            while(commandIdx<commandLength){
                String command = sc.next();
                switch(command){
                    case "I":{
                        int x=sc.nextInt();
                        int y=sc.nextInt();
                        cursor = head;
                        Node tempHead = new Node(sc.next());
                        Node tempCursor = tempHead;
                        for(int i=1; i<y; i++){
                            Node temp = new Node(sc.next());
                            tempCursor.next = temp;
                            tempCursor = temp;
                        }
                        for(int i=0; i<x; i++){
                            cursor = cursor.next;
                        }
                        insert(cursor,tempHead,tempCursor);
                        break;
                    }
                    case "D":{
                        cursor = head;
                        int x = sc.nextInt();
                        int y = sc.nextInt();
                        for(int i=0; i<x; i++){
                            cursor = cursor.next;
                        }
                        delete(cursor, y);
                        break;
                    }
                    case "A":{
                        int y = sc.nextInt();
                        Node tempHead = new Node(sc.next());
                        Node tempCursor = tempHead;
                        for(int i=1; i<y; i++){
                            Node temp = new Node(sc.next());
                            tempCursor.next = temp;
                            tempCursor = temp;
                        }
                        add(tail, tempHead,tempCursor);
                        break;
                    }
                }
                commandIdx++;

            }
            sb.append("#").append(test_case).append(" ");
            cursor = head.next;
            for(int i=0; i<10; i++){
                sb.append(cursor.value).append(" ");
                cursor = cursor.next;
            }
            sb.append("\n");

        }
        System.out.println(sb);
    }
    public static void insert(Node node, Node head, Node tail){
        Node next = node.next;
        node.next = head;
        tail.next = next;
    }
    public static void delete(Node node, int length){
        Node temp = node.next;
        for(int i=0; i<length; i++){
            temp = temp.next;
        }
        node.next = temp;
    }
    public static  void add(Node tail, Node Nodes, Node newTail){
        tail.next = Nodes;
        Node cursor = tail;
        tail = newTail;
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