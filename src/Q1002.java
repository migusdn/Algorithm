import java.io.*;
import java.util.StringTokenizer;

public class Q1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int[] x = new int[2];
        int[] y = new int[2];
        int[] r = new int[3];
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<2; j++) {
                x[j] = Integer.parseInt(st.nextToken());
                y[j] = Integer.parseInt(st.nextToken());
                r[j] = Integer.parseInt(st.nextToken());
            }
            if(x[0]==x[1]&&y[0]==y[1]&&r[0]==r[1]) {
                sb.append("-1\n");
                continue;
            }
            r[2] = (x[0]-x[1])*(x[0]-x[1])+(y[0]-y[1])*(y[0]-y[1]);
            sb.append("r1:"+r[0]+"r2:"+r[1]+"r3:"+r[2]+"\n");
            if(x[0]==x[1]&&y[0]==y[1]&&r[0]==r[1])
                sb.append("-1\n");
            if(Math.pow(r[0]-r[1],2)==r[2])
                sb.append("1\n");
            else if(Math.pow(r[0]+r[1],2)<r[2])
                sb.append("0\n");
            else if(Math.pow(r[0]+r[1],2)==r[2])
                sb.append("1\n");
            else if(Math.pow(r[0]-r[1],2)<r[2])
                sb.append("0\n");
            else if(Math.pow(r[0]+r[1],2)>r[2])
                sb.append("2\n");


        }
        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
