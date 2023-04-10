public class quickSort {
    public static void main(String[] args){
        int[] input = new int[]{42,32,24,60,15,5,90,45};
        quickSort(input,0,input.length-1);
        for(int num:input){
            System.out.print(num+" ");
        }


    }
    public static void quickSort(int[] arr,int start, int end){
        int part2 = partition(arr, start,end);
        if(start<part2-1){
            quickSort(arr,start,part2-1);
        }
        if( part2 < end){
            quickSort(arr,part2,end);
        }
    }
    public static int partition(int[] arr, int start, int end){
        int pivot = arr[(start+end)/2];
        while(start<=end){
            while(arr[start] < pivot) start++;
            while(arr[end]> pivot) end--;
            if(start<=end){
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        return start;
    }
    public static void swap(int[] array,int a, int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }


}
