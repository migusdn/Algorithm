import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q16968 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        String number = br.readLine();
        int i=0;
        int result=1;
        boolean digitFlag=false;
        boolean characterFlag=false;
        while(i<number.length()){
            char c = number.charAt(i);
            if(c=='d'){
                characterFlag=false;
                if(digitFlag)
                    result*=9;
                else{
                    result*=10;
                    digitFlag=true;
                }
            }else{
                digitFlag=false;
                if(characterFlag)
                    result*=25;
                else{
                    result*=26;
                    characterFlag=true;
                }
            }
            i++;
        }
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }
}