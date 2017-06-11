public class Rogue {

    private Game g;
    private Dungeon d;
    private int size;
    //Site location;
    //int hp;

    public Rogue(Game game){
	g = game;
	d = game.getDungeon();
	size = d.size();
    }

    public Site move(){
	Site monster = g.getMonsterSite();
	Site rogue = g.getRogueSite();
	Site move = null;
	
	if (Math.random() > .5){
	    move = new Site(rogue.getRow() + (int)(Math.random() * 2), rogue.getCol());
	}
	else{
	    move = new Site(rogue.getRow(), rogue.getCol() + (int)(Math.random() * 2));
	}
        
	/*if (command == "up"){
	    move = new Site(rogue.getRow(), rogue.getCol() - 1);
	}
	else if (command == "right"){
	    move = new Site(rogue.getRow() + 1, rogue.getCol());
	}
	else if (command == "left"){
	    move = new Site(rogue.getRow() - 1, rogue.getCol() - 1);
	}
	else{
	    move = new Site(rogue.getRow(), rogue.getCol() + 1);
	    }*/
	return move;
    }


	
    /*public void hurt(int hp){
	this.hp-=hp;
    }

    public boolean isAlive(){
	return hp > 0;
	}

    public Site getLocation(){
	return location;
	}*/    

}
