class Monster {
  Site location;


  public Monster(int x, int y) {
    location = new Site(x, y);
    // set hp and attack based on type of monster
  }

  public void move(Site rogue) {
    int r = location.getRow();
    int c = location.getCol();
    /*                                                                                                                                                                                                         
     distances.add(Site(r+1,c).distanceTo(rogue));                                                                                                                                                              
     distances.add(Site(r-1,c).distanceTo(rogue));                                                                                                                                                              
     distances.add(Site(r,c+1).distanceTo(rogue));                                                                                                                                                              
     distances.add(Site(r,c-1).distanceTo(rogue));                                                                                                                                                              
     */
    Site current = new Site(r+1, c);

    if (current.distanceTo(rogue) > new Site(r-1, c).distanceTo(rogue)) current = new Site(r-1, c);
    if (current.distanceTo(rogue) > new Site(r, c+1).distanceTo(rogue)) current = new Site(r, c+1);
    if (current.distanceTo(rogue) > new Site(r, c-1).distanceTo(rogue)) current = new Site(r, c-1);

    setLocation(current);
  }

  public void setLocation(Site location) {
    this.location = location;
  }

  public Site getLocation() {
    return location;
  }
}
