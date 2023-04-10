package SamsungDxAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class No25 {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int result = 0;
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
            maxHeap.add(m);
            for(int i=0; i<n; i++){
                for(int j=0; j<2; j++){
                    if(maxHeap.size()==minHeap.size()){
                        maxHeap.offer(sc.nextInt());
                    }else{
                        minHeap.offer(sc.nextInt());
                    }
                    if(!minHeap.isEmpty() && maxHeap.peek()> minHeap.peek()){
                        int temp = minHeap.poll();
                        minHeap.offer(maxHeap.poll());
                        maxHeap.offer(temp);
                    }
                }
                result += maxHeap.peek()%20171109;
                result=result%20171109;
            }



            sb.append("#").append(test_case).append(" ").append(result).append("\n");

        }
        System.out.println(sb);
    }
}
