import java.io.*;

class Q2941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String sentence = br.readLine();
        String[] croatiaAlphabet = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for(String str:croatiaAlphabet){
            if(sentence.contains(str))
                sentence = sentence.replace(str,"~");
        }

        bw.write(String.valueOf(sentence.length()));
        bw.close();
        br.close();
    }
}