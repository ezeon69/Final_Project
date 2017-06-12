import java.util.Comparator;
import java.util.PriorityQueue;
class Dungeon {

  int size;
  char [][] board;
  Monster mon;
  Rogue rog;


  Dungeon(char[][]board) {
    size = board.length;
    for (int r = 0; r < size; r ++) {
      for (int c = 0; c < size; c ++) {
        if (board[r][c] == '@') rog = new Rogue(r, c);
        else if (board[r][c] == 'A') mon = new Monster(r, c);
        this.board[r][c] = board[r][c];
      }
    }
  }

  Dungeon(String[] board) {
    size = board.length;
    this.board = new char[size][size];
    for (int r = 0; r < size; r ++) {
      for (int c = 0; c < size; c ++) {
        if (board[r].charAt(c) == '@') rog = new Rogue(r, c);
        else if (board[r].charAt(c)  == 'A') mon = new Monster(r, c);
        this.board[r][c] = board[r].charAt(c);
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
      b.getRow() > size() ||
      b.getCol() > size()) {
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

  char getSpot(int r, int c) {
    return board[r][c];
  }

  char[][] getBoard() {
    return board;
  }


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
      char placeHolder = board[x][y];
      board[x][y] = board[next.getRow()][next.getCol()];
      board[next.getRow()][next.getCol()] = placeHolder;
      rog.move(next);
    }
  }

  boolean death() {
    return rog.getLocation().equals(mon.getLocation());
  }


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

    char placeHolder = board[r][c];
    board[r][c] = board[current.getRow()][current.getCol()];
    board[current.getRow()][current.getCol()] = placeHolder;
    mon.move(current);
  }
}  


/*
  void moveMon() {
 int r = mon.getLocation().getRow();
 int c = mon.getLocation().getCol();
 
 Site current = new Site(r+1, c);
 
 if (current.distanceTo(rog.getLocation()) > new Site(r-1, c).distanceTo(rog.getLocation()) && isLegalMove(new Site(r-1, c))) current = new Site(r-1, c);
 if (current.distanceTo(rog.getLocation()) > new Site(r, c+1).distanceTo(rog.getLocation()) && isLegalMove(new Site(r, c+1))) current = new Site(r, c+1);
 if (current.distanceTo(rog.getLocation()) > new Site(r, c-1).distanceTo(rog.getLocation()) && isLegalMove(new Site(r, c-1))) current = new Site(r, c-1);
 
 System.out.println( new Site(r, c-1).distanceTo(rog.getLocation()));
 
 if (isLegalMove( current)) {
 char placeHolder = board[r][c];
 board[r][c] = board[current.getRow()][current.getCol()];
 board[current.getRow()][current.getCol()] = placeHolder;
 
 mon.move(current);
 }
 }
 */