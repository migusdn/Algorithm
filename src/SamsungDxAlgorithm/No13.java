package SamsungDxAlgorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class No13 {
    static int maxProcess;
    static int minPower;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int graphSize;
    static Position[] cores;
    static int[][] matrix;
    static int processCnt;

    public static void main(String args[]) throws Exception {

        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            maxProcess = 0;
            minPower = -1;
            graphSize = sc.nextInt();
            processCnt = 0;
            cores = new Position[12];
            matrix = new int[graphSize + 1][graphSize + 1];
            for (int i = 1; i <= graphSize; i++) {
                for (int j = 1; j <= graphSize; j++) {
                    int temp = sc.nextInt();
                    if (temp == 1) {
                        matrix[i][j] = temp;
                        if (i == 1 || i == graphSize || j == 1 || j == graphSize){
                            continue;
                        }
                        cores[processCnt] = new Position(i, j);
                        processCnt++;
                    }
                }

            }
            dfs(0, 0, 0);
            sb.append("#").append(test_case).append(" ").append(minPower).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int curIdx, int connectedProcess, int curPower) {
        if (curIdx == processCnt) {
            if (connectedProcess > maxProcess) {
                maxProcess = connectedProcess;
                minPower = curPower;
            } else if (connectedProcess == maxProcess) {
                if (minPower > curPower)
                    minPower = curPower;
            }
            return;
        }
        Position processPosition = cores[curIdx];
        for (int i = 0; i < 4; i++) {
            boolean flag = false;
            List<Position> temp = new LinkedList<>();
            int curX = processPosition.x;
            int curY = processPosition.y;
            while (true) {
                if (curX == 1 || curX == graphSize || curY == 1 || curY == graphSize) {
                    flag = true;
                    break;
                }
                curX += dx[i];
                curY += dy[i];
                if (matrix[curX][curY] == 0) {
                    Position pTemp = new Position(curX, curY);
                    temp.add(pTemp);
                } else
                    break;
            }
            if (flag) {
                for (Position p : temp) {
                    matrix[p.x][p.y] = -1;
                }
                dfs(curIdx + 1, connectedProcess + 1, curPower + temp.size());
                for (Position p : temp) {

                    matrix[p.x][p.y] = 0;
                }
            }
        }
        dfs(curIdx + 1, connectedProcess, curPower);
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}