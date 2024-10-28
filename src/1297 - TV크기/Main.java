/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : Main
 * @date : 2/6/24 6:01 PM
 * @modifyed : $
 **/
import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        double d = Integer.parseInt(inputs[0]);
        double h = Integer.parseInt(inputs[1]);
        double w = Integer.parseInt(inputs[2]);
        double dPow = d*d;
        double hPow = h*h;
        double wPow = w*w;
        System.out.println(
                (int)(Math.sqrt(dPow /(hPow+wPow))*h)+" "+
                        (int)(Math.sqrt(dPow /(hPow+wPow))*w)
        );
    }
}
