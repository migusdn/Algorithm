import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 좌표압축
 * @date : 1/1/24 9:13 PM
 * @modifyed : $
 **/
public class 좌표압축 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] numberStrings = br.readLine().split(" ");
        int[] numbers = new int[n];

        Map<Integer, Integer> compressedIndex = new HashMap<>();
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numberStrings[i]);
        }
        int[] sortedNumbers = numbers.clone();
        Arrays.sort(sortedNumbers);
        int idx=0;
        for(int num:sortedNumbers){
            if(!compressedIndex.containsKey(num))
                compressedIndex.put(num,idx++);
        }
        for(int num: numbers){
            sb.append(compressedIndex.get(num)).append(" ");
        }
        System.out.println(sb);
    }
}
