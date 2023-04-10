import java.util.HashMap;
import java.util.HashSet;
import java.util.ArrayList;
class kakao {
    public static HashMap<String, HashSet<Cell>> valueMap = new HashMap<>();

    public static void main(String[] args){
        solution(new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"});
    }
    public static String[] solution(String[] commands) {
        Cell[][] table = new Cell[50][50];
        StringBuilder sb = new StringBuilder();
        for(String command:commands){
            String[] cmd = command.split(" ");
            String func = cmd[0];
            switch(func){
                case "UPDATE":{
                    if(cmd.length==4){
                        int r = Integer.parseInt(cmd[1])-1;
                        int c = Integer.parseInt(cmd[2])-1;
                        Cell cell = table[r][c];
                        if(cell==null){
                            cell=new Cell();
                            table[r][c] = cell;
                        }
                        cell.setValue(cmd[3]);
                    }else{
                        String value1 = cmd[1];
                        String value2 = cmd[2];
                        HashSet<Cell> cells = valueMap.get(value1);
                        if(cells!=null){
                            for(Cell c:cells){
                                c.setValue(value2);
                            }
                        }
                        valueMap.put(value1, null);
                    }
                    break;
                }
                case "MERGE":{
                    int r1 = Integer.parseInt(cmd[1])-1;
                    int c1 = Integer.parseInt(cmd[2])-1;
                    int r2 = Integer.parseInt(cmd[3])-1;
                    int c2 = Integer.parseInt(cmd[4])-1;
                    Cell cell1 = table[r1][c1];
                    Cell cell2 = table[r2][c2];
                    if(cell1==null&&cell2!=null){
                        table[r1][c1] = cell2;
                    }else if(cell1==null&&cell2==null){
                        cell1 = new Cell();
                        table[r1][c1] = cell1;
                        table[r2][c2] = cell1;
                    }else if(cell1!=null&cell2==null){
                        table[r2][c2] = cell1;
                    }else{
                        if(cell1.getValue()!=null){
                            for(int i=0; i<50; i++){
                                for(int j=0; j<50; j++){
                                    if(table[i][j]==cell2)
                                        table[i][j]=cell1;
                                }
                            }
                        }else{
                            for(int i=0; i<50; i++){
                                for(int j=0; j<50; j++){
                                    if(table[i][j]==cell1)
                                        table[i][j]=cell2;
                                }
                            }
                        }

                    }
                    break;
                }
                case "UNMERGE":{
                    int r = Integer.parseInt(cmd[1])-1;
                    int c = Integer.parseInt(cmd[2])-1;
                    Cell cell = table[r][c];
                    if(cell!=null){
                        for(int i=0; i<50; i++){
                            for(int j=0; j<50; j++){
                                if(i==r&&j==c)
                                    continue;
                                else{
                                    if(table[i][j]==cell)
                                        table[i][j]=null;
                                }
                            }
                        }
                    }
                    break;
                }
                case "PRINT":{
                    int r = Integer.parseInt(cmd[1])-1;
                    int c = Integer.parseInt(cmd[2])-1;
                    if(table[r][c]!=null)
                        sb.append(table[r][c].print());
                    else
                        sb.append("EMPTY");
                    sb.append(" ");
                    break;
                }
            }
        }
        tablePrint(table);

        // System.out.println("test");
        // if(table[0][3]==table[1][1])
        //     System.out.println("yes");
        // else
        //     System.out.println("NO");

        String[] answer = sb.toString().trim().split(" ");
        return answer;
    }
    public static class Cell{
        private String value;
        public void setValue(String value){
            if(value!=null){
                if(this.value!=null){
                    HashSet<Cell> originalSet = valueMap.get(this.value);
                    originalSet.remove(this);
                }
                HashSet<Cell> cellsBySameValue = valueMap.get(value);
                if(cellsBySameValue==null){
                    cellsBySameValue = new HashSet<>();
                    valueMap.put(value, cellsBySameValue);
                }
                this.value = value;
                cellsBySameValue.add(this);
            }
        }
        public String getValue(){
            return this.value;
        }
        public String print(){
            return this.value==null?"EMPTY":this.value;
        }
    }
    public static void tablePrint(Cell[][] table){
        int r=0;

        for(Cell[] row: table){
            if(r==10)
                break;
            int c=0;
            for(Cell cell:row){
                if(c==10)
                    break;
                if(cell!=null)
                    System.out.print(cell.getValue()+"  ");
                else
                    System.out.print("n  ");
                c++;
            }
            r++;
            System.out.print("\n");
        }
    }
}