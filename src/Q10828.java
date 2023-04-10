import java.io.*;
import java.util.StringTokenizer;

public class Q10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        Stack stack = new Stack();
        for(int i=0; i<T; i++){
            st=new StringTokenizer(br.readLine());
            switch(st.nextToken()){
                case "push":{
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                }
                case "top":{
                    sb.append(stack.top()+"\n");
                    break;
                }
                case "pop":{
                    sb.append(stack.pop()+"\n");
                    break;
                }
                case "size":{
                    sb.append(stack.size()+"\n");
                    break;
                }
                case "empty":{
                    sb.append(stack.empty()+"\n");
                    break;
                }

            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    private static class Stack{
        private int[] stack;
        private int top=-1;
        Stack(){
            stack=new int[10000];
        }
        private void push(int val){
            top++;
            stack[top] = val;
        }
        private int pop(){
            if(top==-1)
                return top;
            top--;
            return stack[top+1];
        }
        private int size(){
            return top+1;
        }
        private int empty(){
            return top==-1 ? 1 : 0;
        }
        private int top(){
            return top==-1? -1 :stack[top];
        }
    }

}
