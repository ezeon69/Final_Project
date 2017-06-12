class Monster {
  Site location;


  Monster(int x, int y) {
    location = new Site(x, y);
    // set hp and attack based on type of monster
  }

  void move(Site next) {
    location = next;
  }


  Site getLocation() {
    return location;
  }
}
