import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.StringTokenizer;

class Q1697 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] visit = new int[100001];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(n);
        visit[n] = 1;
        while(!queue.isEmpty()){
            int tmp = queue.poll();
            int[] next = {tmp-1, tmp+1, tmp*2};
            for(int nextNum:next){
                if(nextNum==k){
                    bw.write(String.valueOf(visit[tmp]));
                    bw.close();
                    return;
                }
                if(nextNum>=0 && nextNum<visit.length && visit[nextNum]==0){
                    queue.offer(nextNum);
                    visit[nextNum] = visit[tmp]+1;
                }
            }
        }
    }
}