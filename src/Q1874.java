import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

class Q1874 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int count=1;
        for(int i=0; i<n;i++){
            int num = Integer.parseInt(br.readLine());
            if(stack.empty()){
                stack.push(count);
                count++;
                sb.append("+").append("\n");
            }
            while(stack.peek()!=num&&count<n+1){
                stack.push(count);
                count++;
                sb.append("+").append("\n");
            }
            if(stack.peek()==num) {
                sb.append("-").append("\n");
                stack.pop();
            }else{
                break;
            }
        }
        if(stack.isEmpty())
            bw.write(sb.toString().trim());
        else bw.write("NO");
        bw.close();
        br.close();
    }
}