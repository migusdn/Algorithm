import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
class Q1038 {
    public static HashMap<String, Boolean> decreaseMap = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        long n = Long.parseLong(br.readLine());
        int idx=0;
        long currNumber=0;
        while(idx<n&&currNumber<9876543210l){
            if(decreaseChecker(String.valueOf(currNumber)))
                idx++;
            currNumber++;
            System.out.println(currNumber);
        }
        if(currNumber==9876543210l)
            bw.write(String.valueOf(-1));
        else
            bw.write(String.valueOf(currNumber));
        bw.close();
        br.close();
    }
    public static boolean decreaseChecker(String number){
        if(decreaseMap.get(number)!=null){
            return decreaseMap.get(number);
        }
        if(number.length()==1) {
            decreaseMap.put(number,true);
            return true;
        } else if(number.charAt(0)>number.charAt(1)){
            if(decreaseChecker(number.substring(1))) {
                decreaseMap.put(number, true);
                return true;
            }
            else {
                decreaseMap.put(number, false);
                return false;
            }
        }else{
            decreaseMap.put(number,false);
            return false;
        }
    }
}