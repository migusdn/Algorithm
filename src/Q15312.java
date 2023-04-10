import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Q15312 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] count = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
        Queue<Integer> q1 = new LinkedList<>();
        char[] name1 = br.readLine().toCharArray();
        char[] name2 = br.readLine().toCharArray();
        for(int i=0; i<name1.length; i++) {
            q1.add(count[name1[i] - 'A']);
            q1.add(count[name2[i] - 'A']);
        }
        int i=1;
        int limit=name1.length*2;
        while(!(q1.size() ==2)){
            if(i==limit){
                q1.poll();
                i=1;
                limit=q1.size();
                continue;
            }
            q1.add((q1.poll()+q1.peek())%10);
            i++;
        }
        bw.write(String.valueOf(q1.poll())+String.valueOf(q1.poll()));
        bw.close();
        br.close();
    }
}