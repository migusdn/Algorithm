import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
public class Q10171 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write("\\    /\\\n" +
                " )  ( ')\n" +
                "(  /  )\n" +
                " \\(__)|");
        bw.close();
    }

}
