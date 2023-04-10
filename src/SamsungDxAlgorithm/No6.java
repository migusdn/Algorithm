package SamsungDxAlgorithm;

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class No6 {

    private final static int MAX_NODE = 10000;

    private Node[] node = new Node[MAX_NODE];
    private int nodeCnt = 0;
    private Node head;

    public Node getNode(int data) {
        node[nodeCnt] = new Node(data);
        return node[nodeCnt++];
    }

    public void init() {
        head=null;
    }

    public void addNode2Head(int data) {
        if (head == null) {
            head = getNode(data);
        }else{
            Node node = getNode(data);
            node.next = head;
            head = node;
        }
//        return 0;
    }

    public void addNode2Tail(int data) {
        Node cursor = head;
        if(cursor==null){
            addNode2Head(data);
            return;
        }
        while (cursor.next != null)
            cursor = cursor.next;
        cursor.next = getNode(data);
    }

    public void addNode2Num(int data, int num) {
//        System.out.println(data+","+num);
        if(num==1) {
            addNode2Head(data);
            return;
        }
        Node cursor = head;
        int idx = 0;
        while (idx < num - 2) {
//            System.out.println("cursordata"+cursor.data);
            cursor = cursor.next;
            idx++;
        }
        Node temp = cursor.next;
        cursor.next = getNode(data);
        cursor.next.next = temp;
    }

    public void removeNode(int data) {
        Node cursor = head;

        while (cursor.next != null) {
            if (cursor.next.data == data) {
                cursor.next = cursor.next.next;
            } else
                cursor = cursor.next;
        }
        if (head.data == data)
            head = head.next;
        int count = 0;
        int pointer1 = -1;
        while (count < nodeCnt) {
            if (node[count].data == data) {
                if (pointer1 == -1)
                    pointer1 = count;
                node[count] = null;
            }
            count++;
        }
        int pointer2 = pointer1 + 1;
        if (pointer1 != -1) {
            while (pointer1 <= nodeCnt - count) {
                if (node[pointer2] != null) {
                    node[pointer1] = node[pointer2];
                    node[pointer2] = null;
                    pointer1++;
                }
                pointer2++;
            }
        }
        nodeCnt-=count;
    }

    public int getList(int[] output) {
        int idx = 0;
        Node cursor = head;
        while (cursor.next != null) {
            output[idx] = cursor.data;
            cursor = cursor.next;
            idx++;
        }
        output[idx] = cursor.data;
        return idx+1;
    }
}