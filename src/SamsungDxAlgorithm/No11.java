package SamsungDxAlgorithm;

import java.util.Scanner;

class No11 {
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception {

        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            int maxVertex = sc.nextInt();
            int maxEdge = sc.nextInt();
            int x,y;
            x = sc.nextInt();
            y = sc.nextInt();
            int[] edges = new int[maxVertex * 2 + 2];
            int[] parents = new int[maxVertex+1];
            int[] depth = new int[maxVertex+1];
            for (int i = 1; i <= maxEdge; i++) {
                int p = sc.nextInt();
                int c = sc.nextInt();
                if (edges[p * 2 - 1] == 0) {
                    edges[p * 2 - 1] = c;
                } else {
                    edges[p * 2] = c;
                }
                parents[c]=p;
            }
            sb.append("#").append(test_case).append(" ");
//            findCommonParent(edges, children);
            findDepth(edges,parents,depth,1);
            int commonParent = findCommonParent(edges,parents,depth,x,y);
            int count = countChild(edges,commonParent);
            sb.append(commonParent).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
    public static void findDepth(int[] edges, int[] parents, int[] depth,int current){
        depth[current] = depth[parents[current]]+1;
        if(current!=0) {
            findDepth(edges, parents, depth, edges[current * 2 - 1]);
            findDepth(edges, parents, depth, edges[current * 2]);
        }
    }
    public static int countChild(int[] edges, int current){
        int count=1;
        if(current!=0){
            count+=countChild(edges, edges[current*2-1]);
            count+=countChild(edges, edges[current*2]);
            return count;
        }else{
            return 0;
        }
    }

    public static int findCommonParent(int[] edges,int[] parents,int[] depth, int x, int y) {
        int depth1 = depth[x];
        int depth2 = depth[y];
        int parent1 = parents[x];
        int parent2 = parents[y];
        if(depth1==depth2){
            if(parent1==parent2)
                return parent1;
            else
                return findCommonParent(edges, parents, depth, parent1, parent2);
        }else if(depth1<depth2){
            return findCommonParent(edges, parents, depth, x, parent2);
        }else{
            return findCommonParent(edges, parents, depth, parent1, y);
        }

    }
}