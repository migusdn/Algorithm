

import java.io.*;
import java.util.*;


public class Q18352 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n, m, k, x;
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> answer = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer>[] adjacencyList;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        adjacencyList = new ArrayList[n + 1];
        int[] visited = new int[n+1];
        for (int i = 0; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
            visited[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeNumber = Integer.parseInt(st.nextToken());
            int connectedNodeNumber = Integer.parseInt(st.nextToken());
            adjacencyList[nodeNumber].add(connectedNodeNumber);
        }
        bfs(adjacencyList,visited,x);
        for(int i=0 ;i<=n; i++){
            if(visited[i]==k)
                answer.add(i);
        }
        answer.sort(Comparator.naturalOrder());
        for(int i:answer){
            sb.append(i).append(" ");
        }
        if(answer.isEmpty()){
            bw.write("-1");
        }else{
            bw.write(sb.toString());
        }
        bw.close();
        br.close();
    }
    public static void bfs(ArrayList<Integer>[] adjacencyList, int[] visited,int x){
        Queue<Integer> nodes = new LinkedList<>();
        nodes.add(x);
        visited[x]++;
        while (!nodes.isEmpty()){
            int currentNode = nodes.poll();
            for(int i: adjacencyList[currentNode]){
                if(visited[i]==-1){
                    visited[i] = visited[currentNode]+1;
                    nodes.add(i);
                }
            }
        }

    }
}
