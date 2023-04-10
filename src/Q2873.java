import java.io.*;
import java.util.StringTokenizer;

class Q2873 {
    static int c;
    static int r;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int[][] cost = new int[r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; j++)
                cost[i][j] = Integer.parseInt(st.nextToken());
        }
        int minCost = 1000;
        int x = 0;
        int y = 0;
        if (r % 2 == 0 && c % 2 == 0) {
            for (int i = 0; i < r; i++) {
                int j;
                if (i % 2 == 0) {
                    j = 1;
                } else
                    j = 0;
                while (j < c) {
                    if (cost[i][j] < minCost) {
                        minCost = cost[i][j];
                        x = i;
                        y = j;
                    }
                    j += 2;
                }
            }
            int curX = 0;
            int curY = 0;
            if (x % 2 == 0 || x == 0) {
                while (curX != x) {
                    if (curX % 2 == 0) {
                        for (int i = 0; i < c - 1; i++)
                            sb.append("R");
                    } else {
                        for (int i = 0; i < c - 1; i++)
                            sb.append("L");
                    }
                    curX++;
                    sb.append("D");
                }
                while (curY != y - 1) {
                    sb.append("DRUR");
                    curY += 2;
                }
                if (curY + 1 == c - 1) {
                    sb.append("DRD");
                    curX += 2;
                    curY += 1;
                } else {
                    sb.append("DRRUR");
                    curY += 3;

                    while (curY != c - 1) {
                        sb.append("DRUR");
                        curY += 2;
                    }
                    sb.append("DD");
                    curX += 2;
                }
                while (curX != r) {
                    if (curX % 2 == 0) {
                        for (int i = 0; i < c - 1; i++)
                            sb.append("L");
                    } else {
                        for (int i = 0; i < c - 1; i++)
                            sb.append("R");
                    }
                    curX++;
                    sb.append("D");
                }
            } else {
                while (curX != x - 1) {
                    if (curX % 2 == 0) {
                        for (int i = 0; i < c - 1; i++)
                            sb.append("R");
                    } else {
                        for (int i = 0; i < c - 1; i++)
                            sb.append("L");
                    }
                    curX++;
                    sb.append("D");
                }
                while (curY != y) {
                    sb.append("DRUR");
                    curY += 2;
                }
                sb.append("R");
                curY += 1;
                while (curY != c - 1) {
                    sb.append("DRUR");
                    curY += 2;
                }
                sb.append("DD");
                curX += 2;
                while (curX != r) {
                    if (curX % 2 == 0) {
                        for (int i = 0; i < c - 1; i++)
                            sb.append("L");
                    } else {
                        for (int i = 0; i < c - 1; i++)
                            sb.append("R");
                    }
                    curX++;
                    sb.append("D");
                }
            }
        }else{
            int curX=0;
            while(curX!=r){
                if(curX%2==0){
                    for(int i=0;i<c-1;i++){
                        sb.append("R");
                    }
                }else{
                    for(int i=0;i<c-1;i++){
                        sb.append("L");
                    }
                }
                curX++;
                sb.append("D");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}