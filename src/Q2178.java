import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Q2178 {
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int[][] maze = new int[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];
        for(int i=1;i<=n;i++){
            char[] values = br.readLine().toCharArray();
            for(int j=1;j<=m;j++){
                maze[i][j] = values[j-1]-'0';
            }
        }
        Queue<Integer> x = new LinkedList<>();
        Queue<Integer> y = new LinkedList<>();
        Queue<Integer> d = new LinkedList<>();
        x.add(1);
        y.add(1);
        d.add(1);
        visited[1][1]=true;
        while(!x.isEmpty()){
            int pointX = x.poll();
            int pointY = y.poll();
            int distance = d.poll();
            //top
            if(isValid(pointX,pointY-1)){
                x.add(pointX);
                y.add(pointY-1);
                d.add(distance+1);
            }
            if(isValid(pointX,pointY+1)){
                x.add(pointX);
                y.add(pointY+1);
                d.add(distance+1);
            }
            if(isValid(pointX-1,pointY)){
                x.add(pointX-1);
                y.add(pointY);
                d.add(distance+1);
            }
            if(isValid(pointX+1,pointY)){
                x.add(pointX+1);
                y.add(pointY);
                d.add(distance+1);
            }
        }


    }
    public static void solve(boolean[][] d){

    }
    public static boolean isValid(int x, int y){
        return x>0&&x<=n&&y>0&&y<=m;
    }

}
