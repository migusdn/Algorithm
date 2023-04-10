package SamsungDxAlgorithm;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class No23 {
    public static void main(String args[]) throws Exception {

        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            sb.append("#").append(test_case).append(" ");
			int n=sc.nextInt();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
			for(int i=0; i<n; i++){
				int cmd = sc.nextInt();
				if(cmd==1){
                    int temp = sc.nextInt();
                    maxHeap.offer(temp);
				}else{
                    Integer polledElement = maxHeap.poll();
                    if(polledElement==null)
                        sb.append("-1").append(" ");
                    else
                        sb.append(polledElement).append(" ");
                }
			}
            sb.append("\n");
        }
        System.out.println(sb);
    }
}