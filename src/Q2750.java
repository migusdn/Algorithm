import java.io.*;
import java.util.StringTokenizer;

public class Q2750 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//
//        StringBuilder sb = new StringBuilder();
//        int T = Integer.parseInt(br.readLine());
//        int[] numbers = new int[T];
//        for(int i=0; i<T; i++){
//            numbers[i]=Integer.parseInt(br.readLine());
//        }
//        for(int i=0; i<numbers.length-1; i++){
//            for(int j=i+1; j<numbers.length; j++){
//                if(numbers[i]>numbers[j]){
//                    int tmp = numbers[j];
//                    numbers[j]=numbers[i];
//                    numbers[i]=tmp;
//                }
//            }
//        }
//        for(int i=0; i<numbers.length; i++){
//            sb.append(numbers[i]+"\n");
//        }
//        bw.write(sb.toString());
//        br.close();bw.close();
//
//    }
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                int a = array[j];
                int b = array[j+1];
                if(a>b) {
                    array[j + 1] = a;
                    array[j] = b;
                }
            }
        }
        for(int i=0; i<n; i++){
            sb.append(array[i]).append(" ");
        }
        bw.write(sb.toString());
        bw.close();
        br.close();

    }
}
