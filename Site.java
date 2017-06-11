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

    public boolean equals(Site Other){
	return (this.getRow() == Other.getRow()) && (this.getCol() == Other.getCol());
    }

    //manhattan distance between site and other site
    public int distanceTo(Site Other){
        return Math.abs(this.getRow() - Other.getRow()) + Math.abs(this.getCol() - Other.getCol());
    }

  //manhattan distance between site and other site                                                                                                                                                               
  int distanceTo(Site Other) {
    return Math.abs(row - Other.getRow()) + Math.abs(col - Other.getCol());
  }
}
