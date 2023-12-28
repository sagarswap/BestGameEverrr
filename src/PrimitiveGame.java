import java.io.*;

public class PrimitiveGame {
    int difficulty, steps=0;
    
    public static void main(String[] args) throws IOException{
        System.out.print("Please Enter Difficulty: (1- Easy, 2-Medium, 3-Hard) ");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int diff=Integer.parseInt(br.readLine());
        Minesweeper minesweeper=new Minesweeper(diff);
        PrimitiveGame game=new PrimitiveGame();
        game.playGame();
    }

    private void playGame() throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        for(;;){
            System.out.println("Enter Row and Col:");
            int row=Integer.parseInt(br.readLine());
            int col=Integer.parseInt(br.readLine());
            
        }
    }
}
