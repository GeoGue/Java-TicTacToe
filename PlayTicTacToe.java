/*
 * Name: Gina Guerra
 * Date: 10/1/2018
 * Description: allows user to play tic tac toe using their keyboard with the accompanying
 * TicTacToe.java class
 */

package tictactoe;

import java.util.Scanner;

public class PlayTicTacToe {

	private static void playGame(Scanner keyboard) {

		char p = 'X';	//x is the first player
		TicTacToe ttt = new TicTacToe();
		int r, c;

		do {
			// System.out.println(ttt);
			ttt.outputBoardData(ttt.board);
			do {
				System.out.print("'" + p + "', choose your location (row, column) (int between 0 and 2): "); //ask for user input
				try {
					r = keyboard.nextInt();	//seek row
					c = keyboard.nextInt();	//seek column
					if (!ttt.isValid(r, c))
						System.out.println("That is not a valid location. Try again."); //don't go outside the grid
					else if (ttt.getPlayerAt(r, c) != ' ') {
						System.out.println("That location is already full. Try again.");	//don't overwrite prior moves
					} else
						break;
				} catch (Exception e) {
					System.out.println("Bad Integer Entered. Try Again.");
					keyboard.nextLine(); // IMPORTANT! Clear keyboard!!!
				}
			} while (true);

			ttt.playMove(p, r, c);	//place X or O in designated row/column

			if (p == 'X') //switch players
				p = 'O';
			else
				p = 'X';

		} while (!ttt.isWinner('X') && !ttt.isWinner('O') && !ttt.isFull());//keep playing until someone wins or the board is full

		// System.out.println(ttt);
		ttt.outputBoardData(ttt.board);

		String status;					//system outputs for different scenarios
		if (ttt.isWinner('X'))
			status = "X is the winner!";
		else if (ttt.isWinner('O'))
			status = "O is the winner!";
		else
			status = "The game is a tie.";
		status += " After " + ttt.getTurns() + " plays.";	//state how many rounds it took to end the game
		System.out.println(status);
	}

	// **********************************************

	private static void process(Scanner sc, String args[]) {
		playGame(sc);
		sc.nextLine(); // IMPORTANT!! Reset Scanner
	}

	// **********************************************

	private static boolean doThisAgain(Scanner sc, String prompt) {	//allow users to play again
		System.out.print(prompt); //prompt user
		String doOver = sc.nextLine();	//take user input
		return doOver.equalsIgnoreCase("Y");	//check if input is yes
	}

	// **********************************************

	public static void main(String args[]) {
		final String TITLE = "Play Tic Tac Toe";	//title
		final String CONTINUE_PROMPT = "Play again? [y/N] ";	//prompt to play another round

		System.out.println("Welcome to " + TITLE);
		Scanner sc = new Scanner(System.in);
		do {
			process(sc, args);
		} while (doThisAgain(sc, CONTINUE_PROMPT));
		sc.close();
		System.out.println("Thank you for using " + TITLE);
	}

}
