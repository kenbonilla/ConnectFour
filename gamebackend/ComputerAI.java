package gamebackend;


import java.util.Random;

/**
 *
 * @author ken
 */


public class ComputerAI {
    
    public static Random random = new Random();

    
    
    public static int[] makeMove(int[][] board){
        int[] coords = new int[2];
        final int COLMS = 7;
        final int ROWS = 6;
        int mover = 0;
        
        
        int holdrow = -1;
        int holdcolm = -1;
        
        
        
        //checks if user has stacked two high
        for(int i=0; i<COLMS; i++){
            mover = 0;
            for(int j = 0; j < ROWS; j++){
                switch (board[i][j]) {
                    case 1:
                        mover++;
                        break;
                    case 2:
                        mover = 0;
                        break;
                    default:
                        break;
                }

            }
	    if((mover > 1) && connectfour.ConnectFour.theBoard.isValidMove(i)){
                    int makeMove = connectfour.ConnectFour.theBoard.makeMove(i, false);
                    coords[0] = i;
                    coords[1] = makeMove;
                    
                    return coords;
                }
        }
        
        
        //checks if user is two wide
        for(int i = 0; i<ROWS; i++){
            for(int j = 0; j < COLMS; j++){
                if(board[j][i] == 1){
                    mover++;
                    if(mover > 1 ){
                        holdrow = i;
                        holdcolm = j+1;
                    }
                }
            }
        }
        if(holdcolm >= 0 && holdrow >=0 && holdcolm < COLMS && 
                connectfour.ConnectFour.theBoard.isValidMove(holdcolm)){
            int makeMove = connectfour.ConnectFour.theBoard.makeMove(holdcolm, false);
            coords[0] = holdcolm;
            coords[1] = makeMove;
            return coords;
        }
        
        //otherwise make random legal move
        int max = 6;
        int min = 0;
        int randColm;
        int makeMove;
        
        while(true){
            randColm = random.nextInt(max - min + 1) + min;
            if(connectfour.ConnectFour.theBoard.isValidMove(randColm)){
                makeMove = connectfour.ConnectFour.theBoard.makeMove(randColm, false);
                coords[0] = randColm;
                coords[1] = makeMove;
                return coords;
            }

        }
    }
}