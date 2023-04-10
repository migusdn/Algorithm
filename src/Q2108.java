import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Q2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];
        HashMap<Integer, Integer> f = new HashMap<>();
        List<Integer> modeList = new ArrayList<>();
        int mode=0;
        double sum=0;
        for(int i=0 ;i<N;i++){
            int tmp = Integer.parseInt(br.readLine());
            if(i==0)
                mode=tmp;
            nums[i]= tmp;
            sum+=tmp;
            if(f.containsKey(tmp)) {
                f.put(tmp, f.get(tmp) + 1);
                if(f.get(mode)<f.get(tmp))
                    mode=tmp;
            }
            else
                f.put(tmp,1);
        }
        int modeValue = f.get(mode);
        for(Map.Entry entry:f.entrySet()){
            if((Integer)entry.getValue()==modeValue)
                modeList.add((Integer) entry.getKey());
        }
        if(modeList.size()!=1){
            mode = (int) modeList.stream().sorted().toArray()[1];
        }

        Arrays.sort(nums);
        sb.append(Math.round(sum/N)+"\n");
        sb.append(nums[N/2]+"\n");
        sb.append(mode+"\n");
        sb.append(nums[N-1]-nums[0]+"\n");
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}