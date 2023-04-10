public class Programmers12895 {
    static int answer=-1;
    public static int solution(int N, int number){
        dfs(N,number,0,0);
        return answer;
    }
    public static void dfs(int N, int number, int sum, int depth){
        if(depth>8)
            return;
        if(sum==number) {
            if (answer == -1)
                answer = depth;
            else
                answer = Math.min(depth, answer);
        }
        int x = N;
        for(int i=1;i<=8-depth;i++){
            dfs(N,number,sum+x,depth+i);
            dfs(N,number,sum/x,depth+i);
            dfs(N,number,sum-x,depth+i);
            dfs(N,number,sum*x,depth+i);
            x=x*10+N;
        }
    }
    public static void main(String[] args){
        System.out.println(solution(2,11));
        System.out.println(solution(8,53));
    }
}
