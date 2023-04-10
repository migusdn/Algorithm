import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q2751 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<n; i++){
            nums.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(nums);
        for(int i=0; i<n;i++){
            sb.append(nums.get(i)).append("\n");
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();

    }
}
