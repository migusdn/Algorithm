import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<Character>();
        int t = Integer.parseInt(br.readLine());
        for(int i=0;i<t;i ++){
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()){
                char[] str = st.nextToken().toCharArray();
                for(int j=0;j<str.length; j++)
                    stack.push(str[j]);
                while(!stack.isEmpty())
                    sb.append(stack.pop());
                sb.append(" ");
            }
            sb.append("\n");
        }
        bw.write(sb.toString());
        bw.close();
    }
}
