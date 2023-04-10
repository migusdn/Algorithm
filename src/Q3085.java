import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q3085 {
    static int n;
    static char[][] board;
    static int max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        for(int i=0;i<n;i++){
            String str = br.readLine();
            for(int j=0;j<n;j++)
                board[i][j] = str.charAt(j);
        }

        for(int i=0; i<n;i++){
            for(int j=0; j<n-1; j++){
                char tmp = board[i][j];
                board[i][j]=board[i][j+1];
                board[i][j+1]=tmp;
                check();
                tmp=board[i][j];
                board[i][j] = board[i][j+1];
                board[i][j+1]=tmp;
            }
        }
        for(int i=0; i<n;i++){
            for(int j=0; j<n-1; j++){
                char tmp = board[j][i];
                board[j][i]=board[j+1][i];
                board[j+1][i]=tmp;
                check();
                tmp = board[j][i];
                board[j][i]=board[j+1][i];
                board[j+1][i]=tmp;
            }
        }
        bw.write(String.valueOf(max));
        bw.close();
        br.close();
    }
    public static void check(){
        for(int i=0;i<n;i++){
            int ctn = 1;
            for(int j=0; j<n-1;j++){
                if(board[i][j]==board[i][j+1])
                    ctn++;
                else
                    ctn=1;
                max = Math.max(max,ctn);
            }
        }
        for(int i=0;i<n;i++){
            int ctn=1;
            for(int j=0;j<n-1;j++) {
                if (board[j][i] == board[j + 1][i])
                    ctn++;
                else
                    ctn = 1;
                max = Math.max(ctn, max);
            }
        }
    }
}