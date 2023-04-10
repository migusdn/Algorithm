
import java.io.*;
import java.util.StringTokenizer;

class Q12865 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] W = new int[N];
        int[] V = new int[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }
        int max=0;
        for(int i=0;i<N;i++)
            for(int j=0; j<N; j++){
                if(i==j) {
                    if (max < V[i])
                        max = V[i];
                    continue;
                }
                else if(W[i]+W[j]>7)
                    continue;
                else if(max<(V[i]+V[j]))
                    max=V[i]+V[j];
            }
        bw.write(max);
        bw.close();
        br.close();
    }
}
