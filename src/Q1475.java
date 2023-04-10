import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Q1475 {
    //숫자카드 한 세트에는 각 번호가 0~9까지 있다.
    //방번호를 표현해야한다.
    //
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] numberCount = new int[10];
        int requireCount = 0;
        char[] roomNumberCharArray = br.readLine().toCharArray();
        for(char c:roomNumberCharArray){
            int idx = c-'0';
            if(idx==9)
                numberCount[6]++;
            else
                numberCount[c-'0']++;
        }
        numberCount[6] = numberCount[6]/2+numberCount[6]%2;
        Arrays.sort(numberCount);
        bw.write(String.valueOf(numberCount[numberCount.length-1]));
        bw.close();
        br.close();
    }
}