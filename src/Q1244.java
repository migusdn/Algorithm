import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1244 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        boolean[] status = new boolean[t+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<t+1; i++){
            if(st.nextToken().equals("1"))
                status[i]=true;
            else
                status[i]=false;
        }
        int n=Integer.parseInt(br.readLine());
        for(int i=0; i<n;i++){
            st = new StringTokenizer(br.readLine());
            if(st.nextToken().equals("1")){
                int a = Integer.parseInt(st.nextToken());
                int j=a;
                while(j<t+1){
                    status[j]=!status[j];
                    j+=a;
                }
            }else{
                int a = Integer.parseInt(st.nextToken());
                int j=1;
                int k=-1;
                status[a] = !status[a];
                while(a+k>0&&a+j<t+1){
                    if(status[a+j]==status[a+k])
                        status[a+j]=status[a+k]=!status[a+j];
                    else
                        break;
                    j++;
                    k--;
                }
            }
        }
        for(int i=1;i<t+1;i++){

            if (status[i]) {
                sb.append("1");
            } else {
                sb.append("0");
            }
            if(i%20==0)
                sb.append("\n");
            else
                sb.append(" ");
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();

    }
}