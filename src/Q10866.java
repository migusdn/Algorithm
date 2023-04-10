import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Q10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Deque deque = new Deque();
        for(int i=0;i<N;i++){
            String cmd;
            int value = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();
            if(st.hasMoreTokens())
                value = Integer.parseInt(st.nextToken());
            switch(cmd){
                case "push_front":{
                    deque.pushFront(value);
                    break;
                }
                case "push_back":{
                    deque.pushBack(value);
                    break;
                }
                case "pop_front":{
                    sb.append(deque.popFront()+"\n");
                    break;
                }
                case "pop_back":{
                    sb.append(deque.popBack()+"\n");
                    break;
                }
                case "size":{
                    sb.append(deque.size()+"\n");
                    break;
                }
                case "empty":{
                    sb.append(deque.empty()+"\n");
                    break;
                }
                case "front":{
                    sb.append(deque.front()+"\n");
                    break;
                }
                case "back":{
                    sb.append(deque.back()+"\n");
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static class Deque {
        List<Integer> deque;

        Deque() {
            this.deque = new ArrayList<>();
        }

        void pushFront(int x) {
            this.deque.add(0, x);
        }

        void pushBack(int x) {
            this.deque.add(x);
        }

        int popFront() {
            if (deque.isEmpty())
                return -1;
            else {
                int value = deque.get(0);
                deque.remove(0);
                return value;
            }
        }

        int popBack() {
            if (deque.isEmpty())
                return -1;
            else {
                int value = deque.get(deque.size() - 1);
                deque.remove(deque.size() - 1);
                return value;
            }
        }

        int size() {
            return deque.size();
        }

        int empty() {
            return deque.isEmpty() ? 1 : 0;
        }

        int front() {
            return deque.isEmpty() ? -1 : deque.get(0);
        }

        int back() {
            return deque.isEmpty() ? -1 : deque.get(deque.size() - 1);
        }
    }
}