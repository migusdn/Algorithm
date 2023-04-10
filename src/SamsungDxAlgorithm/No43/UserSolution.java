package SamsungDxAlgorithm.No43;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class UserSolution {
    // 인접 리스트를 저장할 리스트
    private List<List<Edge>> adjList = new ArrayList<>();
    // 도시의 총 개수
    private int numOfCities = 0;

    public int init(int N, int[] sCity, int[] eCity, int[] mCost) {
        // 도시의 개수 초기화
        numOfCities = N;
        // 인접 리스트 초기화
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        // 각 도로의 정보를 인접 리스트에 추가
        for (int i = 0; i < N; i++) {
            int from = sCity[i] - 1;
            int to = eCity[i] - 1;
            int cost = mCost[i];
            adjList.get(from).add(new Edge(to, cost));
        }
        // 도시의 총 개수 반환
        return numOfCities;
    }

    public void add(int sCity, int eCity, int mCost) {
        // 새로운 도로 추가
        int from = sCity - 1;
        int to = eCity - 1;
        int cost = mCost;
        adjList.get(from).add(new Edge(to, cost));
    }

    public int cost(int mHub) {
        // 허브 도시의 인덱스
        int hub = mHub - 1;
        // 각 도시에서 허브 도시까지의 최소 비용을 저장할 배열
        int[] dist = new int[numOfCities];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[hub] = 0;
        // 우선순위 큐를 사용한 다익스트라 알고리즘
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(hub, 0));
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int currCity = curr.city;
            int currDist = curr.dist;
            // 이미 최소 비용을 구한 도시는 스킵
            if (currDist > dist[currCity]) {
                continue;
            }
            for (Edge edge : adjList.get(currCity)) {
                int nextCity = edge.to;
                int nextDist = currDist + edge.cost;
                // 최소 비용을 갱신할 경우, 우선순위 큐에 추가
                if (nextDist < dist[nextCity]) {
                    dist[nextCity] = nextDist;
                    pq.add(new Node(nextCity, nextDist));
                }
            }
        }
        // 각 도시에서 허브 도시까지 왕복에 필요한 최소 비용의 합을 계산
        int totalCost = 0;
        for (int i = 0; i < numOfCities; i++) {
            if (dist[i] != Integer.MAX_VALUE) {
                totalCost += dist[i];
            }
        }
        // 총 운송 비용 반환
        return totalCost;
    }

    // 간선 정보를 저장하는 클래스
    private static class Edge {
        int to;
        int cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
    static class Node implements Comparable<Node>{
        int city;
        int dist;
        Node(int city, int dist){
            this.city = city;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist,o.dist);
        }
    }

}
