import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : PriorityQueue
 * @date : 2/27/24 9:14 PM
 * @modifyed : $
 **/
public class 최소힙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                if (priorityQueue.isEmpty())
                    System.out.println(0);
                else
                    System.out.println(priorityQueue.poll());
            } else
                priorityQueue.offer(temp);
        }
    }
}
