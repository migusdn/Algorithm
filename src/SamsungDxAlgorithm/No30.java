package SamsungDxAlgorithm;

import java.util.Scanner;

public class No30 {

    static final int maxLength = 2000;
    static final int rPowNum = 31, cPowNum = 31;

    static int H, W, N, M;
    static long[] lineHash, rPow, cPow;
    static long[][] enPic;
    static long[][] tePic;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        long enHash, teHash;
        int ans;
        rPow = initPow(rPowNum);
        cPow = initPow(cPowNum);
        lineHash = new long[maxLength];
        enPic = new long[maxLength][maxLength];
        tePic = new long[maxLength][maxLength];

        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            ans = 0;
            H = sc.nextInt();
            W = sc.nextInt();
            N = sc.nextInt();
            M = sc.nextInt();
            for (int i = 0; i < H; i++) {
                String picRow = sc.next();
                for (int j = 0; j < W; j++) {
                    enPic[i][j] = picRow.charAt(j) == 'o' ? 1 : 0;
                }
            }
            for (int i = 0; i < N; i++) {
                String picRow = sc.next();
                for (int j = 0; j < M; j++) {
                    tePic[i][j] = picRow.charAt(j) == 'o' ? 1 : 0;
                }
            }
            for (int i = 0; i < H; i++) {
                lineHash[i] = getHash(enPic[i], rPow, W);
            }
            enHash = getHash(lineHash, cPow, H);
            for (int i = 0; i < N; i++) {
                lineHash[i] = getHash(tePic[i], rPow, W);
            }

            teHash = getHash(lineHash, cPow, H);
            if (enHash == teHash) ans++;

            ans += moveColumn(enHash, teHash);

            for (int i = 0; i < M - W; i++) {
                moveRow(i);
                teHash = getHash(lineHash, cPow, H);
                if (enHash == teHash)
                    ans++;
                ans += moveColumn(enHash, teHash);
            }

            sb.append("#").append(test_case).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    static long[] initPow(long n) {
        long[] pow = new long[maxLength];

        for (int i = 0; i < maxLength; i++) {
            pow[i] = pow(n, i);
        }

        return pow;
    }

    static long pow(long n, int i) {
        long res = 1;

        while (i > 0) {
            if ((i & 1) == 1)
                res *= n;
            n *= n;
            i >>= 1;
        }

        return res;
    }

    static long getHash(long[] pic, long[] pow, int HW) {
        long hash = 0;
        int e;

        for (int i = 0; i < HW; i++) {
            e = HW - i - 1;
            hash = hash + pic[i] * pow[e];
        }

        return hash;
    }

    static void moveRow(int r) {
        for (int i = 0; i < N; i++) {
            lineHash[i] = lineHash[i] - tePic[i][r] * rPow[W - 1];
            lineHash[i] = lineHash[i] * rPowNum + tePic[i][W + r];
        }
    }

    static int moveColumn(long enHash, long teHash) {
        int cnt = 0;

        for (int r = 0; r < N - H; r++) {
            teHash = teHash - lineHash[r] * cPow[H - 1];
            teHash = teHash * cPowNum + lineHash[H + r];
            if (enHash == teHash) cnt++;
        }

        return cnt;
    }


}