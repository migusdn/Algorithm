import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        System.out.println(makeOne(N,0));
        bw.close();
        br.close();
    }
    public static int makeOne(int num,int count){
        if(num<2)
            return count;
        return Math.min(makeOne(num/2,count+1+num%2),makeOne(num/3,count+1+num%3));
    }
}