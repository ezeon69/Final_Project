class Dungeon {

  int size;
  char [][] board;

  Dungeon(char[][]board) {
    size = board.length;
    for (int r = 0; r < size; r ++) {
      for (int c = 0; c < size; c ++) {
        this.board[r][c] = board[r][c];
      }
    }
  }

  int size() {
    return size;
  }

  boolean isLegalMove(Site a, Site b) {
    //check in bounds                                                                                                                                                                                          
    if (a.getRow() < 0 ||
      a.getCol() < 0 ||
      a.getRow() > size() ||
      a.getCol() > size()) {
      return false;
    }
    if (b.getRow() < 0 ||
      b.getCol() < 0 ||
      b.getRow() > size() ||
      b.getCol() > size()) {
      return false;
    }
    //check within one square                                                                                                                                                                                  
    if ((a.getRow() + 1 == b.getRow()) && (a.getCol() == b.getCol())) {
      return true;
    }
    if ((a.getRow() - 1 == b.getRow()) && (a.getCol() == b.getCol())) {
      return true;
    }
    if ((a.getRow() == b.getRow()) && (a.getCol() + 1 == b.getCol())) {
      return true;
    }
    if ((a.getRow() == b.getRow()) && (a.getCol() - 1 == b.getCol())) {
      return true;
    } else {
      return false;
    }
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
  
  char[][] getBoard(){
     return board; 
  }
}
