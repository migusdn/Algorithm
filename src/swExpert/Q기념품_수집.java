package swExpert;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Q기념품_수집 {
    static int[][] matrix=null;
    static int maximum=0;
    public static void main(String[] args) throws Exception{

        System.setIn(new FileInputStream("src/swExpert/기념품수집input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        T = Integer.parseInt(sc.nextLine());
        StringBuilder answer = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine());
            maximum=0;
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            matrix = new int[r][c];
            for(int i=0; i<r; i++){
                String temp = sc.nextLine();
                for(int j=0; j<c; j++){
                    matrix[i][j]=temp.charAt(j)-'A';
                }
            }
            search(0,0,new boolean[26],0);
            answer.append("#").append(test_case).append(" ").append(maximum).append("\n");
        }
        System.out.println(answer);
    }
    public static void search(int x, int y, boolean[] visit,int depth){
        if(x<0||y<0||x>=matrix.length||y>=matrix[0].length){
            return;
        }
        int currentGift = matrix[x][y];
        if(visit[currentGift])
            return;
        else{
            visit[currentGift]=true;
            depth++;
            maximum = Math.max(depth,maximum);
            search(x-1,y,visit.clone(),depth);
            search(x+1,y,visit.clone(),depth);
            search(x,y-1,visit.clone(),depth);
            search(x,y+1,visit.clone(),depth);
        }
    }
}
