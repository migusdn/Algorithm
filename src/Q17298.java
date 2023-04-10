import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        stack.push(0);
        for(int i=1; i<n; i++){
            while(!stack.isEmpty()&&numbers[stack.peek()]<numbers[i]){
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            result[stack.pop()] = -1;
        }
        for(int i=0; i<n; i++){
            sb.append(result[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
