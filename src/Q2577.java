import java.io.*;

public class Q2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String number = String.valueOf(Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine())*Integer.parseInt(br.readLine()));
        int[] ctn = new int[10];
        for(int i=0;i<number.length();i++){
            switch(number.charAt(i)){
                case '0': {
                    ctn[0]++;
                    break;
                }

                case '1': {
                    ctn[1]++;
                    break;
                }
                case '2': {
                    ctn[2]++;
                    break;
                }
                case '3': {
                    ctn[3]++;
                    break;
                }
                case '4': {
                    ctn[4]++;
                    break;
                }
                case '5': {
                    ctn[5]++;
                    break;
                }
                case '6': {
                    ctn[6]++;
                    break;
                }
                case '7': {
                    ctn[7]++;
                    break;
                }
                case '8': {
                    ctn[8]++;
                    break;
                }
                case '9': {
                    ctn[9]++;
                    break;
                }
            }
        }
        for(int i=0;i<10; i++)
            bw.write(ctn[i]+"\n");
        br.close();
        bw.close();
    }
}
