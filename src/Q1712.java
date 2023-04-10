import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class
Q1712 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        if(B>=C)
            bw.write("-1");
        else
            bw.write(String.valueOf((A/(C-B)) + 1));

        bw.close();
        br.close();
        // 총 수입 = 판매 단가 * 개수
        // 총 비용 = 고정 비용 + 생산 단가 * 개수
        // 총 수입 > 총 비용 일때의 개수를 구하라
        // 판매 단가 * 개수 > 고정비용 + 생산단가 * 개수
        // (판매 단가 - 생산단가) * 개수 > 고정비용
        // 개수>고정비용 / (판매단가 - 생산단가)





    }
}