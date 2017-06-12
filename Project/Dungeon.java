import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.*;
class Dungeon {

  int size;
  char [][] board;
  char[][] original;
  Monster mon;
  Rogue rog;
  ArrayList<Site> trp = new ArrayList<Site>();
  ArrayList<Site> activeTrp = new ArrayList<Site>();


  Dungeon(String[] Board) {
    size = Board.length;
    board = new char[size][size];
    original = new char[size][size];

    for (int r = 0; r < size; r ++) {
      for (int c = 0; c < size; c ++) {
        if (Board[r].charAt(c) == '@') rog = new Rogue(r, c);
        else if (Board[r].charAt(c)  == 'A') mon = new Monster(r, c);
        else if (Board[r].charAt(c)  == '^') trp.add(new Site(r, c));
        board[r][c] = Board[r].charAt(c);

        //fill in original
        if (Board[r].charAt(c) == '@' || Board[r].charAt(c)  == 'A' || Board[r].charAt(c) == '^') original[r][c] = '.';
        else original[r][c] = Board[r].charAt(c);
      }
    }
  }


  int size() {
    return size;
  }

  boolean isLegalMove( Site b) {
    //check in bounds                                                                                                                                                                                          
    if (b.getRow() < 0 ||
      b.getCol() < 0 ||
      b.getRow() >= size() ||
      b.getCol() >= size()) {
      return false;
    }
    if (board[b.getRow()][b.getCol()] == '#') return false;
    return true;
  }

  boolean isCorridor(Site s) {
    return board[s.getRow()][s.getCol()] == '+';
  }

  boolean isRoom(Site s) {
    return board[s.getRow()][s.getCol()] == '.';
  }

  char[][] getBoard() {
    return board;
  }

  //RogueMove===========================================================================
  void moveRogue(String dir) {
    Site next;
    int x = rog.getLocation().getRow();
    int y = rog.getLocation().getCol();
    if (dir == "UP") next = new Site(x-1, y);
    else if (dir == "DOWN") next = new Site(x+1, y);
    else if (dir == "RIGHT") next = new Site(x, y+1);
    else if (dir == "LEFT") next = new Site(x, y-1);
    else return;
    if (isLegalMove( next)) {
      //char placeHolder = board[x][y];
      // board[x][y] = board[next.getRow()][next.getCol()];
      // board[next.getRow()][next.getCol()] = placeHolder;
      board[next.getRow()][next.getCol()] = '@';
      board[x][y] = original[x][y];
      rog.move(next);
    }
  }

  //MonsterMove===========================================================================
  void moveMon() {
    Comparator<Site> comparator = new distComparator(); 
    PriorityQueue<Site> possibleMoves = new PriorityQueue<Site>(comparator);

    int r = mon.getLocation().getRow();
    int c = mon.getLocation().getCol();
    Site rogLoc = rog.getLocation();

    possibleMoves.add(new Site(r+1, c, rogLoc));
    possibleMoves.add(new Site(r-1, c, rogLoc));
    possibleMoves.add(new Site(r, c+1, rogLoc));
    possibleMoves.add(new Site(r, c-1, rogLoc));

    while (!isLegalMove(possibleMoves.peek())) possibleMoves.poll();

    Site current = possibleMoves.poll();

    board[current.getRow()][current.getCol()] = 'A';
    board[r][c] = original[r][c];
    mon.move(current);
  }

  //Death==============================================================================
  boolean death() {
    return rog.getLocation().equals(mon.getLocation());
  }

  //Traps==============================================================================


  boolean onTrap() {
    for (Site current : trp) {
      if (current.equals(rog.getLocation())) {
        trp.remove(current);
        return true;
      }
    }
    return false;
  }

  void giveTrap() {
    rog.addTrap();
  }

  boolean hasTraps() {
    return rog.hasTrap();
  }

  void placeTrap() {
    activeTrp.add(new Site(rog.getLocation().getRow(), rog.getLocation().getCol()));
    rog.removeTrap();
  }

  ArrayList getActiveTraps() {
    return activeTrp;
  }

  void removeActiveTrap() {
    activeTrp.remove(mon.getLocation());
    board[mon.getLocation().getRow()][mon.getLocation().getCol()] = original[mon.getLocation().getRow()][mon.getLocation().getCol()];
  }

  //=========================================================================================

  boolean monOnTrap() {
    for (Site current : activeTrp) {
      if (current.equals(mon.getLocation())) {
        activeTrp.remove(current);
        board[current.getRow()][current.getCol()] = original[current.getRow()][current.getCol()];
        return true;
      }
    }
    return false;
  }

  void removeMon() {
    boolean notSetLoc = true;

    board[mon.getLocation().getRow()][mon.getLocation().getCol()] = original[mon.getLocation().getRow()][mon.getLocation().getCol()];

    while (notSetLoc) {
      Random random = new Random();
      int row = random.nextInt(size);
      int col = random.nextInt(size);
      Site New = new Site(row, col);
      if (isLegalMove(New) && isRoom(New) && New.distanceTo(rog.getLocation()) > 5) {
        mon = new Monster(row, col);
        notSetLoc = false;
      }
    }
  }
}  