class Site {

  int row,col;
  double dist;

  Site(int r, int c) {
    row = r;
    col = c;
  }
  
  Site(int r,int c, Site rogue){
    row = r;
    col = c;
    dist = distanceTo(rogue);
  }
  
  int getRow() {
    return row;
  }

  int getCol() {
    return col;
  }
  
  int getDist(){
     return (int)dist; 
  }

  boolean equals(Site Other) {
    return (getRow() == Other.getRow()) && (getCol() == Other.getCol());
  }

  //manhattan distance between site and other site                                                                                                                                                               
  double distanceTo(Site Other) {
    return Math.abs(row - Other.getRow()) + Math.abs(col - Other.getCol());
  }
  
  

  
    
  

}