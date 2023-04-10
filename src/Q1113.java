import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1113 {
    public static int N;
    public static int M;
    public static int count=0;
    public static int waterTemp;
    public static int[][] ground;
    public static boolean[][] visited;
    public static int groundMaximumHeight=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ground = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0; i<N; i++){
            String rowString = br.readLine();
            for(int j=0; j<M; j++){
                ground[i][j] = rowString.charAt(j)-'0';
                if(groundMaximumHeight<ground[i][j])
                    groundMaximumHeight=ground[i][j];
            }
        }
        for(int i=1; i<=groundMaximumHeight; i++){
            waterAmountOfGround(i);
        }
        bw.write(String.valueOf(count));
        bw.close();
        br.close();
    }
    public static void waterAmountOfGround(int groundLevel){
//        System.out.println("ground LV: "+groundLevel);
        visited = new boolean[N][M];
        boolean[][] water = new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0; j<M; j++){
                if(ground[i][j]-groundLevel<=0)
                    water[i][j]=true;
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0; j<M; j++){
//                System.out.print(water[i][j]);
                if(water[i][j]) {
                    int result = findHole(i, j, water);
                    if(result!=-1)
                        count+=result;
                }
            }
//            System.out.print("\n");
        }
//        System.out.println(count);
    }
    public static int findHole(int x, int y, boolean[][] water){
        if((x<0||x>=N)||(y<0||y>=M))
            return 0;
        else{
            if(visited[x][y])
                return 0;
            if(water[x][y]){
                if(x==0||y==0||x==N-1||y==M-1)
                    return -1;
                visited[x][y]=true;
                int right = findHole(x,y+1, water);
                int left = findHole(x, y-1,water);
                int bottom = findHole(x-1, y,water);
                int top = findHole(x+1, y,water);
                if(right==-1||left==-1||bottom==-1||top==-1)
                    return -1;
                else
                    return right+left+bottom+top+1;
            }else{
                return 0;
            }
        }
    }
    // 0 1 1 1 0
    // 1 0 0 0 1
    // 0 1 1 1 0
}