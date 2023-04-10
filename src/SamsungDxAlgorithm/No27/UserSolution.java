package SamsungDxAlgorithm.No27;

import java.util.*;

public class UserSolution {
    static int[] like = new int[200000];
    static Vector<Integer>[] user;
    static Vector<Integer>[] follow_user;
    public static void init(int N) {
        like = new int[200000]; // 좋아요 수 배열.
        int answer_score = 0;

        // user와 follow_user 초기화.
        user = new Vector[N+1];
        follow_user = new Vector[N+1];
        for (int i = 1; i <= N; i++) {
            user[i] = new Vector<Integer>();
            follow_user[i] = new Vector<Integer>();
        }
    }

    public static void follow(int uID1, int uID2, int timestamp) { // uID1 -> uID2를 timestamp 시간에 follow
        follow_user[uID1].add(uID2); // user_follow 추가.
    }

    public static void makePost(int uID, int pID, int timestamp) { // uid가 Pid라는 게시글을 timestmap에 발행
        // post[pid]에는 timestamp가 찍혓음
        user[uID].add(pID); // user에 추가.
    }

    public static void like(int pID, int timestamp) { // pid 게시글의 좋아요 수를 ++
        like[pID]++; // 좋아요 수 하나 올려줌.
    }

    public static void getFeed(int uID, int timestamp, int[] pIDList) { // uid가 timestamp시간에 볼 수 있는 feed를 보여줘야함.
        // uid가 팔로우한 목록이고, timestamp - 글의 timestamp를 도출해서 우선순위를 결정
        for (int i = 0; i < follow_user[uID].size(); i++) {
            int people = follow_user[uID].get(i); // UID가 팔로우한 유저
            for (int j = 0; j < user[people].size(); j++) { // 우선순위 타임스탬프 > 좋아요수 >
                int p_num = user[people].get(j); // user가 쓴 pid num
            }
        }
    }
}
