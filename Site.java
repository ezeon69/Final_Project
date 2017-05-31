public class Site{

    public Site s;
    private int row;
    private int col;

    public Site(int r,int c){
	row = r;
	col = c;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public boolean equals(Site Other){
	return (s.getRow() == Other.getRow()) && (s.getCol() == Other.getCol());
    }
    
    

}
