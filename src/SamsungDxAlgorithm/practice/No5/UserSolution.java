package SamsungDxAlgorithm.practice.No5;
class UserSolution
{
    int max=100000;
    class Player{
        Player next;
        int score;
        int teamID;
        Player(int score, int teamID){
            this.score = score;
            this.teamID = teamID;
        }
    }
    class Team{
        public Team(int scoreDiff, int teamID, int playerNum, Player playerList) {
            this.scoreDiff = scoreDiff;
            this.teamID = teamID;
            this.playerNum = playerNum;
            this.playerList = playerList;
        }

        int scoreDiff;
        int teamID;
        int playerNum;
        Player playerList;
    }

    Player[] players;
    Team[] teams;
    public void init(int N)
    {
        players = new Player[max+1];
        teams = new Team[max+1];
        for (int i = 1; i <= N; i++)
        {
            Player p = new Player(0, i);
            Team t = new Team(0,1,i,p);
            players[i]=p;
            teams[i]=t;
        }
    }

    public void updateScore(int mWinnerID, int mLoserID, int mScore)
    {
        Team winTeam = teams[players[mWinnerID].teamID];
        Team loseTeam = teams[players[mLoserID].teamID];
        winTeam.scoreDiff += mScore;
        loseTeam.scoreDiff -=mScore;
    }

    public void unionTeam(int mPlayerA, int mPlayerB)
    {
        Team ATeam = teams[players[mPlayerA].teamID];
        Team BTeam = teams[players[mPlayerB].teamID];

        if (ATeam.playerNum > BTeam.playerNum)
        {
            Team tmp = ATeam;
            ATeam = BTeam;
            BTeam = tmp;
        }

        Player cur;
        cur = ATeam.playerList;
        while (cur.next != null)
        {
            cur.score += (ATeam.scoreDiff - BTeam.scoreDiff);
            cur.teamID = BTeam.teamID;
            cur = cur.next;
        }
        cur.score += (ATeam.scoreDiff - BTeam.scoreDiff);
        cur.teamID = BTeam.teamID;
        cur.next = BTeam.playerList;

        BTeam.playerList = ATeam.playerList;
        BTeam.playerNum += ATeam.playerNum;
    }

    public int getScore(int mID)
    {
        return players[mID].score + teams[players[mID].teamID].scoreDiff;
    }
}

