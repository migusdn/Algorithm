import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : DSLR
 * @date : 2/26/24 10:53 PM
 * @modifyed : $
 **/
public class DSLR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] visited;
        String[] logs;
        Queue<Integer> queue;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            visited = new boolean[10000];
            logs = new String[10000];
            queue = new LinkedList<>();
            String[] inputs = br.readLine().split(" ");
            int start = Integer.parseInt(inputs[0]);
            int dest = Integer.parseInt(inputs[1]);
            visited[start] = true;
            logs[start] = "";
            queue.offer(start);
            while(!queue.isEmpty()&&!visited[dest]){
                int current = queue.poll();
                int d = d(current);
                int s = s(current);
                int l = l(current);
                int r = r(current);
                if(!visited[d]){
                    queue.offer(d);
                    visited[d] = true;
                    logs[d] = logs[current]+"D";
                }
                if(!visited[s]){
                    queue.offer(s);
                    visited[s] = true;
                    logs[s] = logs[current]+"S";
                }
                if(!visited[l]){
                    queue.offer(l);
                    visited[l] = true;
                    logs[l] = logs[current]+"L";
                }
                if(!visited[r]){
                    queue.offer(r);
                    visited[r] = true;
                    logs[r] = logs[current]+"R";
                }
            }
            System.out.println(logs[dest]);
        }
    }

    public static int d(int num) {
        num <<= 1;
        if (num > 9999)
            num %= 10000;
        return num;
    }

    public static int s(int num) {
        if (num == 0)
            return 9999;
        else
            return num - 1;
    }

    public static int l(int num) {
        return num % 1000 * 10 + num / 1000;
    }

    public static int r(int num) {
        return num % 10 * 1000 + num / 10;
    }
}
