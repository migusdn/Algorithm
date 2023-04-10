import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q6588 {
    static Boolean[] prime = new Boolean[1000000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int number = Integer.parseInt(br.readLine());
        while(number!=0){
            for(int i=3;i<number-2;i++){
                if(isPrime(i)&&isPrime((number-i))) {
                    sb.append(number).append(" ").append("=")
                            .append(" ").append(i).append(" + ").append(number - i).append("\n");
                    break;
                }
            }
            number=Integer.parseInt(br.readLine());
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    public static boolean isPrime(int number){
        if(prime[number]!=null)
            return prime[number];
        else{
            for(int i=2;i<number;i++){
                if(number%i==0){
                    prime[number]=false;
                    return false;
                }
            }
            prime[number]=true;
            return true;
        }


    }
}