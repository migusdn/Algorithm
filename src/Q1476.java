import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1476 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int e = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int e1=1;
        int s1=1;
        int m1=1;
        int count=1;
        while(!(e==e1&&s==s1&&m==m1)){
            if(e1==15)
                e1=1;
            else
                e1++;
            if(s1==28)
                s1=1;
            else
                s1++;
            if(m1==19)
                m1=1;
            else
                m1++;
            count++;
        }
        System.out.println(count);

    }
}