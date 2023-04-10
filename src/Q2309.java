import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Q2309 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] height = new int[9];
        int sum=0;
        for(int i=0;i<9;i++){
            int tmp = Integer.parseInt(br.readLine());
            sum+=tmp;
            height[i]=tmp;
        }
        for(int i=0;i<9;i++){
            int x1 = height[i];
            if(sum-x1<101)
                continue;
            for(int j=i+1;j<9;j++){
                if(sum-x1-height[j]==100){
                    height[i]=height[j]=-1;
                    i=9;
                    break;
                }

            }
        }
        Arrays.sort(height);
        for(int i=2; i<9;i++){
            sb.append(height[i]).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}