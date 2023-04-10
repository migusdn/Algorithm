import java.io.*;

class Q9095 {
    static int count=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<n;i++){
            count=0;
            reverseSum(Integer.parseInt(br.readLine()));
            sb.append(count).append("\n");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
    public static void reverseSum(int number){
        if(number<0)
            return;
        if(number==0){
            count++;
            return;
        }

        reverseSum(number-1);
        reverseSum(number-2);
        reverseSum(number-3);
    }
}