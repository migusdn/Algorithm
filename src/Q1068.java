import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Q1068 {
    static int[][] edges;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        edges = new int[n][];
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        for(int i=1; i<n; i++){
            int parent = Integer.parseInt(st.nextToken());
            if(edges[parent]==null){
                edges[parent] = new int[2];
                edges[parent][0]=i;
                edges[parent][1]=-1;
            }else{
                edges[parent][1]=i;
            }
        }
        int count = 0;
        int target = Integer.parseInt(br.readLine());
        if(target!=0) {
            count=-1;
            delete(target);
            for (int i = 0; i < edges.length; i++) {
                int[] test = edges[i];
                if (test != null)
                    for (int a : test) {
                        if (edges[a] == null)
                            count++;
                    }
            }

        }
        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }
    public static void delete(int target){
        int[] tmp = edges[target];
        if(tmp==null)
            return;
        if(tmp[0]!=-1)
            delete(tmp[0]);
        if(tmp[1]!=-1)
            delete(tmp[1]);
        edges[target]=null;
    }
}