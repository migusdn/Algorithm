package SamsungDxAlgorithm;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.StringTokenizer;

class No9 {
    public static void main(String args[]) throws Exception {

        //System.setIn(new FileInputStream("res/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T=10;
        StringBuilder sb = new StringBuilder();
        for (int test_case = 1; test_case <= T; test_case++) {
            int maxVertex = Integer.parseInt(sc.nextLine());
            boolean invalidFlag=false;
            for(int i=0; i<maxVertex; i++){
                if(invalidFlag) {
                    sc.nextLine();
                    continue;
                }
                StringTokenizer st = new StringTokenizer(sc.nextLine());
                st.nextToken();
                char data = st.nextToken().charAt(0);
                int check=0;
                while(st.hasMoreTokens()) {
                    st.nextToken();
                    check++;
                }
                if(data=='*'||data=='/'||data=='+'||data=='-'){
                    if(check!=2){
                        invalidFlag = true;
                    }
                }else{
                    if(check!=0) {
                        invalidFlag = true;
                    }
                }
            }
            sb.append("#").append(test_case).append(" ").append(invalidFlag?"0":"1").append("\n");
        }
        System.out.println(sb);
    }
}