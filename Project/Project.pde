String [] lines;
char[][] gameBoard;
int x, y, size;
Dungeon dun;
boolean setTrap = false;
boolean justSetTrap = false;
boolean enterPressed = false;
ArrayList<Site> activeT = new ArrayList<Site>();

void setup() {
  size(400, 400);
  background(0);
  textSize(32);
  text("Press Enter", 110, 100);
  text("To Start", 130, 150);

  textSize(14);
  //Rogue
  fill(color(255, 255, 0));
  rect(145, 180, 15, 15);
  text(" = Rogue", 165, 192); 
  //Monster
  fill(color(255, 0, 0));
  rect(145, 205, 15, 15);
  text(" = Monster", 165, 215); 
  //Trap
  fill(color(255, 100, 200));
  rect(145, 230, 15, 15);
  text(" = Trap", 165, 240); 
  //ActiveTrap
  fill(color(0, 255, 255));
  rect(145, 255, 15, 15);
  text(" = Active Trap", 165, 265); 

  fill(color(255, 255, 255));
  text("Use T to Set Traps", 140, 300); 


  x = y = 0;
  lines = loadStrings("Board1.txt");
  printArray(lines);
  dun = new Dungeon(lines);
}


void draw() {

  if (keyPressed) {
    if (key == ENTER) {
      enterPressed = true;
      background(0);
    }
  }

  if (enterPressed) {
    activeT = dun.getActiveTraps();
    gameBoard = dun.getBoard();

    if (!justSetTrap && !activeT.isEmpty()) {
      for (Site current : activeT) {
        gameBoard[current.getRow()][current.getCol()] = '*';
      }
    }

    for (int r = 0; r < gameBoard.length; r ++) {
      for (int c = 0; c < gameBoard.length; c ++) {
        if (gameBoard[r][c] == '+') fill(color(255, 255, 255));
        else if (gameBoard[r][c] == '.') fill(color(0, 0, 255));
        else if (gameBoard[r][c] == '@') fill(color(255, 255, 0));
        else if (gameBoard[r][c] == 'A') fill(color(255, 0, 0));
        else if (gameBoard[r][c] == '^') fill(color(255, 100, 200));
        else if (gameBoard[r][c] == '*') fill(color(0, 255, 255));
        else fill(color(0, 0, 0));
        noStroke();
        rect(x, y, 15, 15);
        x+=15;
      }
      y+=15;
      x=0;
    }
    x = y = 0;

    if (dun.death()) exit();
    if (dun.onTrap()) dun.giveTrap();
    if (dun.monOnTrap()) {
      //dun.removeActiveTrap();
      dun.removeMon();
    }
    if (keyPressed) {
      if (key == 't' || key == 'T') {

        if (dun.hasTraps()) {
          setTrap = true;
          dun.placeTrap();
          justSetTrap = true;
        }
      }
    }
  }
}

void keyPressed() {



  if (key == CODED) {

    switch(keyCode) {
    case DOWN:
      dun.moveRogue("DOWN");
      break;
    case UP:
      dun.moveRogue("UP");
      break;
    case RIGHT:
      dun.moveRogue("RIGHT");
      break;
    case LEFT:
      dun.moveRogue("LEFT");
      break;
    }

    justSetTrap = false;

    if (dun.death()) exit();
    dun.moveMon();
  }
}
