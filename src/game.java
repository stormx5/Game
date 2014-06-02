import java.io.*;
import java.util.*;

class Node{
	char board[][] = new char[8][8];
	int evaluation_score;
	String str_board = "";
	
}
public class game {
	static void main(String [] args)
	{
		ArrayList<HashMap<String, Node>> Tree = new ArrayList<HashMap<String,Node>>();
		int duartion;
		System.out.println("Please Enter the Duration between Each Move");
		Scanner s = new Scanner(System.in);
		duartion = s.nextInt();
		s.close();
		Scanner s1 = new Scanner(System.in);
		char first_turn;
		System.out.println("Please choose who will Start, Enter 1 for Human, and 2 for PC");
		int x = s1.nextInt();
		if(x == 1)
			first_turn = 'O';
		else if(x ==2)
			first_turn = 'X';
	}
	static void MiniMax(char first, int duration)
	{
		HashMap<String, String> AllMoves_PC = new HashMap<String, String>();
		HashMap<String, String> AllMoves_Human = new HashMap<String, String>();
		duration = duration * 1000; /// change it to milliseconds
		char [][] board = new char[8][8];
		String Move="";
		//// First Move
		if(first == 'X')
		{
			Move = input(board);
			AllMoves_PC.put(Move, Move);
			Move = Move.trim();
			char row_ = Move.charAt(0);
			int row = GetCharIndex(row_);
			int col =Integer.parseInt(Move.charAt(1)+"");
			board[row][col] = 'X';
			GetChildren(first);
			output(board, AllMoves_Human, AllMoves_PC);
		}
		else if(first == 'O')
		{
			Move = input(board);
			AllMoves_PC.put(Move, Move);
			Move = Move.trim();
			char row_ = Move.charAt(0);
			int row = GetCharIndex(row_);
			int col =Integer.parseInt(Move.charAt(1)+"");
			board[row][col] = 'O';
			GetChildren(first);
			output(board, AllMoves_Human, AllMoves_PC);
		}
		
	///// Moves after that
		while(!IsGoal(board))
		{
			
		}
		
	}
	
	//evaluation function
	static int evaluation(char [][] board)
	{
		int eval = 0;
		for(int i = 0; i < 8; i++)
		{
			for(int j = 0; j < 8; j++)
			{
				//we want the middle, so increase the score as you go through the mid
				//decrease when mid is reached
				if(i < 3 && j < 3) eval++;
				else eval--;
				
				//evaluates whether our piece is desirable in that place or not
				if(board[i][j] == 'O') eval = eval + FindAdjacent(i, j, board);
			}
		}
		
		eval = eval + IsGoal(board); //check if goal state or not
		return eval;
	}
	
	//returns a value depending on how many and which pieces are next to our piece
	//if O is next to it, +1. If X is next to it, -1
	//Only checks the next 4 adjacent
	static int FindAdjacent(int row, int column, char[][] board)
	{
		int score = 1;
		int diagonalUp = 0; //for checking up diagonal
		int diagonalDown = 0; //for checking down diagonal
		
		//checks the north of the piece
		for(int i = row-1; i > row-4; i++)
		{
			if(i < 0) break;
			else if(board[i][column] == 'O') score++;
			else if(board[i][column] == 'X') score--;
		}
		
		//checks the south of the piece
		for(int i = row+1; i < row+4; i++)
		{
			if(i > 7) break;
			else if(board[i][column] == 'O') score++;
			else if(board[i][column] == 'X') score--;
		}
		
		//checks the left
		diagonalUp = row;
		diagonalDown = row;
		for(int i = column-1; i < column-4; i++)
		{
			if(i < 0) break;
			else if(board[row][i] == 'O') score++;
			else if(board[row][i] == 'X') score--;
			
			//check diagonal for pieces
			if(diagonalUp > 0)
			{
				if(board[diagonalUp][i] == 'O') score++;
				else if(board[diagonalUp][i] == 'X') score--;
				diagonalUp--;
			}
			
			if(diagonalDown < 7)
			{
				if(board[diagonalDown][i] == 'O') score++;
				else if(board[diagonalDown][i] == 'X') score--;
				diagonalDown++;
			}
		}
		
		//checks the right
		diagonalUp = row;
		diagonalDown = row;
		for(int i = column+1; i < column+4; i++)
		{
			if(i < 0) break;
			else if(board[row][i] == 'O') score++;
			else if(board[row][i] == 'X') score--;
					
			//check diagonal direction for pieces
			if(diagonalUp > 0)
			{
				if(board[diagonalUp][i] == 'O') score++;
				else if(board[diagonalUp][i] == 'X') score--;
				diagonalUp--;
			}
			
			if(diagonalDown < 7)
			{
				if(board[diagonalDown][i] == 'O') score++;
				else if(board[diagonalDown][i] == 'X') score--;
				diagonalDown++;
			}
		}
		return score;
	}
	static int IsGoal(char [][] board)
	{
		int x = 0; int o = 0;
		for(int i = 0 ; i < 8; i ++)
		{
			for(int k = 0 ; k < 8 ; k++)
			{
				if(board[k][i] == 'X' )
				{
					
				}
				else if(board[k][i] == 'O')
				{
					
				}
			}
		}
		return true;
	}
	static Node GetChildren(char turn)
	{
		Node N = new Node();
		
		return N;
	}
	static String input(char [][] board)
	{
		Scanner scn = new Scanner(System.in);
		System.out.println("Please Make your move");
		String Move = scn.nextLine();
		Move = Move.trim().replaceAll("\\s+", "");
		scn.close();
		if(Move.length() > 2)
		{
			System.out.println("Please Enter a Legal Move");
			return null;
		}
		if(Character.isDigit(Move.charAt(0)))
		{
			System.out.println("Please Enter the Charecter first then the Digit");
			return null;
		}
		Move = Move.toUpperCase();
		char first = Move.charAt(0);
		String temp = Move.charAt(1)+"";
		int second = Integer.parseInt(temp.trim().replaceAll("\\s+", ""));
		////// Check if the Entered Cell is taken or not
		////// First get the Index of the character entered
		int index = GetCharIndex(first);
		if(board[second][index] != '\0')
		{
			System.out.println("Please select Another Cell because this one is taken");
			return null;
		}
		return Move;
	}
	static void output(char [][] board, HashMap<String, String> PMoves, HashMap<String, String> OMoves)
	{
		int index = -1;
		char [] ab = {'A','B','C','D','E','F','G','H'};
		for(int i = 0 ; i < 8 ; i++)
		{
			System.out.print("    "+i+1+ " ");
		}
		System.out.println("Player VS Computer");
		for(int i = 0 ; i < 8; i++)
		{
			index = i;
			System.out.print(ab[i]+"  ");
			for(int k = 0; k < 8 ; k++)
			{
				System.out.print(board[i][k]+" ");
			}
			System.out.println("   "+ index+1+ ". " +PMoves[i]+"  "+OMoves[i]);
			System.out.println();
		}
		
	}
	static int GetCharIndex(char ch)
	{
		
		int index = 0;
		switch(ch)
		{
		case 'A': index = 0;
		break;
		case 'B': index = 1;
		break;
		case 'C': index = 2;
		break;
		case 'D': index = 3;
		break;
		case 'E': index = 4;
		break;
		case 'F': index = 5;
		break;
		case 'G': index = 6;
		break;
		case 'H': index = 7;
		break;
		default:index = 99;
		break;
		}
		
		return index;
	}

}
