import java.io.*;

public class Q2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[][] apart = new int[15][15];
        for(int i=0; i<15; i++){
            apart[i][0]=1;
            apart[0][i]=i+1;
        }
        for(int i=1; i<15; i++){
            for(int j=0;j<14;j++){
                apart[i][j+1] = apart[i][j]+apart[i-1][j+1];
            }
        }
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            sb.append(apart[x][y-1]).append("\n");
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();

    }
}
