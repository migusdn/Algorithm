import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q2609 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        sb.append(gcd(x,y)).append("\n");
        sb.append(lcm(x,y));
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    public static int gcd(int x, int y){

        if(x<y){
            int tmp = x;
            x=y;
            y=tmp;
        }
        int remain = x%y;
        if(remain ==0)
            return y;
        else{
            return gcd(y,remain);
        }
    }
    public static int lcm(int x, int y){
        int i=x;
        int j=y;
        while(i!=j){
            if(i<j){
                i+=x;
            }else{
                j+=y;
            }
        }
        return i;
    }
}