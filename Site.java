class Site {

  int row;
  int col;

  Site(int r, int c) {
    row = r;
    col = c;
  }

  int getRow() {
    return row;
  }

  int getCol() {
    return col;
  }

  boolean equals(Site Other) {
    return (getRow() == Other.getRow()) && (getCol() == Other.getCol());
  }

  //manhattan distance between site and other site                                                                                                                                                               
  int distanceTo(Site Other) {
    return Math.abs(row - Other.getRow()) + Math.abs(col - Other.getCol());
  }
}
