package SamsungDxAlgorithm;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No7 {

    private final static int MAX_NODE = 10000;
    private final static int ADD_HEAD = 1;
    private final static int ADD_TAIL = 2;
    private final static int ADD_NUM = 3;
    private final static int FIND = 4;
    private final static int REMOVE = 5;
    private final static int PRINT = 6;
    private final static int PRINT_REVERSE = 7;
    private final static int END = 99;

    private final static UserSolution usersolution = new UserSolution();

    private static BufferedReader br;

    public static void run() throws Exception {
        int cmd, data, num, ret;
        int[] output = new int[MAX_NODE];
        String str;
        StringTokenizer st;

        while(true) {
            str = br.readLine();
            st = new StringTokenizer(str, " ");
            cmd = Integer.parseInt(st.nextToken());

            switch(cmd) {
                case ADD_HEAD :
                    data = Integer.parseInt(st.nextToken());
                    usersolution.addNode2Head(data);
                    break;

                case ADD_TAIL :
                    data = Integer.parseInt(st.nextToken());
                    usersolution.addNode2Tail(data);
                    break;

                case ADD_NUM :
                    data = Integer.parseInt(st.nextToken());
                    num = Integer.parseInt(st.nextToken());
                    usersolution.addNode2Num(data, num);
                    break;

                case FIND :
                    data = Integer.parseInt(st.nextToken());
                    num = usersolution.findNode(data);
                    System.out.println(num);
                    break;

                case REMOVE :
                    data = Integer.parseInt(st.nextToken());
                    usersolution.removeNode(data);
                    break;

                case PRINT :
                    ret = usersolution.getList(output);
                    for(int i = 0; i < ret; i++) {
                        System.out.print(output[i] + " ");
                    }
                    System.out.println();
                    break;

                case PRINT_REVERSE :
                    ret = usersolution.getReversedList(output);
                    for(int i = 0; i < ret; i++) {
                        System.out.print(output[i] + " ");
                    }
                    System.out.println();
                    break;

                case END :
                    return;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int TC;
        //System.setIn(new java.io.FileInputStream("res/sample_input.txt"));

        br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        TC = Integer.parseInt(str);

        for (int tc = 1; tc <= TC; tc++) {
            System.out.println("#" + tc);
            usersolution.init();
            run();
            System.out.println();
        }
    }
    static class Node {
        public int data;
        public Node prev;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static class UserSolution {

        private final static int MAX_NODE = 10000;

        private Node[] node = new Node[MAX_NODE];
        private int nodeCnt = 0;
        private Node head;

        public Node getNode(int data) {
            node[nodeCnt] = new Node(data);
            return node[nodeCnt++];
        }

        public void init() {
            head=getNode(-1);
        }

        public void addNode2Head(int data) {
            Node node = getNode(data);
            if(head.next==null){
                head.next=node;
                node.prev=head;
            }else {
                Node temp = head.next;
                head.next=node;
                node.prev=head;
                node.next=temp;
                temp.prev=node;
            }
        }

        public void addNode2Tail(int data) {
            Node cursor = head;
            while(cursor.next!=null)
                cursor = cursor.next;
            cursor.next=getNode(data);
            cursor.next.prev = cursor;
        }

        public void addNode2Num(int data, int num) {
            if(head.next==null){
                addNode2Head(data);
                return;
            }
            Node cursor = head;
            int idx=1;
            while(idx<num){
                cursor = cursor.next;
                idx++;
            }
            Node temp = cursor.next;
            Node node = getNode(data);
            cursor.next=node;
            node.prev=cursor;
            if(temp!=null) {
                node.next = temp;
                temp.prev = node;
            }
        }

        public int findNode(int data) {
            int idx=0;
            Node cursor = head.next;
            while(cursor.data!=data&&cursor.next!=null){
                cursor = cursor.next;
                idx++;
            }
            return idx+1;
        }

        public void removeNode(int data) {
            Node cursor = head;

            while (cursor.next != null) {
                if (cursor.next.data == data) {
                    cursor.next = cursor.next.next;
                    if(cursor.next!=null)
                        cursor.next.prev=cursor;
                } else {
                    cursor = cursor.next;

                }
            }
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
            int idx=0;
            Node cursor = head.next;
            while(cursor.next!=null){
                output[idx] = cursor.data;
                idx++;
                cursor = cursor.next;
            }
            output[idx] = cursor.data;
            return idx+1;
        }

        public int getReversedList(int[] output) {
            int idx=0;
            Node cursor = head.next;
            while(cursor.next!=null){
                cursor = cursor.next;
            }
            while(cursor.prev!=null){
                output[idx]=cursor.data;
                idx++;
                cursor = cursor.prev;
            }
            return idx;
        }
    }
}

