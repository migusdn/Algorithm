import java.io.*;

class Q10872{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        bw.write(factorial(num)+"");
        bw.close();
        br.close();
    }
    public static int factorial(int num){
        if(num==1)
            return 1;
        return num*factorial(num-1);
    }
}