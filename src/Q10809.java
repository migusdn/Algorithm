import java.io.*;

public class Q10809 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //97번부터
        char[] str = br.readLine().toCharArray();
        int[] res = new int[26];
        for(int i=0;i<26;i++)
            res[i]=-1;
        for(int i=0;i<str.length; i++){
            int c=str[i]-97;
            if(i==0&&res[c]==-1)
                res[c]=0;
            else if(res[c]==-1)
                res[c]=i;
        }
        for(int n:res)
            bw.write(n+" ");
        bw.close();
        br.close();
    }
}
