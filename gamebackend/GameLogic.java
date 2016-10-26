/**
 * 
 */
package gamebackend;

/**This class handles the processing and verification for the Connect4 game
 * @author Shawn
 *
 */
public class GameLogic {
	protected int[][] board;
	protected String player1 = "", player2 = "";
	protected int player1Wins = 0, player2Wins = 0;
	
	
	public GameLogic(String player1name, String player2name) { 
        this.board = new int[7][6];
		this.player1 = player1name;
		this.player2 = player2name;
		
		//set board initial state to all 0's
		for (int i = 0; i < 7; i++) { 
			for (int z = 0; z < 6; z++) { 
				board[i][z] = 0;
			}
		}
	}
	
	public GameLogic() { 
        this.board = new int[7][6];
		this.player1 = "Player 1";
		this.player2 = "Player 2";
		
		//set board initial state to all 0's
		for (int i = 0; i < 7; i++) { 
			for (int z = 0; z < 6; z++) { 
				board[i][z] = 0;
			}
		}
		
	}
        
        public int[][] getBoard(){
            return board;
        }
	
	public void setName(boolean player, String name) { 
		if (player) { 
			this.player1 = name;
		}
		else this.player2 = name;
	}
	
	public String getName(boolean player) {
		if (player) { 
			return player1;
		}
		else return player2;
	}
	
	
	//Valid move check. based on column if final value is 0 then the move is valid as pieces added default to lowest open
	public boolean isValidMove(int column) { 
		boolean valid = true;
		if (board[column][5] != 0) 
			valid = false;
		return valid;
	}
	
	public  int makeMove(int column, boolean player) {
		int row = 0;
		int playernumber;
		if (player == true) { 
			playernumber = 1;
		}
		else playernumber = 2;
		
		for (int i = 0; i < 6; i++) { 
			if (board[column][i] == 0) { 
				row = i;
				break;
			}
		}
		board[column][row] = playernumber;
		return row;
	}
	
	public  void boardReset() { 
		for (int i = 0; i < 7; i++) { 
			for (int z = 0; z < 6; z++) { 
				board[i][z] = 0;
			}
		}
	}
	
	public int getPlayerWins(int player) { 
		int numwins;
		if (player == 1)
			numwins = player1Wins;
		else if (player == 2)
			numwins = player2Wins;
		else numwins = 0;
		return numwins;
	}
	
	public void incrPlayerWins(boolean player){
	    if(player){
		player1Wins++;
	    }else{
		player2Wins++;
	    }
	}
	
	public void clearWins(){
	    player1Wins = 0;
	    player2Wins = 0;
	}
	
	//when traversing the board, the first index number is the column, the second is the row within the column, from the bottom up
	public  int isWinner() { 
		int numInColumn, winningNumber = 0, numInRow, numDiagonal;
		boolean winner = false;
		
		//Checks for Vertical 4 in a row win status
		for (int i = 0; i < 7; i++) {
			numInRow = 1;
			for (int z = 0; z < 6; z++) {
				if (z+1 >= 6)
					break;
				if (board[i][z] == board[i][z+1] && board[i][z] != 0) { 
					numInRow++;
					
					
				}
				else numInRow = 1;
				if (numInRow == 4) {
					winningNumber = board[i][z];
					winner = true;
					return winningNumber;
				}
			}
		}
		
		//Checks for Horizontal 4 in a row win status, but only if Vertical hasn't been found first
		if (winningNumber == 0 ) { 
			for (int y = 0; y < 6; y++){
				numInColumn = 1;
				for (int w = 1; w < 7; w++) { 
					if (board[w][y] == board[w-1][y] && board[w][y] != 0) { 
						numInColumn++;
						
					}
					else numInColumn = 1;
					if (numInColumn == 4) { 
						winningNumber = board[w][y];
						winner = true;
						return winningNumber;
					}
				}
				
			
			}
		}
		
		
		//Checks diagonals from bottom left up to right
		if (winningNumber == 0) {
		for (int c = 0; c < 7; c++){
			for (int r = 0; r < 3; r++){
				int x = c;
				int y = r;
				numDiagonal = 1;
				if (x + 1 < 7 && y + 1  < 6){
				do{
					if (x + 1 > 6 || y + 1 > 5)
						break;
					if (board[x][y] == board[x+1][y+1] && board[x][y] != 0){
					numDiagonal++;
					x++;
					y++;
					}
					else {
						x = c;
						y = r;
					}
					if (numDiagonal == 4){
						winningNumber = board[x][y];
						winner = true;
						return winningNumber;
					}
					
				}while (x != c && y != r);
			}
			}
		}
		}
		
		//Checks diagonals from upper left down to the right
		if (winningNumber == 0){
		for (int c = 0; c < 7; c++){
			for (int r = 5; r > -1; r--){
				int x = c;
				int y = r;
				numDiagonal = 1;
				if (x + 1 < 7 && y - 1 > -1){
				do{
					if(x+1 > 6 || y - 1 < 0)
						break;
					if (board[x][y] == board[x+1][y-1] && board[x][y] != 0){
					numDiagonal++;
					x++;
					y--;
					}
					else {
						x = c;
						y = r;
					}

					if (numDiagonal == 4){
						winningNumber = board[x][y];
						winner = true;
						return winningNumber;
					}
					
				}while (x != c);
			}
			}
		}
		}		
		
		
		//Returns integer value 3 if board is full, indicated by top row having no empty values
		if (winningNumber == 0) { 
			int fullColumns = 0;
			for (int column = 0; column < 7; column++) { 
				if (board[column][5] != 0)
						fullColumns++;
			}
			if (fullColumns == 7) {
				winningNumber = 3;
				return winningNumber;
			}
		}
		

		
		else winner = false;
		
		return winningNumber;
	}
	

}

