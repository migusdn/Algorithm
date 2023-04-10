import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Q11650mis {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Que queue = new Que();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            Integer value = null;
            if (st.hasMoreTokens())
                value = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case "push": {
                    queue.push(value);
                    break;
                }
                case "pop": {
                    sb.append(queue.pop() + "\n");
                    break;
                }
                case "size": {
                    sb.append(queue.size() + "\n");
                    break;
                }
                case "empty": {
                    sb.append(queue.isEmpty() + "\n");
                    break;
                }
                case "front": {
                    sb.append(queue.front() + "\n");
                    break;
                }
                case "back": {
                    sb.append(queue.back() + "\n");
                    break;
                }
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static class Que {
        List<Integer> queue = new ArrayList<>();
        public void push(int x) {
            queue.add(x);
        }

        public int pop() {
            if(queue.isEmpty())
                return -1;
            int value = queue.get(0);
            queue.remove(0);
            return value;
        }

        public int size() {
            return queue.size();
        }

        public int isEmpty() {
            if (queue.isEmpty()) {
                return 1;
            } else {
                return 0;
            }
        }

        public int front() {
            if (!queue.isEmpty())
                return queue.get(0);
            else
                return -1;
        }

        public int back() {
            if (!queue.isEmpty())
                return queue.get(this.size() - 1);
            else
                return -1;
        }
    }
}