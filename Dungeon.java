public class Dungeon{

    private int size;
    private char[][] board;
    
    public Dungeon(char[][]b){	
	size = b[0].length;
	board = b;
    }

    public int size(){
	return size;
    }
    
    public boolean isLegalMove(Site a, Site b){
	//check in bounds
        if (a.getRow() < 0 ||
	    a.getCol() < 0 ||
	    a.getRow() > size() ||
	    a.getCol() > size()){
	    return false;
	}
	if (b.getRow() < 0 ||
	    b.getCol() < 0 ||
	    b.getRow() > size() ||
	    b.getCol() > size()){
	    return false;
	}
	//check if is corridor or room
	if (!isCorridor(b) || !isRoom(b)){
	    return false;
	}
	//check within one square
        if ((a.getRow() + 1 == b.getRow()) && (a.getCol() == b.getCol())){
	    return true;
	}
	if ((a.getRow() - 1 == b.getRow()) && (a.getCol() == b.getCol())){
	    return true;
	}
	if ((a.getRow() == b.getRow()) && (a.getCol() + 1 == b.getCol())){
	    return true;
	}
	if ((a.getRow() == b.getRow()) && (a.getCol() - 1 == b.getCol())){
	    return true;
	}
	else{
	    return false;
	}	
    }
    
    public boolean isCorridor(Site s){
        return board[s.getRow()][s.getCol()] == '+';
    }

    public boolean isRoom(Site s){
	return board[s.getRow()][s.getCol()] == '.';
    }

    public boolean isWall(Site s){
	return board[s.getRow()][s.getCol()] == ' ';
    }
}
