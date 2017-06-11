import java.util.*;
import java.io.*;

public class Game{

    private Dungeon d;
    private int size;
    private Site mSite;
    private Site rSite;
    private Monster m; 
    private Rogue r;
    private static String input;

    public Game(String filename) throws FileNotFoundException{

	//read in file
	File f = new File(filename);
	Scanner in = new Scanner(f);
        Scanner format = new Scanner(in.nextLine());
	size = format.nextInt();
	char[][] board = new char[size][size];
	
	//fill in rest of dungeon
	for (int r = 0; r < size; r++){
	    String line = in.nextLine();
	    
	    for (int c = 0; c < size; c++){
	        board[r][c] = line.charAt(2*c);
		if (board[r][c] == 'A'){
		    mSite = new Site(r,c);
		}

		if (board[r][c] == '@'){
		    rSite = new Site(r,c);
		}
	    }
	}
	d = new Dungeon(board);
	m = new Monster(this);
	r = new Rogue(this);
    }
    
    public Site getMonsterSite(){
	return mSite;
    }

    public Site getRogueSite(){
	return rSite;
    }
    
    public Dungeon getDungeon(){
	return d;
	}

    public void play(String command){

	//for (int move = 1; true; move++){
	//System.out.println();

	//monster turn
	    
	//check for death
	//if (mSite.equals(rSite)){
	//   break;
	//}
	    
	//move to new site
	Site n = m.move(rSite);
	if (d.isLegalMove(mSite, n)){
	    mSite = n;
	}
	System.out.println(this);
	    
	//rogue turn
	    
	//check for death
	//if (rSite.equals(mSite)){
	//    break;
	//}

        n = r.move(command);
	rSite = n;
	System.out.println(this);
	
	//move to new site
	/*n = r.move();
	rSite = n;
	if (d.isLegalMove(rSite, n)){
	    rSite = n;
	}
	System.out.println(this);*/
	
    }
	//System.out.println("You lost...");


    public String toString(){
	String total = "";

	//loop through, checking each site
	for (int r = 0; r < size; r++){
	    for (int c = 0; c < size; c++){
		Site current = new Site(r,c);

		if (rSite.equals(current)){
		    total += '@';
		}
		else if (mSite.equals(current)){
		    total += 'A';
		}
		else if (d.isRoom(current)){
		    total += ".";
		}
                else if (d.isCorridor(current)){
		    total += "+";
		}
                else if (d.isWall(current)){
		    total += " ";
		}
	    }
	    total += "\n";
	}
	return total;
    }
		
    public static void main(String[] args) throws FileNotFoundException{
	String file = args[0];
	Game g = new Game(file);
	System.out.println(g);
	Scanner sc = new Scanner(System.in);
	while (input != "stop"){
	    input = sc.next();
	    g.play(input);
	}
	System.out.println("You Lost...");
    }

	    

	    
	    
    
}

		
	    
	
