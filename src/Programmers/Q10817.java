package Programmers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

class Q10817 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[st.countTokens()];
        int max = 0;
        int secMax = 0;
        while(st.hasMoreTokens()){
            int tmp = Integer.parseInt(st.nextToken());
            if(tmp>max) {
                secMax = max;
                max = tmp;
            }
            else if(tmp>secMax)
                secMax = tmp;
        }
        bw.write(""+secMax);
        br.close();
        bw.close();
    }
}