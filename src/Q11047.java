import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        int[] coin = new int[N];
        int ctn = 0;
        for(int i=0 ; i<N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }
        for(int i = N-1; i>=0; i--){
            if(total == 0 )
                break;
            ctn += total / coin[i];
            total %=coin[i];
        }
        bw.write(String.valueOf(ctn));
        bw.close();
        br.close();

    }
}