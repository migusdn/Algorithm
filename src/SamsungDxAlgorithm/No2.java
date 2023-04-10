package SamsungDxAlgorithm;

import java.util.Scanner;
import java.io.FileInputStream;

class No2 {
    public static void main(String args[]) throws Exception {

        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int n= sc.nextInt();
            int num = sc.nextInt();
            boolean flag=true;
            for(int i=0; i<n; i++){
                if(bitChecker(i,num)){
                    continue;
                }else{
                    flag=false;
                    break;
                }
            }
            sb.append("#").append(test_case).append(" ");
            if(flag){
                sb.append("ON");
            }else
                sb.append("OFF");
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static boolean bitChecker(int number, int bit){

        return (bit&(1<<number))!=0;
    }
}