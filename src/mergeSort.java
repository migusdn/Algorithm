public class mergeSort {
    static int[] input, temp;
    public static void main(String[] args){
        input = new int[]{42,32,24,60,15,5,90,45};
        temp = new int[input.length];
        mergeSort(0,input.length-1);
        for(int num:input){
            System.out.print(num+" ");
        }
    }
    private static void mergeSort(int start, int end){
        if(end-start<1)
            return;
        int middle = start+(end-start)/2;
        mergeSort(start,middle);
        mergeSort(middle+1,end);
        for(int i=start; i<=end; i++){
            temp[i] = input[i];
        }
        int k = start;
        int idx1 = start;
        int idx2 = middle+1;
        while(idx1<=middle&&idx2<=end){
            if(temp[idx1]<temp[idx2]){
                input[k]=temp[idx1];
                idx1++;
            }else{
                input[k] = temp[idx2];
                idx2++;
            }
            k++;
        }
        while(idx1<=middle){
            input[k]=temp[idx1];
            idx1++;
            k++;
        }
        while(idx2<=end){
            input[k]=temp[idx2];
            idx2++;
            k++;
        }
    }
}
