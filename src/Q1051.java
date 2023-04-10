import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1051 {
    public static int[][] square;
    public static int answer=1;
    public static int N;
    public static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        square = new int[N][M];
        for(int i=0; i<N; i++){
            String numberStr = br.readLine();
            for(int j=0; j<M; j++) {
                square[i][j] = numberStr.charAt(j) - '0';
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                findSquare(i,j,0);
            }
        }
        bw.write(String.valueOf((int)Math.pow(answer,2)));
        bw.close();
        br.close();
    }
    public static void findSquare(int x, int y,int length){
        if(x+length>=N||y+length>=M)
            return;
        else if(square[x][y]==square[x+length][y]
                &&square[x][y]==square[x+length][y+length]
                &&square[x][y]==square[x][y+length]){
            if(answer<length+1)
                answer=length+1;
        }
        findSquare(x,y,length+1);
    }
}