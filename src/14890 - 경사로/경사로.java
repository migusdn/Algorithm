import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 경사로
 * @date : 2/21/24 7:42 PM
 * @modifyed : $
 **/
public class 경사로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);
        int l = Integer.parseInt(inputs[1]);
        int[][] map = new int[n][n];
        for (int r = 0; r < n; r++) {
            String[] row = br.readLine().split(" ");
            for (int c = 0; c < n; c++) {
                map[r][c] = Integer.parseInt(row[c]);
            }
        }
        int answer = 0;
        int prev;
        int equalCnt;
        for (int i = 0; i < n; i++) {
            boolean flag = true;
            prev = map[i][0];
            equalCnt = 1;
            for (int j = 1; j < n && flag; j++) {
                if (prev == map[i][j])
                    equalCnt++;
                else if (Math.abs(prev - map[i][j]) == 1) {
                    if (prev < map[i][j]) {
                        if (equalCnt < l) {
                            flag = false;
                            break;
                        }
                        equalCnt = 1;
                    } else {
                        equalCnt = 1;
                        if (j + l - 1 >= n) {
                            flag = false;
                            break;
                        }
                        for (int k = 1; k < l; k++) {
                            equalCnt++;
                            if (map[i][j] != map[i][j + k]) {
                                flag = false;
                                break;
                            }
                        }
                        j = j + l - 1;
                        equalCnt -= l;
                    }
                    prev = map[i][j];
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag)
                answer++;

            flag = true;
            prev = map[0][i];
            equalCnt = 1;
            for (int j = 1; j < n && flag; j++) {
                if (prev == map[j][i])
                    equalCnt++;
                else if (Math.abs(prev - map[j][i]) == 1) {
                    if (prev < map[j][i]) {
                        if (equalCnt < l) {
                            flag = false;
                            break;
                        }
                        equalCnt = 1;
                    } else {
                        if (j + l - 1 >= n) {
                            flag = false;
                            break;
                        }
                        equalCnt = 1;
                        for (int k = 1; k < l; k++) {
                            equalCnt++;
                            if (map[j][i] != map[j + k][i]) {
                                flag = false;
                                break;
                            }
                        }
                        j = j + l - 1;
                        equalCnt -= l;
                    }
                    prev = map[j][i];
                } else {
                    flag = false;
                    break;
                }
            }

            if (flag)
                answer++;
        }
        System.out.println(answer);

    }
}
