package SamsungDxAlgorithm.No19;

class UserSolution {
    static Node front;
    static Node rear;
    static int mapSize;
    static int[][] map;
    static int distance;

    void bfs_init(int map_size, int mapInit[][]) {
        front = new Node();
        rear = front;
        mapSize = map_size;
        map = mapInit;
    }

    int bfs(int x1, int y1, int x2, int y2) {
        distance=-1;
        Node start = new Node(y1-1, x1 - 1, new boolean[mapSize][mapSize], -1);
        offer(start);
        while(front.next!=null)
            exeBfs(y2 - 1, x2 - 1);
        return distance;
    }

    void exeBfs(int targetX, int targetY) {
        Node node = poll();
        if (node != null) {
            node.visit();
            if (node.isDestination(targetX, targetY)) {
                if(distance==-1)
                    distance = node.distance;
                else if (distance > node.distance)
                    distance = node.distance;
                else
                    return;
            } else {
                boolean[][] visited = node.visited.clone();
                int curX = node.x;
                int curY = node.y;
                int[][] temp = new int[4][2];
                temp[0][0] = curX - 1;
                temp[0][1] = curY;
                temp[1][0] = curX + 1;
                temp[1][1] = curY;
                temp[2][0] = curX;
                temp[2][1] = curY - 1;
                temp[3][0] = curX;
                temp[3][1] = curY + 1;
                for (int[] position : temp) {
                    int x = position[0];
                    int y = position[1];
                    if (x < 0 || x >= mapSize || y < 0 || y >= mapSize || visited[x][y] || map[x][y]==1) {
                        continue;
                    }
                    offer(new Node(x, y, visited, node.distance));
                }
            }
        }
    }

    public Node poll() {
        Node node = front.next;
        if (node != null) {
            front.next = node.next;
        }
        return node;
    }

    public void offer(Node node) {
        if(front.next==null){
            rear = front;
        }
        rear.next = node;
        rear = node;
    }

    class Node {
        Node next;
        int x;
        int y;
        int distance;
        boolean[][] visited;

        Node() {
            this.next = null;
            this.x = -1;
            this.y = -1;
            this.distance = -1;
            this.visited = null;
        }

        Node(int x, int y, boolean[][] visited, int distance) {
            this.x = x;
            this.y = y;
            this.visited = visited;
            this.distance = distance;
        }

        void visit() {
            visited[x][y] = true;
            distance++;
        }

        boolean isDestination(int x, int y) {
            return this.x == x && this.y == y;
        }


    }

}
