public class Dungeon{

    private int size;
    
    public Dungeon(char[][]board){	
	size = board.length;
	
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
        return board[s.getRow()][s.getCol] == '+';
    }

    public boolean isRoom(Site s){
	return board[s.getRow()][s.getCol] == '.';
    }
    
}
