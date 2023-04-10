import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1018 {
    static char[][] board;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        board = new char[n][m];
        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0;j<m;j++){
                board[i][j]=str.charAt(j);
            }
        }


        int min=n*m;
        int sx=0;
        while(n-sx>7){
            int sy=0;
            while(m-sy>7){
                int case1=0;
                int case2=0;

                for(int i=0;i<8;i++){
                    for(int j=0; j<8; j++){
                        char c=board[sx+i][sy+j];
                        if(i%2==0){
                            if(j%2==0) {
                                if (c == 'B') {
                                    case1++;
                                }
                                else {
                                    case2++;
                                }
                            }else{
                                if(c=='W'){
                                    case1++;
                                }else{
                                    case2++;
                                }
                            }
                        }else{
                            if(j%2==0) {
                                if (c == 'W') {
                                    case1++;
                                }
                                else {
                                    case2++;
                                }
                            }else{
                                if(c=='B'){
                                    case1++;
                                }else{
                                    case2++;
                                }
                            }
                        }
                    }
                }
                min=Math.min(min,Math.min(case1,case2));
                sy++;
            }
            sx++;

        }
        bw.write(String.valueOf(min));
        bw.close();
        br.close();
    }
}