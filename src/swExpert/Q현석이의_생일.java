package swExpert;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q현석이의_생일 {


    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("src/swExpert/input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = Integer.parseInt(sc.nextLine());
        StringBuilder result = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            StringBuilder sb = new StringBuilder();
            String[] input = sc.nextLine().split(" ");
            String maxNumStr = input[0];
            int x = Integer.parseInt(input[1]);
            int y = Integer.parseInt(input[2]);

            boolean flag = false;

            int index = 0;
            while (index < maxNumStr.length()) {
                if (flag) {
                    sb.append(y);
                } else {
                    int currentNumber = maxNumStr.charAt(index) - '0';
                    if (currentNumber == y) {
                        sb.append(y);
                    } else if (currentNumber > y) {
                        sb.append(y);
                        flag = true;
                    } else {
                        if (currentNumber == x) {
                            sb.append(x);
                        } else if (currentNumber > x) {
                            sb.append(x);
                            flag = true;
                        } else {
                            int tempIdx = index - 1;
                            while (tempIdx != -1) {
                                int previousNumber = sb.charAt(tempIdx) - '0';
                                if (previousNumber == y) {
                                    sb.deleteCharAt(tempIdx);
                                    sb.append(x);
                                    index = tempIdx;
                                    flag = true;
                                    break;
                                } else {
                                    sb.deleteCharAt(tempIdx);
                                }
                                tempIdx--;
                            }
                            if (tempIdx == -1) {
                                index=0;
                                flag=true;

                            }
                        }
                    }
                }
                index++;
            }
            while (sb.length() != 0 && sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            }
            if (sb.length() == 0) {
                result.append("#").append(test_case).append(" ").append("-1");
            } else {
                result.append("#").append(test_case).append(" ").append(sb);
            }
            result.append("\n");
        }
        System.out.println(result);
    }
}
//input 이 422223324 x 는 2 y 는 4인 경우에
//x, y sort를 통해 x는 4가 되고 y는 2가되며
//각 값의 대입을 위해 index 단위로 쪼개서 보면
//뒤에서 부터 비교해야한다
//424214 2 4
//422444
//222214 2 4
//-1
//422214 2 4
//244444
//422214 2 3