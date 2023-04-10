import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Q15686 {
    static ArrayList<Position> homeList = new ArrayList<>();
    static ArrayList<Position> chickenList = new ArrayList<>();
    static long answer=Long.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n,m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int row=0; row<n; row++){
            char[] rowInfo = br.readLine().replace(" ","").toCharArray();
            for(int col=0; col<n; col++){
                if(rowInfo[col]=='0')
                    continue;
                else {
                    if (rowInfo[col] == '1') {
                        homeList.add(new Position(row, col));
                    } else {
                        chickenList.add(new Position(row, col));
                    }
                }
            }
        }
        findChickenDistance(new boolean[chickenList.size()],0, m);
        bw.write(String.valueOf(answer));
        bw.close();
        br.close();
    }
    public static void findChickenDistance(boolean[] visited, int start, int m){
        if(m==0){
            long sumDistance = 0;
            for(int i=0;i< homeList.size();i++){
                long minDistance = Long.MAX_VALUE;
                for(int j=0; j< chickenList.size(); j++){
                    if(visited[j]==true){
                        long distanceTemp = homeList.get(i).getDistance(chickenList.get(j));
                        if(distanceTemp<minDistance)
                            minDistance = distanceTemp;
                    }
                }
                sumDistance+=minDistance;
            }
            if(sumDistance<answer)
                answer=sumDistance;
            return;
        }
        for(int i=start; i< chickenList.size(); i++){
            visited[i] = true;
            findChickenDistance(visited, i+1,m-1);
            visited[i] = false;
        }
    }

}
class Position{
    int x;
    int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }
    public long getDistance(Position position){
        return Math.abs(this.x-position.x)+Math.abs(this.y-position.y);
    }
}