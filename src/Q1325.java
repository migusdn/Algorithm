import java.io.*;
import java.util.*;

public class Q1325 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n,m;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int max=-1;
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        int[] reliability = new int[n+1];
        for(int i=0;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
        }

        for(int i=1; i<=n; i++){
            boolean[] visited = new boolean[n+1];
            bfs(graph,reliability,visited,i);
        }

        for(int i:reliability)
            max=Math.max(i,max);
        for(int i=1; i<=n; i++){
            if(reliability[i]==max)
                sb.append(i).append(" ");
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }
    public static void bfs(ArrayList<Integer>[] graph, int[] reliability, boolean[] visited, int node){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;
        while(!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int nodeNum : graph[currentNode]) {
                if(!visited[nodeNum]) {
                    reliability[nodeNum]++;
                    visited[nodeNum]=true;
                    queue.add(nodeNum);
                }
            }
        }
    }
}
