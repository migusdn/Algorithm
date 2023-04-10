import java.io.*;

public class Q2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int max=0;
        int seq=0;
        for(int i=1 ;i<=9;i++){
            int tmp=Integer.parseInt(br.readLine());
            if(max<tmp){
                max=tmp;
                seq=i;
            }
        }
        bw.write(max+"\n"+seq);
        bw.close();
        br.close();
    }
}
