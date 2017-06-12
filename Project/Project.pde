String [] lines;
char[][] gameBoard;
int x, y, size;
Dungeon dun;

void setup() {
  size(400, 400);
  background(0);
  noStroke();
  x = y = 0;
  lines = loadStrings("/Users/Alex/Documents/Final_Project/Project/Board1.txt");
  printArray(lines);
  dun = new Dungeon(lines);

}


void draw() {

  gameBoard = dun.getBoard();

  for (int r = 0; r < gameBoard.length; r ++) {
    for (int c = 0; c < gameBoard.length; c ++) {
      if (gameBoard[r][c] == '+') fill(color(255, 255, 255));
      else if (gameBoard[r][c] == '.') fill(color(0, 0, 255));
      else if (gameBoard[r][c] == '@') fill(color(255,255,0));
      else if (gameBoard[r][c] == 'A') fill(color(255,0,0));
      else if (gameBoard[r][c] == '^') fill(color(255,100,200));
      else fill(color(0, 0, 0));
      noStroke();
      rect(x, y, 20, 20);
      x+=20;
    }
    y+=20;
    x=0;
  }
  x = y = 0;
  
  if (dun.death()) background(0);
  
  
  
}

void keyPressed() {

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
  
  dun.moveMon();
}