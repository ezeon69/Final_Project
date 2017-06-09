class Rogue {

  Site location;
  int hp;

  Rogue(int x, int y) {
    location = new Site(x, y);
    hp = 10;
  }

  void hurt(int hp) {
    this.hp-=hp;
  }

  boolean isAlive() {
    return hp > 0;
  }

  void move(int x, int y) {
    location = new Site(x, y);
  }

  Site getLocation() {
    return location;
  }
}
