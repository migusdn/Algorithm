import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Q7569 {

    public static void main(String[] args) throws IOException {
        int m, n, h;
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //다른 토마토에 영향을 줄 토마토의 좌표를 담은 Queue, 걸린 소요시간을 카운팅하기위해 2개 선언
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
                        //익은 경우 ripeTomato를 1증가시키고 Queue에 추가한다.
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
        //익은 토마토와 빈칸의 합이 H * N * M 이면 이미 다 익은 상태
        if (ripeTomato + emptyTomato == h * n * m) {
            bw.write(String.valueOf(answer));
        } else {
            while (!(Q1.isEmpty() && Q2.isEmpty())) {
                if(unripeTomato==0)
                    break;
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
                    for (int j = 0; j < 4; j++) {
                        int nz = z;
                        int nx = x + dx[j];
                        int ny = y + dy[j];
                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                        if (tomatoes[nz][nx][ny] == 0) {
//                            System.out.println("target" + nz + " " + nx + " " + ny);
                            unripeTomato--;
                            tomatoes[nz][nx][ny] = 1;
                            nextQ.offer(nz);
                            nextQ.offer(nx);
                            nextQ.offer(ny);
                        }
                    }
                    if(z-1 >= 0){
                        if(tomatoes[z-1][x][y]==0) {
                            unripeTomato--;
                            tomatoes[z-1][x][y]=1;
                            nextQ.offer(z-1);
                            nextQ.offer(x);
                            nextQ.offer(y);
                        }
                    }
                    if(z+1 < h){
                        if(tomatoes[z+1][x][y]==0) {
                            unripeTomato--;
                            tomatoes[z+1][x][y]=1;
                            nextQ.offer(z+1);
                            nextQ.offer(x);
                            nextQ.offer(y);
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