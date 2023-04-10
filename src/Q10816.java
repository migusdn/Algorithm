import java.util.HashMap;
import java.util.Scanner;

public class Q10816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer,Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt();
        for(int i=0; i<N;i++){
            int tmp=sc.nextInt();
            if(map.get(tmp)==null)
                map.put(tmp,1);
            else
                map.put(tmp,map.get(tmp)+1);
        }
        int M = sc.nextInt();
        for(int i=0;i<M;i++){
            Integer tmp = map.get(sc.nextInt());
            if(tmp==null)
                sb.append("0 ");
            else
                sb.append(tmp+" ");
        }
        System.out.println(sb.toString().trim());
    }
}
