import java.util.*;
import java.io.*;
class Game {

  private Dungeon d;
  private int size;
  //private Site mSite;                                                                                                                                                                                          
  //private Site rSite;                                                                                                                                                                                          
  private Monster m;
  private Rogue r;


  public Game(String filename) throws FileNotFoundException {

    //read in file                                                                                                                                                                                             
    File f = new File(filename);
    Scanner in = new Scanner(f);

    //get size of dungeon                                                                                                                                                                                      
    Scanner firstLine = new Scanner (in.nextLine());
    size = Integer.parseInt(firstLine.next());
    char[][] board = new char[size][size];


    for (int row = 0; in.hasNextLine(); row ++) {
      String line = in.nextLine();
      for (int c = 0; c < size; c ++) {
        board[row][c] = line.charAt(c);
        if (board[row][c] == 'A') {
          m = new Monster(row, c);
          //mSite = new Site(r,c);
        }

        if (board[row][c] == '@') {
          r = new Rogue(row, c);
          //rSite = new Site(r,c);
        }
      }
    }


    d = new Dungeon(board);
  }
  
  Dungeon getDungeon(){
     return d; 
  }
}
