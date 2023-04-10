import java.io.*;

public class Q1157 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine().toUpperCase();
        int[] temp = new int[26];
        for(int i=0 ;i<str.length();i++){
            int c = str.charAt(i)-65;
            temp[c]++;
        }
        int max=-1;
        int res=0;
        boolean flag = false;
        for(int i=0;i<26;i++){
            if(max<temp[i]) {
                max = temp[i];
                res=i;
                flag=false;
            }
            else if(max==temp[i]) {
                flag = true;
            }
        }
        if(!flag)
            bw.write((char)(res+65)+"\n");
        else
            bw.write("?");
        bw.close();
        br.close();
    }
}
