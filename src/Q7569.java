import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Q7569 {

    public static void main(String[] args) throws IOException {
        int m, n, h;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int[] dz = {-1, 0, 1};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> Q1 = new LinkedList<>();
        Queue<Integer> Q2 = new LinkedList<>();
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int[][][] tomatoes = new int[h][n][m];
        int answer = 0;
        int ripeTomato = 0;
        int unripeTomato = 0;
        int emptyTomato = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    int temp = Integer.parseInt(st.nextToken());
                    tomatoes[i][j][k] = temp;
                    switch (temp) {
                        case 0: {
                            unripeTomato++;
                            break;
                        }
                        case 1: {
                            ripeTomato++;
                            Q1.offer(i);
                            Q1.offer(j);
                            Q1.offer(k);
                            break;
                        }
                        case -1: {
                            emptyTomato++;
                        }

                    }
                }
            }
        }
        if(ripeTomato+emptyTomato==h*n*m){
            System.out.println(answer);
        }else {
            while (!(Q1.isEmpty() && Q2.isEmpty())) {
                Queue<Integer> curQ;
                Queue<Integer> nextQ;
                if (Q2.isEmpty()) {
                    curQ = Q1;
                    nextQ = Q2;
                } else {
                    curQ = Q2;
                    nextQ = Q1;
                }
                while (!curQ.isEmpty()) {
                    int x, y, z;
                    z = curQ.poll();
                    x = curQ.poll();
                    y = curQ.poll();
                    System.out.println(z+" "+x+" "+y);
                    for (int i = 0; i < 3; i++) {
                        for (int j = 0; j < 4; j++) {
                            int nz = z + dz[i];
                            int nx = x + dx[j];
                            int ny = y + dy[j];
                            if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h) continue;
                            if (tomatoes[nz][nx][ny] == 0) {
                                unripeTomato--;
                                tomatoes[nz][nx][ny] = 1;
                                nextQ.offer(nz);
                                nextQ.offer(nx);
                                nextQ.offer(ny);
                            }
                        }
                    }

                }
                answer++;
            }
            if (unripeTomato != 0)
                bw.write(String.valueOf(-1));
            else
                bw.write(String.valueOf(answer));
        }
        bw.close();
        br.close();
    }
}