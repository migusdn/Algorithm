//Runtime error

import java.io.*;
import java.util.*;

public class
Q5397 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t;i++) {
            char[] str = br.readLine().toCharArray();
            Stack<Character> logger = new Stack<>();
            Stack<Character> temp = new Stack<>();
            for(char c:str){
                switch(c){
                    case '<':{
                        if(!logger.isEmpty())
                            temp.add(logger.pop());
                        break;
                    }
                    case '>':{
                        if(!temp.isEmpty())
                            logger.push(temp.pop());
                        break;
                    }
                    case '-':{
                        if(!logger.isEmpty())
                            logger.pop();
                        break;
                    }
                    default: {
                        logger.push(c);
                        break;
                    }
                }
            }
            while(!temp.isEmpty())
                logger.push(temp.pop());
            for(int j=0; j<logger.size(); j++){
                sb.append(logger.get(j));
            }
            sb.append("\n");
        }
        bw.write(sb.toString().trim());
        bw.close();
        br.close();
    }
}