import java.io.*;

public class PrimitiveGame {
    int difficulty, steps=0;
    
    public static void main(String[] args) throws IOException{
        System.out.print("Please Enter Difficulty: (1- Easy, 2-Medium, 3-Hard) ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int diff=Integer.parseInt(br.readLine());
        Minesweeper minesweeper=new Minesweeper(diff);
        PrimitiveGame game=new PrimitiveGame();
        game.playGame(minesweeper);
    }

    private void playGame(Minesweeper minesweeper) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for(;;){
            minesweeper.showCurrentGame();
            System.out.println("Enter Row and Col:");
            int row=Integer.parseInt(br.readLine());
            int col=Integer.parseInt(br.readLine());
            int result=minesweeper.playStep(row, col);
            if(result==-1){
                System.out.println("Game Lost");
                System.exit(-1);
            }
            else if(result==1){
                System.out.println("Game Won! Congratulations!\nNumber of Steps = "+steps);
                System.exit(-1);
            }
            steps++;
        }
    }
}
