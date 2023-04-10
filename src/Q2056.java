import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Q2056 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] times = new int[n+1];
        int[] w = new int[n+1];
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=1; i<n+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=1; i<n+1; i++){
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            times[i]=time;
            st.nextToken();
            while(st.hasMoreTokens()) {
                int nodeNum =Integer.parseInt(st.nextToken());
                graph[i].add(nodeNum);
                w[nodeNum]++;
            }
        }


    }
    public static void topologySort(ArrayList<Integer>[] graph, int[] w){

    }
}