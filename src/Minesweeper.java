import java.util.Arrays;
import java.util.Random;

public class Minesweeper{
    private int maze[][], difficulty, mineCount, dimension;
    private char visibleMaze[][];
    public Minesweeper(int difficulty){
        this.difficulty=difficulty;
        this.generateMaze();
    }

    public void generateMaze(){
        if(this.difficulty==1){
            dimension=9;
            mineCount=10;
        }
        else if(this.difficulty==2){
            dimension=16;
            mineCount=40;
        }
        else if(this.difficulty==3){
            dimension=24;
            mineCount=99;
        }
        maze=new int[dimension][dimension];
        visibleMaze=new char[dimension][dimension];
        Arrays.fill(visibleMaze, 'X');

        Random rand=new Random();
        int mineLoc[]=new int[mineCount];
        for(int i=0;i<mineCount;i++){
            boolean chk;
            int loc;
            do{
                loc=rand.nextInt(dimension*dimension);
                chk=true;
                for(int j=0;j<i;j++){
                    if(mineLoc[j]==loc)
                        chk=false;
                }
            }while(chk==false);
            mineLoc[i]=loc;
            System.out.println(loc);
        }
        this.setMines(mineLoc);
        this.setHints();
        this.printMaze();
    }

    /**
     * This function plays out a click and reveals the maze accordingly
     * @param row = row number
     * @param col = col number
     * @return Integer variable. -1 if you clicked on a mine. 0 if the maze reveals more of itself. 1 if the entire maze is revealed.
     */
    public int playStep(int row, int col){
        if(maze[row][col]==-1)
            return -1;
        else if(maze[row][col]>0)
            visibleMaze[row][col]=(char)(maze[row][col]+'0');
        else if(maze[row][col]==0)
            revealMaze(row, col);
        return this.checkCompleteness();
    }

    private void setMines(int[] mineLoc){
        for(int i=0;i<mineLoc.length;i++){
            int row, col;
            row=mineLoc[i]/dimension;
            col=mineLoc[i]%dimension;
            maze[row][col]=-1;
        }
    }   

    private void setHints(){
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                if(maze[i][j]==-1)
                    continue;
                int neighbourMine=0;
                if(i>0)
                    if(maze[i-1][j]==-1)
                        neighbourMine++;
                if(i>0 && j>0)
                    if(maze[i-1][j-1]==-1)
                        neighbourMine++;
                if(i>0 && j<dimension-1)
                    if(maze[i-1][j+1]==-1)
                        neighbourMine++;
                if(i<dimension-1)
                    if(maze[i+1][j]==-1)
                        neighbourMine++;
                if(i<dimension-1 && j>0)
                    if(maze[i+1][j-1]==-1)
                        neighbourMine++;
                if(i<dimension-1 && j<dimension-1)
                    if(maze[i+1][j+1]==-1)
                        neighbourMine++;
                if(j>0)
                    if(maze[i][j-1]==-1)
                        neighbourMine++;
                if(j<dimension-1)
                    if(maze[i][j+1]==-1)
                        neighbourMine++;

                maze[i][j]=neighbourMine;                
            }
        }
    }

    private void printMaze(){
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++)
                System.out.print(maze[i][j]+" ");
            System.out.println();
        }
    }

    private void revealMaze(int row, int col){
        if(row>=dimension || col>=dimension || row<0 || col<0 || maze[row][col]==-1)
            return;
        if(maze[row][col]==0){
            visibleMaze[row][col]='0';
            revealMaze(row-1, col);
            revealMaze(row+1, col);
            revealMaze(row, col-1);
            revealMaze(row, col+1);
            revealMaze(row+1, col+1);
            revealMaze(row-1, col-1);
        }
        else if(maze[row][col]>0)
            visibleMaze[row][col]=(char)(maze[row][col]+'0');
    }

    private int checkCompleteness(){
        for(int i=0;i<dimension;i++){
            for(int j=0;j<dimension;j++){
                if(visibleMaze[i][j]!='X')
                    return 0;
            }
        }
        return 1;
    }
}