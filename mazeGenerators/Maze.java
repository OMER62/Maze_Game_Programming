
package algorithms.mazeGenerators;


import java.util.HashMap;
import java.util.Map;

public class Maze  {
    private int[][] mazeStruct;
    private Position Start;
    private Position Goal;


    /**
     * creating a maze instance
     * @param mazeStruct
     * @param start
     * @param goal
     */
    public Maze(int[][] mazeStruct, Position start, Position goal) {
        this.mazeStruct = mazeStruct;
        this.Start = start;
        this.Goal = goal;
    }

    /**
     * @return startPosition
     */
    public Position getStartPosition() {
        return this.Start;
    }


    /**
     * @return goalPosition
     */
    public Position getGoalPosition() {
        return this.Goal;
    }


    /**
     * prints the maze
     */
    public void print() {
        for (int i=0;i<this.mazeStruct.length;i++) {
            System.out.print("{ ");
            for (int j = 0; j < this.mazeStruct[0].length; j++) {
                if(i == this.Start.getRowIndex() && j == this.Start.getColumnIndex()){
                    System.out.print("S ");
                }
                else if (i == this.Goal.getRowIndex() && j == this.Goal.getColumnIndex()){
                    System.out.print("E ");
                }
                else{
                    if(this.mazeStruct[i][j] == 1 )
                    {
                        System.out.print("1 ");
                    }
                    else{
                        System.out.print(this.mazeStruct[i][j] + " ");
                    }
                }

            }
            System.out.print("}");
            System.out.println();
        }
    }

    /**
     * @return num of rows
     */
    public int GetRow() {
        return this.mazeStruct.length;
    }

    /**
     * @return num of columns
     */
    public int GetColumn() {
        return this.mazeStruct[0].length;
    }




    public Map<Position,Integer > getPossiblePosition(Position position){ // delete prob
        Map<Position, Integer> map = new HashMap<>();
        int Cur_row=position.getRowIndex();
        int Cur_column=position.getColumnIndex();
        int New_Row,New_column=0;
        int Step2_Row,Step2_column=0;
        Boolean IsLegal_Upper,IsLegal_Lower,IsLegal_Right,IsLegal_Left=false;

        /****Upper-(1,1)->(0,1)****/
        New_Row=Cur_row-1;
        New_column=Cur_column;
        IsLegal_Upper=this.IsLegal(New_Row,New_column);
        if(IsLegal_Upper==true)
            map.put(new Position(New_Row,New_column),10);

        /****Lower-(1,1)->(2,1)****/
        New_Row=Cur_row+1;
        New_column=Cur_column;
        IsLegal_Lower=this.IsLegal(New_Row,New_column);
        if(IsLegal_Lower==true)
            map.put(new Position(New_Row,New_column),10);

        /****Left-(1,1)->(2,1)****/
        New_Row=Cur_row;
        New_column=Cur_column-1;
        IsLegal_Left=this.IsLegal(New_Row,New_column);
        if(IsLegal_Left==true)
            map.put(new Position(New_Row,New_column),10);

        /****Right-(1,1)->(0,1)****/
        New_Row=Cur_row;
        New_column=Cur_column+1;
        IsLegal_Right=this.IsLegal(New_Row,New_column);
        if(IsLegal_Right==true)
            map.put(new Position(New_Row,New_column),10);


        //Diagonal down right-(1,1)->(2,2)
        New_Row=Cur_row+1;
        New_column=Cur_column+1;
        if((this.IsLegal(New_Row,New_column)==true)&&(IsLegal_Right==true))
            map.put(new Position(New_Row,New_column),15);



        //Diagonal top right-(1,1)->(0,2)
        New_Row=Cur_row-1;
        New_column=Cur_column+1;
        //Upping+Right IsLegal Checking
        if((this.IsLegal(New_Row,New_column)==true)&&(IsLegal_Upper==true))
            map.put(new Position(New_Row,New_column),15);

        //Diagonal top left-(1,1)->(0,0)
        New_Row=Cur_row-1;
        New_column=Cur_column-1;
        if((this.IsLegal(New_Row,New_column)==true)&&(IsLegal_Upper==true))
            map.put(new Position(New_Row,New_column),15);


        //Diagonal down left-(1,1)->(2,0)
        New_Row=Cur_row+1;
        New_column=Cur_column-1;
        if((this.IsLegal(New_Row,New_column)==true)&&(IsLegal_Left==true))
            map.put(new Position(New_Row,New_column),15);
        return map;
    }


    /**
     * checks if the row and column given as params are legal within our grid
     * @param New_Row
     * @param New_column
     * @return boolean
     */
public boolean IsLegal(int New_Row,int New_column ){
    int Border_Row=this.mazeStruct.length;
    int Border_Column=this.mazeStruct[0].length;
    return((New_Row<Border_Row)&&(New_column<Border_Column)&&
            (New_Row>=0)&&(New_column>=0)&&(this.mazeStruct[New_Row][New_column]!=1));
    }

}
