import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

class Q11724 {
    public static HashSet<Integer>[] graph;
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n,m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new HashSet[n+1];
        visited = new boolean[n+1];
        for(int i=1; i<n+1; i++){
            graph[i] = new HashSet<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int nodeNumber = Integer.parseInt(st.nextToken());
            int edgeNum = Integer.parseInt(st.nextToken());
            graph[nodeNumber].add(edgeNum);
            graph[edgeNum].add(nodeNumber);

        }
        int answer = 0;
        while(true){
            int i=1;
            for(; i<n+1; i++){
                if(visited[i]==false){
                    dfs(i);
                    break;
                }
            }
            if(i==n+1)
                break;
            else{
                answer++;
            }
        }
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
    public static void dfs(int nodeNumber){
        visited[nodeNumber]=true;
        for(int i:graph[nodeNumber]){
            if(!visited[i])
                dfs(i);
        }
    }
}