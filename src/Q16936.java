import java.io.*;
import java.util.*;

public class Q16936 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        int n;
        n=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        ArrayList<Long> arr = new ArrayList<>();
        boolean[] check;
        for(int i=0; i<n; i++){
            arr.add(Long.parseLong(st.nextToken()));
        }
        long startNumber = 0;
        for(int i=0; i<n; i++){
            Long start= arr.get(i);
            check=new boolean[n];
            check[i]=true;
            boolean trueCheck=true;
            while(true){
                if(arr.contains(start*2)){
                    start = start*2;
                    if(check[arr.indexOf(start)]){
                        break;
                    }else
                        check[arr.indexOf(start)]=true;
                }else if(start%3==0&&arr.contains(start/3)){
                    start/=3;
                    if(check[arr.indexOf(start)]){
                        break;
                    }else
                        check[arr.indexOf(start)]=true;
                }else{
                    break;
                }
            }
            for(boolean b:check)
                if(!b) {
                    trueCheck = false;
                    break;
                }
            if(trueCheck){
                startNumber=arr.get(i);
                break;
            }
        }
        for(int i=0; i<n;i++){
            sb1.append(startNumber).append(" ");
            if(arr.contains(startNumber*2))
                startNumber*=2;
            else
                startNumber/=3;
        }
        System.out.println(sb1.toString().trim());
        
       
    }
}
