public class Site{

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
	return (this.getRow() == Other.getRow()) && (this.getCol() == Other.getCol());
    }

    //manhattan distance between site and other site
    public int distanceTo(Site Other){
        return Math.abs(this.getRow() - Other.getRow()) + Math.abs(this.getCol() - Other.getCol());
    }

}
