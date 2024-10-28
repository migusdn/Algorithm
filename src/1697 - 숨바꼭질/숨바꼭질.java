/**
 * @package : Algorithm
 * @name : 숨바꼭질
 * @date : 1/1/24 7:23 PM
 * @author : hyunwoopark
 * @version : 1.0.0
 * @modifyed : $
 **/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class 숨바꼭질 {
    public static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = br.readLine().split(" ");

        //수빈이의 현 위치 N
        n = Integer.parseInt(temp[0]);

        //동생의 현 위치 K
        k = Integer.parseInt(temp[1]);

        //걷는다면 +- 1 순간이동시 2*X 수빈이가 동생을 찾는 최단 시간을 구하라
        //bfs
        //앞으로 이동, 뒤로 이동, 순간이동
        System.out.println(bfs());
    }

    public static int bfs() {
        //가능한 좌표의 범위 0 ~ 100,000
        int[] visited = new int[100001];
        visited[n] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int time = visited[cur];
            if (cur == k) {
                return time - 1;
            }
            //-1 이동
            if (cur - 1 >= 0 && visited[cur - 1] == 0) {
                visited[cur - 1] = time + 1;
                queue.offer(cur-1);
            }
            //+1 이동
            if( cur +1 <=100000 && visited[cur+1] ==0 ){
                visited[cur +1] = time +1;
                queue.offer(cur+1);
            }
            //텔레포트
            if(cur*2<=100000 && visited[cur*2] ==0){
                visited[cur*2] = time+1;
                queue.offer(cur*2);
            }
        }
        return -1;
    }

}
