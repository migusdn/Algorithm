import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Q11651 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[][] dots;
        int N = Integer.parseInt(br.readLine());
        dots = new int[N][2];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            dots[i][0]=Integer.parseInt(st.nextToken());
            dots[i][1]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(dots, (e1,e2)->{
            if(e1[1]==e2[1])
                return e1[0]-e2[0];
            else
                return e1[1]-e2[1];
        });
        for(int i=0;i<N;i++) {
            sb.append(dots[i][0]).append(" ").append(dots[i][1]).append("\n");
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }
}