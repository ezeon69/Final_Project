class Rogue {

  int x,y,traps;
  Site location;

  Rogue(int x, int y) {
    location = new Site(x, y);
    this.x = x;
    this.y = y;
    traps = 0;
  }


  void move(Site next) {
    location = next;
  }
  /*
  void move(String dir){
    Site next;
   if (dir == "UP") next = new Site(x-1,y);
   else if (dir == "DOWN") next = new Site(x+1,y);
   else if (dir == "RIGHT") next = new Site(x,y+1);
   else if (dir == "LEFT") next = new Site(x,y-1);
   else return;
   if (location.isLegalMove(next)) location = next;
   else System.out.println("IllegalMove");

  }
  */
  Site getLocation() {
    return location;
  }
  
  boolean hasTrap(){
     return traps > 0; 
  }
  
  void addTraps(int num){
    traps+=num;
  }
  
  void addTrap(){  
     traps++; 
  }
  
  void removeTrap(){
     traps--; 
  }
}