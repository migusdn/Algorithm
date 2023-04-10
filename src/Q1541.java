import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringTokenizer;

class Q1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(),"-");
        ArrayList<Long> numbers = new ArrayList<>();
        while(st.hasMoreTokens()){
            String str = st.nextToken();
            long sum=0;
            StringTokenizer tmp = new StringTokenizer(str,"+");
            while(tmp.hasMoreTokens()){
                sum+=Long.parseLong(tmp.nextToken());
            }
            numbers.add(sum);
        }
        long result = numbers.get(0);
        numbers.remove(0);
        for(Iterator<Long> it = numbers.iterator(); it.hasNext();){
            result-=it.next();
        }
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}