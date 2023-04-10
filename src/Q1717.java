import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1717 {
    public static StringBuilder sb = new StringBuilder();
    public static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st;
        int n,m;
        st = new StringTokenizer(br.readLine());
        n=Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n+1];
        for(int i=1; i<n+1; i++){
            arr[i] = i;
        }
        for(int i=0; i<m; i++){
            int command, param1, param2;
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());
            param1 = Integer.parseInt(st.nextToken());
            param2 = Integer.parseInt(st.nextToken());

            if(command==0){
                arr[param2] = arr[param1];
            }else if(command==1){
                sb.append("param1: "+param1+"param2: "+param2).append("\n");
                arr[param1] = findParent(param1);

                arr[param2] = findParent(param2);

                if(arr[param1]==arr[param2] )
                    sb.append("YES").append("\n");
                else
                    sb.append("NO").append("\n");
            }
        }
//        for(int i: arr){
//            System.out.print(i+" ");
//        }
//        findParent(6);
        for(int i: arr){
            System.out.print(i+" ");
        }

        bw.write(sb.toString().trim());
        bw.close();
        br.close();

    }
    public static int findParent(int idx){
        int parent = arr[idx];
        if(parent==idx)
            return parent;
        else
            return arr[idx]=findParent(parent);
    }
}