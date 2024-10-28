import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : hyunwoopark
 * @version : 1.0.0
 * @package : Algorithm
 * @name : 배
 * @date : 2/27/24 9:55 PM
 * @modifyed : $
 **/
public class 배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> cranes = new ArrayList<>();
        List<Integer> boxes = new ArrayList<>();
        String[] temp;
        int n = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            cranes.add(Integer.parseInt(temp[i]));
        }
        int m = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        for (int i = 0; i < m; i++) {
            boxes.add(Integer.parseInt(temp[i]));
        }
        Collections.sort(cranes, Collections.reverseOrder());
        Collections.sort(boxes, Collections.reverseOrder());
        if (cranes.get(0) < boxes.get(0)) {
            System.out.println(-1);
            return;
        }
        int time = 0;
        while (!boxes.isEmpty()) {
            int boxIdx = 0;
            for (int i = 0; i < n; i++) {
                if(boxIdx==boxes.size())
                    break;
                int cur = boxes.get(boxIdx);
                if (cranes.get(i) < cur){
                    boxIdx++;
                    i--;
                }else{
                    boxes.remove(boxIdx);
                }
            }
            time++;
        }
        System.out.println(time);

    }
}
