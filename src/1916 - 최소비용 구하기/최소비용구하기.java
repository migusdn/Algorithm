/**
 * @package : Algorithm
 * @name : 최소비용구하기
 * @date : 3/5/24 9:49 PM
 * @author : hyunwoopark
 * @version : 1.0.0
 * @modifyed : $
 **/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class 최소비용구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        ArrayList<Bus>[] adjacencyList = new ArrayList[n + 1];
        for (int i = 1; i < n + 1; i++)
            adjacencyList[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int cost = Integer.parseInt(input[2]);
            adjacencyList[start].add(new Bus(end, cost));
        }
        String[] target = br.readLine().split(" ");
        int startPosition = Integer.parseInt(target[0]);
        int endPosition = Integer.parseInt(target[1]);
        PriorityQueue<Bus> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer(new Bus(startPosition, 0));
        distance[startPosition] = 0;

        while (!priorityQueue.isEmpty()) {
            Bus currentBus = priorityQueue.poll();
            int cur = currentBus.destination;
            if (!visited[cur]) {
                visited[cur] = true;
                for (Bus bus : adjacencyList[cur]) {
                    if (!visited[bus.destination] && distance[bus.destination] > distance[cur] + bus.cost) {
                        distance[bus.destination] = distance[cur] + bus.cost;
                        priorityQueue.add(new Bus(bus.destination, distance[bus.destination]));
                    }
                }
            }
        }
        System.out.println(distance[endPosition]);
    }
}

class Bus implements Comparable<Bus> {
    int destination;
    int cost;

    Bus(int destination, int cost) {
        this.destination = destination;
        this.cost = cost;
    }

    @Override
    public int compareTo(Bus o) {
        return cost - o.cost;
    }
}