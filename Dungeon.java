public class Dungeon{
    
    private char[][] board;
    
    public Dungeon(File filename){	
	
	
    }

    public int size(){
	return size;
    }
    
    public boolean isLegalMove(Site a, Site b){
	if ((a.getRow() + 1 == b.getRow()) && (a.getCol() == b.getCol())){
	    return true;
	}
	else if ((a.getRow() - 1 == b.getRow()) && (a.getCol() == b.getCol())){
	    return true;
	}
	else if ((a.getRow() == b.getRow()) && (a.getCol() + 1 == b.getCol())){
	    return true;
	}
	else if ((a.getRow() == b.getRow()) && (a.getCol() - 1 == b.getCol())){
	    return true;
	}
	else{
	    return false;
	}
    }
    
    public boolean isCorridor(Site s){
        
    }

    public boolean isRoom(Site s){
	
    }
    
    
}
