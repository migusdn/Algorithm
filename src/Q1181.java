import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;

class Q1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        List<String> word = new ArrayList<>();
        for(int i=0;i<N;i++){
            String tmp = br.readLine();
            if(!word.contains(tmp))
                word.add(tmp);
        }
        String[] words=word.toArray(new String[0]);
        Arrays.sort(words,(s1,s2)->{
            if(s1.length()==s2.length()){
                return s1.compareTo(s2);
            }else{
                return s1.length()-s2.length();
            }
        });
        for(String str:words) {
            sb.append(str).append("\n");
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }
}