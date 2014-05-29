import java.io.*;
import java.util.*;
class Node{
	char board[][] = new char[8][8];
	
}
public class game {
	static void main(String [] args)
	{
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
	static boolean IsGoal(char [][] board)
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
