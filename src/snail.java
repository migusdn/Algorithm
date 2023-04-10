public class snail {
    public static void main(String[] args) {
        int answer = 0;
       String s = "xababcdcdababcdcd";
        char[] charArr = s.toCharArray();
        int strLength = charArr.length;
        // compress(charArr, 1);
        for (int i = 1; i <= strLength / 2; i++) {
            System.out.println(
                    compress(charArr, i));
        }
    }
        public static int compress(char[] ch, int n){
            int sel_point = 0;
            int cur_point = 0;
            int length = 0;
            boolean flag = false;
            System.out.println("N:"+n);
            while(cur_point+n<ch.length){
                System.out.println("sel_point: "+sel_point +"\t cur_point: "+cur_point);
                for(int i=0; i<n;i++){
                    if(ch[sel_point+i] != ch[cur_point+i]){
                        if(cur_point-sel_point == n)
                            length+=n;
                        else
                            length+=n+1;
                        // System.out.println(sel_point+""+cur_point+""+length);
                        sel_point = cur_point;
                        break;
                    }
                }
                cur_point+=n;


                System.out.println(length);
            }
            if(cur_point-sel_point == n)
                length+=n;
            else
                length+=n+1;
            return length;
        }
    }

