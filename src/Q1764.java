import java.io.*;
import java.util.*;

public class Q1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String,String> words = new HashMap<>();
        List<String> result = new ArrayList<>();
        for(int i=0; i<n; i++){
            words.put(br.readLine(),null);
        }
        for(int i=0;i<m;i++){
            String tmpString = br.readLine();
            if(words.containsKey(tmpString))
                result.add(tmpString);
        }
        result.sort(Comparator.naturalOrder());
        sb.append(result.size()).append("\n");
        for(String s:result){
            sb.append(s).append("\n");
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }
}
