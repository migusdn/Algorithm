package Programmers;

import java.util.*;

class Q42587 {

    public static void main(String[] args) {
        String str = "";

    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        Arrays.sort(priorities);
        Queue<element> queue = new LinkedList<>();
        for(int i=0; i< priorities.length; i++){
            queue.add(new element(priorities[i], i+1));
        }
        for(int pri:priorities){
            stack.push(pri);
        }
        while(true){
            element ele = queue.poll();
            if(stack.peek()==ele.priority){
                stack.pop();
                answer++;
                if(ele.sequence==location){
                    break;
                }
            }else{
                queue.offer(ele);
            }

        }
        return answer;
    }
    public static class element{
        int priority;
        int sequence;
        element(int priority, int sequence){
            this.priority = priority;
            this.sequence = sequence;
        }
    }
}