import java.util.StringTokenizer;
import java.util.HashMap;
class Main {
    public static int[] solution(String today, String[] terms, String[] privacies) {
        StringTokenizer todayToken = new StringTokenizer(today,".");
        StringBuilder sb = new StringBuilder();
        int year = Integer.parseInt(todayToken.nextToken());
        int month = Integer.parseInt(todayToken.nextToken());
        int day = Integer.parseInt(todayToken.nextToken());
        int totalDay = (year-2000)*336+month*28+day;
        HashMap<String, Integer> termMap = new HashMap<>();
        for(String term: terms){
            String[] temp = term.split(" ");
            termMap.put(temp[0],Integer.parseInt(temp[1]));
        }
        for(int i=0; i<privacies.length; i++){
            String[] temp = privacies[i].split(" ");
            int termMonth = termMap.get(temp[1]);
            StringTokenizer dateToken = new StringTokenizer(temp[0],".");
            int tempYear = Integer.parseInt(dateToken.nextToken());
            int tempMonth = Integer.parseInt(dateToken.nextToken())+termMonth;
            int tempDay = Integer.parseInt(dateToken.nextToken());
            int tempTotalDay = (tempYear-2000)*336+tempMonth*28+tempDay;
            if(tempTotalDay<totalDay)
                System.out.println(i);
        }

        String[] ans = new String[]{" "," "};
        int[] answer = new int[ans.length];
        for(int i=0; i<ans.length; i++){
            answer[i] = Integer.parseInt(ans[i])+1;
        }

        return answer;
    }
    public static void main(String[] args){
        solution("2022.05.19",new String[]{"A 6", "B 12", "C 3"},new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
    }
}