import java.util.*;
import java.io.*;

public class Game{

    private Dungeon d;
    private int size;
    private Site mSite;
    private Site rSite;

    public Game(String filename) throws FileNotFoundException{

	//read in file
	File f = new File(filename);
	Scanner in = new Scanner(f);

	//get size of dungeon
	String line = in.nextLine();
	size = line.length();
	char[][] board = new char[size][size];

	//loop for first line
	for (int counter = 0; counter < size; counter++){
	    board[0][counter] = line.charAt(counter);
	}

	//fill in rest of dungeon
	for (int r = 1; r < size; r++){
	    String line = in.nextLine();
	    
	    for (int c = 0; c < size; c++){
	        board[r][c] = line.charAt(c);

		if (board[r][c] == 'A'){
		    //do monster stuff
		}

		if (board[r][c] == '@'){
		    //do rogue stuff
		}
	    }
	}

	d = new Dungeon(board);

    }

}

		
	    
	
