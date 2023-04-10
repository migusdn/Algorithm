package SamsungDxAlgorithm.practice.No7;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class UserSolution {
    static final int MAX_N = 100;
    static int N;
    static int marker;
    static int[] nCnt = new int[3];

    static class POS {
        int r; //y
        int c; //x

        public POS(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static class CELL {
        int target;
        int energy;
        int marker;
        POS pos;

        public CELL(int target, int energy, POS pos) {
            this.target = target;
            this.energy = energy;
            this.marker = 0;
            this.pos = pos;
        }
    }

    static class CellComparator implements Comparator<CELL> {
        public int compare(CELL a, CELL b) {
            if (a.energy == b.energy) {
                if (a.pos.r == b.pos.r) {
                    return a.pos.c > b.pos.c ? -1 : 1;
                } else {
                    return a.pos.r > b.pos.r ? -1 : 1;
                }
            } else {
                return a.energy < b.energy ? -1 : 1;
            }
        }
    }

    static CELL[][] map = new CELL[MAX_N + 1][MAX_N + 1];
    static PriorityQueue<CELL> pq = new PriorityQueue<>(new CellComparator());

    static final int[] dr = {-1, 0, 0, 1};
    static final int[] dc = {0, -1, 1, 0};

    static void init(int N, int[][] mDish) {
        UserSolution.N = N;
        for (int r = 1; r <= N; r++) {
            for (int c = 1; c <= N; c++) {
                map[r][c] = new CELL(mDish[r - 1][c - 1], 0, new POS(r, c));
                map[r][c].target = 0;
                map[r][c].marker = 0;
            }
        }
        marker = 0;
        nCnt[1] = nCnt[2] = 0;
    }

    static void update(int r, int c, int t) {
        Queue<POS> que = new LinkedList<>();
        que.add(new POS(r, c));
        while (!que.isEmpty()) {
            POS pos = que.poll();
            r = pos.r;
            c = pos.c;

            for (int dir = 0; dir < 4; dir++) {
                int nc = c + dc[dir];
                int nr = r + dr[dir];
                if (nc <= 0 || nr <= 0 || nc > N || nr > N) continue;
                if (map[nr][nc].marker >= marker) continue;
                if (map[nr][nc].target == (3 - t)) continue;

                map[nr][nc].marker = marker;
                if (map[nr][nc].target == t) {
                    que.add(new POS(nr, nc));
                } else if (map[nr][nc].target == 0) {
                    pq.add(map[nr][nc]);
                }
            }
        }
    }
    public int dropMedicine(int mTarget, int mRow, int mCol, int mEnergy) {
        marker++;
        int curType = map[mRow][mCol].target;

        // If another bacteria exists, return immediately
        if (curType != 0 && curType != mTarget) return nCnt[mTarget];

        // Activate immediately
        CELL cell = map[mRow][mCol];
        if (cell.target == 0) {
            cell.target = mTarget;
            nCnt[mTarget]++;
            mEnergy -= cell.energy;
        }
        cell.marker = marker;

        // Activate and breed all connected bacteria
        PriorityQueue<CELL> pq = new PriorityQueue<>();
        while (mEnergy > 0) {
            update(cell.pos.r, cell.pos.c, mTarget);
            if (pq.size() == 0) break;
            cell = pq.poll();
            cell.target = mTarget;
            nCnt[mTarget]++;
            mEnergy -= cell.energy;
        }
        return nCnt[mTarget];
    }
    class Pair{
        private int key;
        private int value;

        Pair(int key, int value){
            this.key = key;
            this.value = value;
        }
        public int getKey() {
            return key;
        }

        public int getValue() {
            return value;
        }
    }

    public int cleanBacteria(int mRow, int mCol) {
        marker++;

        int target = map[mRow][mCol].target;

        // If cell is empty, return immediately
        if (target == 0) return -1;

        // Remove all connected bacteria using BFS
        Queue<Pair> que = new LinkedList<>();
        que.offer(new Pair(mRow, mCol));

        while (!que.isEmpty()) {
            Pair pos = que.poll();
            int r = pos.getKey();
            int c = pos.getValue();

            map[r][c].target = 0;
            nCnt[target]--;

            for (int dir = 0; dir < 4; dir++) {
                int nc = c + dc[dir];
                int nr = r + dr[dir];
                if (nc <= 0 || nr <= 0 || nc > N || nr > N) continue;
                if (map[nr][nc].marker >= marker) continue;
                if (map[nr][nc].target != target) continue;

                que.offer(new Pair(nr, nc));
                map[nr][nc].marker = marker;
            }
        }
        return nCnt[target];
    }
}
