import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

class Q1082 {
    static int money;
    static HashMap<Integer, Integer> price;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n;i++){
            price.put(i,Integer.parseInt(st.nextToken()));
        }
        money = Integer.parseInt(br.readLine());

    }
    public static void calculatePrice(int number){
        int price;
    }
}