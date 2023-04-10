package SamsungDxAlgorithm;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class No8 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T=10;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int maxVertex=Integer.parseInt(sc.nextLine());
            char[] data = new char[maxVertex+1];
            int[] edge = new int[maxVertex*2+2];
            for(int i=1; i<=maxVertex; i++){
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                int num = Integer.parseInt(st.nextToken());
                char value = st.nextToken().charAt(0);
                int left=-1;
                int right = -1;
                if(st.hasMoreTokens()){
                    left=Integer.parseInt(st.nextToken());
                    if(st.hasMoreTokens()){
                        right=Integer.parseInt(st.nextToken());
                    }
                }
                data[num] = value;
                edge[num*2-1]=left;
                edge[num*2] = right;
            }

            sb.append("#").append(test_case).append(" ");
            inorderTraversal(data,edge,1,sb);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void inorderTraversal(char[] data, int[] edge, int current, StringBuilder sb){
        int left = edge[current*2-1];
        int right = edge[current*2];
        if(left!=-1)
            inorderTraversal(data, edge,left,sb);
        sb.append(data[current]);
        if(right!=-1)
            inorderTraversal(data, edge,right,sb);

    }
}