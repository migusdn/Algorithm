import java.io.*;
import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Q1287 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        BigDecimal bigDecimal = solvePostfix(infixToPostfix(input));
        if (bigDecimal == null)
            bw.write("ROCK");
        else
            bw.write(bigDecimal.setScale(10,BigDecimal.ROUND_HALF_UP).toBigInteger().toString());
        bw.close();
        br.close();
    }

    public static Queue<Object> infixToPostfix(String express) {
        Stack<Character> stack = new Stack<>();
        Queue<Object> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        char c;
        while (index < express.length()) {
            c = express.charAt(index);

            if (c >= '0' && c <= '9') {
                sb.append(c);
            } else {
                if (sb.length() != 0) {
                    result.add(new BigDecimal(sb.toString()));
                    sb = new StringBuilder();
                }
                if (c == ')') {
                    char topOperator;
                    while (!stack.isEmpty()) {
                        topOperator = stack.pop();
                        if (topOperator == '(') {
                            break;
                        } else {
                            result.add(topOperator);
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
                            result.add(stack.pop());
                        }
                    } else {
                        while (!stack.isEmpty()) {
                            topOperator = stack.peek();
                            if (topOperator == '(') {
                                break;
                            }
                            result.add(stack.pop());
                        }
                    }
                    stack.push(c);
                } else {
                    return null;
                }
            }
            index++;
        }
        if (sb.length() != 0) {
            result.add(new BigDecimal(sb.toString()));
        }
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    public static BigDecimal solvePostfix(Queue express) {
        if (express == null)
            return null;
        Stack<BigDecimal> stack = new Stack<>();
        while (!express.isEmpty()) {
            Object o = express.poll();
            if (o instanceof BigDecimal) {
                stack.push((BigDecimal) o);
            } else {
                char c = (char) o;
                if (stack.size() < 2)
                    return null;
                BigDecimal right = stack.pop();
                BigDecimal left = stack.pop();
                if (c == '*') {
                    stack.push(left.multiply(right));
                } else if (c == '-') {
                    stack.push(left.subtract(right));
                } else if (c == '+') {
                    stack.push(left.add(right));
                } else if (c == '/') {
                    stack.push(left.divide(right,10,BigDecimal.ROUND_CEILING));
                }
            }
        }
        if (stack.size() != 1)
            return null;
        return stack.pop();
    }
}