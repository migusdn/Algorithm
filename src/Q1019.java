import java.io.*;

public class Q1019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] result=new int[10];
        for(int i=1; i<=n;i++){
            char[] tmp = String.valueOf(i).toCharArray();
            for(int j=0;j<tmp.length;j++){
                result[tmp[j]-48]++;
            }
        }
        for(int i=0;i<10;i++)
            sb.append(result[i]+" ");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
