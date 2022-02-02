package tictactoe;

import java.util.Arrays;

public class TicTacToe {
	char board[][] = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };
	int turns = 0;

	void TicTacToeClass() {
	}

	int getTurns() {
		return turns;	//keep track of how many turns have passed
	}

	char getPlayerAt(int r, int c) {
		return board[r][c];	//check what's in the space in which a user wants to play
	}

	public String toString() {
		return Arrays.toString(board[0]) + Arrays.toString(board[1]) + Arrays.toString(board[2]); //create the board's empty spaces
	}

	boolean isTied() {	//check if a board is full and no winners exist
		if (isFull() && isWinner('X') == false && isWinner('O') == false) {
			return true;
		}
		return false;
	}

	boolean isWinner(char p) {	//check if player move becomes a winning move
		for (int r = 0; r < board.length; r++) {
			if (board[r][0] == p && board[r][1] == p && board[r][2] == p) { //horizontal win
				return true;
			}
			for (int c = 0; c < board[r].length; c++) {
				if (board[0][c] == p && board[1][c] == p && board[2][c] == p) {	//vertical win
					return true;
				}

			}
		}
		if (board[0][0] == p && board[1][1] == p && board[2][2] == p) {
			return true;	//diagonal win 1
		}
		if (board[2][0] == p && board[1][1] == p && board[0][2] == p) {
			return true;	//diagonal win 2
		}
		return false;
	}

	boolean isFull() {	//check if the board is full
		if (turns == 9) {
			return true;	//if 9 turns have transpired, the board is full
		}
		return false;
	}

	boolean isValid(int r, int c) {	//make sure player attempts a valid move
		if (r < 0 || r > 2) {
			return false;
		}
		if (c < 0 || c > 2) {
			return false;
		} else {
			return true;
		}
	}

	void playMove(char p, int r, int c) {	//add move to board
		board[r][c] = p;
		turns = turns + 1;	//keep track of turns
	}

	public static void outputBoardData(char board[][]) {	//print out the board on the console
		for (int r = 0; r < board.length; r++) {
			for (int c = 0; c < board[r].length; c++) {
				System.out.print("+---");
			}
			System.out.println("+");
			for (int c = 0; c < board[r].length; c++) {
				System.out.print("| " + board[r][c] + " ");
			}

			System.out.println("|");
			if (r == board.length - 1) {
				for (int c = 0; c < board[r].length; c++) {
					System.out.print("+---");
				}
				System.out.println("+");	
			}
		}

	}

}
