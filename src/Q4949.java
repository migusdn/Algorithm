import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;
import java.util.StringTokenizer;

class Q4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String tmp = br.readLine();
        Stack<Character> stack = new Stack<>();
        while(!tmp.equals(".")){
            char[] tmpChar = tmp.toCharArray();
            for(char c:tmpChar){
                if(c=='(') {
                    stack.push(c);
                }
                else if(c==')') {
                    if(stack.isEmpty()) {
                        stack.push('0');
                        break;
                    }
                    else if(stack.peek()=='[') {
                        break;
                    }
                    stack.pop();
                }
                if(c=='[') {
                    stack.push(c);
                }
                else if(c==']') {
                    if(stack.isEmpty()) {
                        stack.push('0');
                        break;
                    }
                    else if(stack.peek()=='(') {
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty())
                sb.append("yes\n");
            else {
                sb.append("no\n");
                stack.clear();
            }
            tmp = br.readLine();
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}