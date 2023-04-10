package SamsungDxAlgorithm;

import java.util.Scanner;

class No1
{
    public static void main(String args[]) throws Exception {

        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int T;
        T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
            int count=0;
            int bit=0;
            int n = sc.nextInt();

            int temp=0;
            while(count<10){
                temp+=n;
                String nStr = String.valueOf(temp);
                for(int i=0; i<nStr.length(); i++){
                    int currentNum = nStr.charAt(i)-'0';
                    if(bitChecker(currentNum,bit)){
                        continue;
                    }else{
                        bit|=1<<currentNum;
                        count++;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(temp).append("\n");
        }
        System.out.println(sb);

    }
    public static boolean bitChecker(int number, int bit){
        return (bit&(1<<number))!=0;
    }
}