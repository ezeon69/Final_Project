String[] lines;
String [][] board;
String s;
void setup() {
  size(300,300);

   lines = loadStrings("Boards/Board1.txt");
   board = new String [lines.length/2][lines.length/2];
   
   for (int r = 0; r < board.length/2 -1; r ++){
     String[] eachLine = split(lines[r]," ");
      for (int c = 0; c <  board.length/2 -1; c ++){
         board[r][c] = eachLine[c];
         print(eachLine[c]);
      }
      print("\n");
   }
   
  


 
}

void draw(){
  
}