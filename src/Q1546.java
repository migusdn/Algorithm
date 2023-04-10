import java.io.*;
import java.util.StringTokenizer;

public class Q1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        double[] score = new double[t];
        double max=0;
        for(int i=0; i<t; i++){
            score[i] = Double.parseDouble(st.nextToken());
            if(score[i]>max)
                max = score[i];
        }
        double result = 0;
        for(int i=0; i<t; i++){
            result+= score[i]/max*100;
        }
        bw.write(result/t+"");
        bw.close();
        br.close();
    }
}
