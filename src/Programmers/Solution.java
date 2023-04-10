package Programmers;

import java.util.Arrays;
import java.util.Collections;

import java.util.Arrays;
class Solution {
    static int[] check;
    //-1사용한수
    //0 아직 사용하지않은수
    //1 현재 최댓값인 수
    static StringBuilder sb = new StringBuilder();
    static char[][] numbers;
    static int ctn = 0;
    public static void main(String[] args) {
        int[] array = {3, 30,34, 5, 9};
        check = new int[array.length];
        numbers = new char[array.length][];
        for(int i=0; i<array.length; i++){
            numbers[i] = String.valueOf(array[i]).toCharArray();
        }
        findMax(0);
        System.out.println(sb.toString());
    }
    public static void findMax(int cursor){
        System.out.println("=====================");
        boolean flag = false;
        if(ctn>numbers.length-1)
            return;
        int currentMaxValue = -1;
        boolean dup = false;
        System.out.println("Current cursor is "+cursor);
        for(int i=0; i<numbers.length; i++){
            if(check[i]==-1)
                continue;
            char[] currentNum = numbers[i];
            System.out.println("currentNum Length:"+currentNum.length);
            if(cursor>currentNum.length-1){
                if(currentMaxValue<currentNum[currentNum.length-1]);
                    currentMaxValue=currentNum[currentNum.length-1];
                flag = true;

            } else {
                System.out.println("currentNum: "+(char)currentNum[cursor]);

                if(currentMaxValue<currentNum[cursor]){
                    currentMaxValue = currentNum[cursor];
                    System.out.println((char)currentMaxValue+" is Max!!");
                    dup = false;
                }
                else if(currentMaxValue == currentNum[cursor]) {
                    dup = true;
                    System.out.println("is duplicate val");
                }
            }
        }
        for(int i=0; i<numbers.length; i++){

            char[] currentNum = numbers[i];
            if(check[i] == -1)
                continue;
            else if(cursor>currentNum.length-1){
                if(currentNum[currentNum.length -1 ]==currentMaxValue) {
                    check[i] = -1;
                    ctn++;
                    sb.append(currentNum);
                }

            }

            else{
                if(currentNum[cursor] == currentMaxValue)
                    if(dup)
                        check[i] = 1;
                    else{
                        check[i] = -1;
                        sb.append(currentNum);
                        ctn++;
                        System.out.println("unique value");
                        break;
                    }
            }
        }
        System.out.println("current used item: "+ctn);
        if(dup) {
            findMax(cursor+1);
            System.out.println("is dup");
        }
        else
            findMax(cursor);
    }
}