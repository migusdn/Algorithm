package SamsungDxAlgorithm;

public class bitExam {
    public static void main(String[] args){
        int bit=15;
        bitPrinter(bit);
        System.out.println(bitChecker(2,bit));
        System.out.println(bit|(1<<2));
        System.out.println(11|(1<<2));
    }
    public static void bitPrinter(int number){
        StringBuilder sb = new StringBuilder();
        for(int i=31; i>=0; i--){
            int mask = 1<< i;
            sb.append((number&mask)!=0?"1":"0");
        }
        System.out.println(sb);
    }
    public static boolean bitChecker(int number, int bit){

        return (bit&(1<<number))!=0;
    }
}
