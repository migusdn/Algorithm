import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Q1132 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String[] nums = new String[n];
        Alphabet[] alphabetNumber = new Alphabet[10];
        for(int i=0;i<10; i++){
            alphabetNumber[i] = new Alphabet((char) (i+'A'));
        }
        for(int i=0; i<n; i++){
            nums[i] = br.readLine();
            for(int j=0; j<nums[i].length(); j++){

                char c = nums[i].charAt(j);
                alphabetNumber[c-'A'].addPriority(nums[i].length()-j);
                if(j==0) {
                    alphabetNumber[c - 'A'].isNotZero = true;
                    alphabetNumber[c - 'A'].addPriority(1);

                }
            }
        }
        Arrays.sort(alphabetNumber, (Alphabet a, Alphabet b)->{
            return b.priority-a.priority;
        });
        for(Alphabet a:alphabetNumber)
            System.out.println(a.toString());


    }
    static class Alphabet{
        char c;
        int priority;
        boolean isNotZero;
        Alphabet(char c){
            this.c = c;
            this.priority=0;
            this.isNotZero = false;
        }
        public void addPriority(int n){
            this.priority+=n;
        }

        @Override
        public String toString() {
            return "알파벳:"+this.c+" 우선순위: "+this.priority;
        }
    }
}
