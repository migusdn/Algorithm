package SamsungDxAlgorithm.No18;

import java.util.LinkedList;
import java.util.List;

public class UserSolution {
    class Node{
        int[] children;
        int cnt;
        Node(){
            this.children = new int[5];
            this.cnt=0;
        }
        void add(int node){
            children[cnt] = node;
            cnt++;
        }
    }
    static int max;
    static int[][] path;
    static Node[] nodes;
    public void dfs_init(int N, int[][] path) {
        UserSolution.max = N;
        UserSolution.path = path;
        nodes = new Node[100];
        for(int i=0; i< path.length; i++){
            int parent = path[i][0];
            if(parent==0)
                continue;
            int child = path[i][1];
            if(nodes[parent]==null){
                nodes[parent] = new Node();
            }
            if(nodes[child]==null){
                nodes[child] = new Node();
            }
            nodes[parent].add(child);
        }
    }
    public int dfs(int N) {
        return findKing(N,N);
    }

    public int findKing(int N, int score){
        if(N>score)
            return N;
        Node node = nodes[N];
        for(int temp: node.children){
            if(temp==0)
                break;
            int res = findKing(temp, score);
            if(res!=-1)
                return res;
        }
        return -1;
    }
}