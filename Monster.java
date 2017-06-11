public class Monster{

    private Game g;
    private Dungeon d;
    private int size;
    //Site location;
    //int hp, attack;

    //constructor
    public Monster(Game game){
        g = game;
	d = g.getDungeon();
	size = d.size();
	// set hp and attack based on type of monster
    }

    public Site move(Site rogue){
	int r = g.getMonsterSite().getRow();
	int c = g.getMonsterSite().getRow();
	/*
	distances.add(Site(r+1,c).distanceTo(rogue));
	distances.add(Site(r-1,c).distanceTo(rogue));
	distances.add(Site(r,c+1).distanceTo(rogue));
	distances.add(Site(r,c-1).distanceTo(rogue));
	*/
	Site current = new Site(r+1,c);

	if (current.distanceTo(rogue) > new Site(r-1,c).distanceTo(rogue)) current = new Site(r-1,c);
	if (current.distanceTo(rogue) > new Site(r,c+1).distanceTo(rogue)) current = new Site(r,c+1);
	if (current.distanceTo(rogue) > new Site(r,c-1).distanceTo(rogue)) current = new Site(r,c-1);

        return current;
    }

    /*public void setLocation(Site location){
	this.location = location;
    }

    public Site getLocation(){
	return location;
	}*/
    

}
