import java.io.*;

public class PrimitiveGame {
    int difficulty;
    public static void main(String[] args) throws IOException{
        System.out.print("Please Enter Difficulty: (1- Easy, 2-Medium, 3-Hard)");
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int diff=Integer.parseInt(br.readLine());
        Minesweeper minesweeper=new Minesweeper(diff);
    }
}
