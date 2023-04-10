import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class Q11866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Integer[] nums;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        nums = new Integer[N];
        for(int i=0; i<N;i++){
            nums[i] = i+1;
        }
        sb.append("<");
        List<Integer> yose = new ArrayList<>(Arrays.asList(nums));
        int cursor=-1;
        while(!yose.isEmpty()){
            for(int i=0; i<K;i++){
                cursor++;
                if(cursor==yose.size())
                    cursor=0;
            }
            int val = yose.get(cursor);
            sb.append(val).append(", ");
            yose.remove(cursor);
            if(cursor==0)
                cursor=yose.size()-1;
            else
                cursor--;
        }
        sb.delete(sb.lastIndexOf(","),sb.lastIndexOf(" ")+1);
        sb.append(">");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}