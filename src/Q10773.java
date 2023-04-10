import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Q10773 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int K = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();
        int sum=0;
        for(int i=0; i<K; i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp==0) {
                nums.remove(nums.size()-1);
            }
            else {
                nums.add(tmp);
            }
        }
        for(int n:nums){
            sum+=n;
        }
        bw.write(sum+"");
        bw.close();
        br.close();
    }
}