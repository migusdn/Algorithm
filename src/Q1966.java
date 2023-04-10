import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class Q1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int i=0; i<T;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            List<Integer> priority=new ArrayList<>();
            List<Map.Entry> documents = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                int p = Integer.parseInt(st.nextToken());
                priority.add(p);
                documents.add(new AbstractMap.SimpleEntry<Integer, Integer>(j,p));
            }
            priority = priority.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            int pop=-1;
            int count=0;
            while(pop!=M){
                int highPrior = priority.get(0);
                Map.Entry<Integer, Integer> entry = documents.get(0);
                if(highPrior==entry.getValue()){
                    count++;
                    priority.remove(0);
                    documents.remove(0);
                    pop= entry.getKey();
                }else{
                    documents.remove(0);
                    documents.add(entry);
                }
            }
            sb.append(count).append("\n");
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }
}