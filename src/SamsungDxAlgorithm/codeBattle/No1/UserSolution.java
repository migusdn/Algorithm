package SamsungDxAlgorithm.codeBattle.No1;

import java.util.*;

class Soldier implements Comparable<Soldier> {
    private final int mID;
    private final int mTeam;
    private int mScore;
    public Soldier(int mID,int mTeam, int mScore){
        this.mID = mID;
        this.mTeam = mTeam;
        this.mScore = mScore;
    }

    public void updateTeamScore(int mScore){
        this.mScore += mScore;
        if(this.mScore>5){
            this.mScore=5;
        }else if(this.mScore<1){
            this.mScore=1;
        }
    }
    public void updateScore(int mScore){
        this.mScore=mScore;
    }
    public int getmID(){
        return this.mID;
    }
    public int getMTeam(){
        return this.mTeam;
    }
    public int getMScore(){
        return this.mScore;
    }

    @Override
    public int compareTo(Soldier soldier) {
        if(this.mScore- soldier.getMScore()==0){
            return this.mID-soldier.getmID();
        }
        return this.mScore- soldier.getMScore();
    }
}
class UserSolution {
    private HashMap<Integer,Soldier> soldierHashMapById;
    private HashMap<Integer, List<Soldier>> soldierHashMapByTeam;
    public void init() {
        this.soldierHashMapById = new HashMap<>();
        this.soldierHashMapByTeam = new HashMap<>();
    }

    public void hire(int mID, int mTeam, int mScore) {
        Soldier soldier = new Soldier(mID,mTeam,mScore);
        soldierHashMapById.put(mID,soldier);
        if(soldierHashMapByTeam.containsKey(mTeam)){
            List<Soldier> team = soldierHashMapByTeam.get(mTeam);
            team.add(soldier);
        }else{
            List<Soldier> team = new ArrayList<>();
            team.add(soldier);
            soldierHashMapByTeam.put(mTeam,team);
        }
    }

    public void fire(int mID) {
        Soldier soldier = soldierHashMapById.get(mID);
        soldierHashMapByTeam.get(soldier.getMTeam()).remove(soldier);
        soldierHashMapById.remove(soldier);
    }

    public void updateSoldier(int mID, int mScore) {
        Soldier soldier = soldierHashMapById.get(mID);
        soldier.updateScore(mScore);
    }

    public void updateTeam(int mTeam, int mChangeScore) {
        List<Soldier> soldiers = soldierHashMapByTeam.get(mTeam);
        for(Soldier soldier: soldiers){
            soldier.updateTeamScore(mChangeScore);
        }
    }

    public int bestSoldier(int mTeam) {
        List<Soldier> soldiers = soldierHashMapByTeam.get(mTeam);
        soldiers.sort(Collections.reverseOrder());
        for(Soldier soldier:soldiers){
            System.out.println(soldier.getmID());

        }System.out.println("----");
        return soldiers.get(0).getmID();
    }
}