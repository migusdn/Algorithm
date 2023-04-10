import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Q1028 {
    static int LD =1;
    static int RD =2;
    static int LU =3;
    static int RU =4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        ArrayList<ArrayList<int[]>> rightBottom=new ArrayList<>();
        ArrayList<Integer[]> leftBottom=new ArrayList<>();


        st=new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int[][] nums = new int[x][y];

        for(int i=0; i<x; i++){
            String str = br.readLine();
            for(int j=0; j<y; j++){
                nums[i][j]=str.charAt(j)-'0';
            }
        }

        for(int i=-1*x+1; i<x; i++){
            System.out.println(i);
            ArrayList<int[]> tempList = new ArrayList<>();
            int j;
            if(i<0)
                j=i*(-1);
            else
                j=0;
            while(j+i<x&&j<y){
//                System.out.println(i+j+", "+j);
                if(nums[j+i][j]==1){
                    System.out.println("(x, y)"+(i+j)+", "+j);
                    int [] temp= new int[2];
                    temp[0]=j+i;
                    int len = 0;
//                    System.out.println(ctn+i);
                    while((j+i<x&&j<y)&&nums[i+j][j]==1){
                        j++;
                        len++;
                    }

                    temp[1]=len;
                    tempList.add(temp);
                    System.out.println("x 절편"+i);
                    System.out.println(temp[0]+", "+temp[1]);
//
                    System.out.println();
                }else {
                    j++;
                }
            }
            rightBottom.add(x+i-1,tempList);
        }



        for(int i=0; i<2*x; i++){
            ArrayList<int[]> tempList = new ArrayList<>();
            int j;
            if(i<0)
                j=i*(-1);
            else
                j=0;
            while(j+i<x&&j<y){
//                System.out.println(i+j+", "+j);
                if(nums[j+i][j]==1){
                    System.out.println("(x, y)"+(i+j)+", "+j);
                    int [] temp= new int[2];
                    temp[0]=j+i;
                    int len = 0;
//                    System.out.println(ctn+i);
                    while((j+i<x&&j<y)&&nums[i+j][j]==1){
                        j++;
                        len++;
                    }

                    temp[1]=len;
                    tempList.add(temp);
                    System.out.println("x 절편"+i);
                    System.out.println(temp[0]+", "+temp[1]);
//
                    System.out.println();
                }else {
                    j++;
                }
            }
            rightBottom.add(i+x-1,tempList);
        }
        System.out.println(nums[0][1]);



    }


}
