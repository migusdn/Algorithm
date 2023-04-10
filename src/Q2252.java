import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Q2252 {
    public static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n, m;
        int[] w;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        w=new int[n+1];
        for(int i=1; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            w[b]++;
        }
        topologySort(graph, w);
        for(int i:result)
            sb.append(i).append(" ");
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
    public static void topologySort(ArrayList<Integer>[] graph, int[] w){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i< w.length; i++){
            if(w[i]==0)
                queue.add(i);
        }
        while(!queue.isEmpty()){
            int currentNode = queue.poll();
            result.add(currentNode);
            for(int i:graph[currentNode]){
                w[i]--;
                if(w[i]==0)
                    queue.add(i);
            }
        }
    }

}