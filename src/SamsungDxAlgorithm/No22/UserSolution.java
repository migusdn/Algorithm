package SamsungDxAlgorithm.No22;

public class UserSolution {
    class User {
        int uid;
        int income;
        User(int uid, int income){
            this.uid = uid;
            this.income = income;
        }
    }
    private User[] users;
    private int cnt;
    public void init() {
        this.users = new User[10];
        cnt=0;
    }

    public void addUser(int uID, int income) {
        User user = new User(uID, income);
        if(cnt<10){
            users[cnt] = user;
            cnt++;
        }else{
            int minIdx=0;
            for(int i=1; i<10; i++){
                User temp = users[i];
                if(temp.income>users[minIdx].income)
                    continue;
                if(temp.income<users[minIdx].income){
                    minIdx=i;
                }else if(temp.income == users[minIdx].income){
                    if(temp.uid>users[minIdx].uid)
                        minIdx=i;
                }
            }
            if(users[minIdx].income>user.income)
                return;
            if(users[minIdx].income<user.income){
                users[minIdx] = user;
            }else if(users[minIdx].income == user.income) {
                if (users[minIdx].uid > user.uid)
                    users[minIdx] = user;
            }
        }
    }

    int getTop10(int[] result) {
        int idx=0;
        while (idx<cnt){
            int maxIdx=idx;
            for(int i=idx; i<cnt; i++){
                User temp = users[i];
                if(temp.income<users[maxIdx].income)
                    continue;
                if(temp.income>users[maxIdx].income){
                    maxIdx=i;
                }else if(temp.income == users[maxIdx].income){
                    if(temp.uid<users[maxIdx].uid)
                        maxIdx=i;
                }
            }
            User temp = users[idx];
            users[idx] = users[maxIdx];
            users[maxIdx] = temp;
            idx++;
        }
        for(int i=0; i<cnt; i++){
            result[i] = users[i].uid;
        }
        return cnt;
    }
}