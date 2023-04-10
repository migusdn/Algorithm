import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Q2606 {
    static int count=-1;
    public static void dfs(int[][] graph, boolean[] check, int v){
        if(check[v]==true) return;
        count++;
        check[v] = true;
        for(int i=0; i<graph[v].length; i++){
            if(graph[v][i]==1 && !check[i])
                dfs(graph,check,i);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] graph = new int[n+1][n+1];
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }
        dfs(graph,new boolean[n+1],1);
        System.out.println(count);
    }
}