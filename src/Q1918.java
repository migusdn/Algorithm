import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Stack;

class Q1918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(infixToPostfix(br.readLine()));
        bw.close();
        br.close();
    }
    public static String infixToPostfix(String express) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char c;
        while (index < express.length()) {
            c = express.charAt(index);

            if (c >= 'A' && c <= 'Z') {
                sb.append(c);
            } else {
                if (c == ')') {
                    char topOperator;
                    while (!stack.isEmpty()) {
                        topOperator = stack.pop();
                        if (topOperator == '(') {
                            break;
                        } else {
                            sb.append(topOperator);
                        }
                    }
                } else if (c == '(') {
                    stack.push('(');
                } else if (c == '+' || c == '-' || c == '*' || c == '/') {
                    char topOperator;
                    if (c == '*' || c == '/') {
                        while (!stack.isEmpty()) {
                            topOperator = stack.peek();
                            if (topOperator == '+' || topOperator == '-' || topOperator == '(') {
                                break;
                            }
                            sb.append(stack.pop());
                        }
                    } else {
                        while (!stack.isEmpty()) {
                            topOperator = stack.peek();
                            if (topOperator == '(') {
                                break;
                            }
                            sb.append(stack.pop());
                        }
                    }
                    stack.push(c);
                } else {
                    return null;
                }
            }
            index++;
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}