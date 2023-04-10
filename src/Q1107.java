import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q1107 {
    static boolean[] unusableButtons;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        unusableButtons = new boolean[10];
        if(m!=0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                unusableButtons[Integer.parseInt(st.nextToken())] = true;
            }
        }
        int minimum = Math.abs(n-100);
        for(int i=0; i<1000000;i++){
            int clickCount=click(i);
            if(clickCount>0){
                int press = Math.abs(n-i);
                minimum=Math.min(minimum,clickCount+press);
            }
        }
        bw.write(String.valueOf(minimum));
        bw.close();
        br.close();
    }
    public static int click(int n){
        if(n==0){
            if(unusableButtons[n])
                return 0;
            else
                return 1;
        }else{
            int clickCount=0;
            while(n>0){
                if(unusableButtons[n%10])
                    return 0;
                n/=10;
                clickCount++;
            }
            return clickCount;
        }
    }
}