import java.io.*;
import java.util.*;

class Q5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            char[] commands = br.readLine().toCharArray();
            br.readLine();
            String array = br.readLine();
            array = array.substring(1,array.length()-1);
            sb.append(new funcAC(commands,array).execute()).append("\n");
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }
    static class funcAC{
        boolean way;
        LinkedList<String> nums;
        char[] commands;
        funcAC(char[] commands, String array){
            this.nums = new LinkedList<>();
            this.way = false;
            this.commands = commands;
            StringTokenizer st = new StringTokenizer(array,",");
            while(st.hasMoreTokens())
                this.nums.addLast(st.nextToken());
        }
        public boolean delete(){
            if(this.nums.size()==0) {
                return false;
            }
            if(this.way) {
                this.nums.removeLast();
            }

            else {
                this.nums.removeFirst();
            }
            return true;
        }
        public String execute() {

            for (char c : this.commands) {
                if (c == 'R')
                    way = !way;
                else if (c == 'D')
                    if (!this.delete())
                        return "error";
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if(nums.size()!=0) {
                String[] str = nums.toArray(new String[0]);
                if (way) {
                    for (int i = str.length - 1; i > -1; i--) {
                        sb.append(str[i]).append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    for (int i = 0; i < str.length; i++) {
                        sb.append(str[i]).append(",");
                    }
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            sb.append("]");
            return sb.toString();

        }
    }

}