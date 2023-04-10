import java.util.Scanner;
import java.util.StringTokenizer;

class Q10953{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        sc.nextLine();
        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(sc.nextLine(),",");
            sb.append(Integer.parseInt(st.nextToken())+Integer.parseInt(st.nextToken())).append("\n");
        }
        System.out.println(sb.toString().trim());
    }
}