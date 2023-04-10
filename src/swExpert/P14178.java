package swExpert;

import java.util.Scanner;

public class P14178 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T;
        T = sc.nextInt();
        for(int test_case=1; test_case<=T; test_case++){
            int n = sc.nextInt();
            int d = sc.nextInt();
            sb.append("#").append(test_case).append(" ");
            if(n%(2*d+1)==0){
                sb.append(n/(2*d+1));
            }else{
                sb.append(n/(2*d+1)+1);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
