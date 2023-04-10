import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Q10867 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int prev=-1;
        int idx=0;
        while(idx<n){
            int number = array[idx];
            if(prev!=number){
                sb.append(number).append(" ");
                prev=number;
            }
            idx++;
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();

    }
}