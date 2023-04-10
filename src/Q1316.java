import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n=Integer.parseInt(br.readLine());
        int count=0;
        for(int i=0;i<n;i++){
            int[] nums = new int[26];
            int prev=0;
            count++;
            for(char c:br.readLine().toCharArray()){
                if(c==prev)
                    continue;
                else if(nums[c-'a']==0){
                    prev=c;
                    nums[c-'a']=1;
                }else{
                    count--;
                    break;
                }

            }
        }
        bw.write(count+"");
        bw.close();
        br.close();
    }
}