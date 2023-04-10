import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//위상정렬
public class TopologySort {
    public static ArrayList<Integer> result = new ArrayList<>();
    public static void main(String[] args){
        int[][] input = new int[][]{
                {1,2},
                {1,3},
                {2,4},
                {2,5},
                {3,4},
                {4,5}
        };
        int n = 5;
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i=0; i<n+1; i++)
            graph[i]=new ArrayList<>();
        for(int[] arr:input){
            graph[arr[0]].add(arr[1]);
        }
        int[] w = new int[n+1];
        for(ArrayList<Integer> arrayList:graph){
            for(int i:arrayList)
                w[i]++;
        }
        topologySort(graph,w);
        for(int i:result)
            System.out.print(i+" ");
    }
    public static void topologySort(ArrayList<Integer>[] graph, int[] w){
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i< w.length; i++){
            int weight = w[i];
            if(weight==0) {
                queue.add(i);
                break;
            }
        }
        while(!queue.isEmpty()){
            int currentIdx = queue.poll();
            result.add(currentIdx);
            ArrayList<Integer> currentNode = graph[currentIdx];
            for(int target: currentNode){
                w[target]--;
                if(w[target]==0)
                    queue.add(target);
            }
        }
    }
}
