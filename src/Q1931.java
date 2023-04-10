import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Q1931 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] times = new int[n][2];
        for(int i=0;i<n;i++){
            String[] temp = br.readLine().split(" ");
            times[i][0]=Integer.parseInt(temp[0]);
            times[i][1]=Integer.parseInt(temp[1]);
        }
        Arrays.sort(times, (int[] a, int[] b)->{
            if(a[1]==b[1]){
                return a[0]-b[0];
            }else{
                return a[1]-b[1];
            }
        });
        int currentTime=0;
        int count=0;
        int i=0;
        while(i<n){
            int start=times[i][0];
            int end=times[i][1];
            if(start>=currentTime) {
                currentTime = end;
                count++;
            }
            i++;
        }
        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }
}