import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for(int i=0; i<N; i++){
            int tmp = Integer.parseInt(st.nextToken());
            if(isPrime(tmp))
                count++;
        }
        bw.write(count+"");
        bw.close();
        br.close();
    }
    public static boolean isPrime(int num){
        if(num<2)
            return false;
        for(int i=2;i<=num/2;i++){
            if(num%i==0)
                return false;
        }
        return true;
    }
}