import java.io.*;
import java.util.*;

public class Q1427 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] array = br.readLine().toCharArray();
        for(int i=0; i<array.length; i++){
            char c = array[i];

        }
    }
    public static void swap(char[] array, int a, int b){
        char temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
