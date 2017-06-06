public class Monster{

    Site location;
    //int hp, attack;


    public Monster(int x, int y){
	location = new Site(x,y);
	// set hp and attack based on type of monster
    }

    public void move(Site rogue){
	int r = location.getR();
	int c = location.getC();
	/*
	distances.add(Site(r+1,c).distanceTo(rogue));
	distances.add(Site(r-1,c).distanceTo(rogue));
	distances.add(Site(r,c+1).distanceTo(rogue));
	distances.add(Site(r,c-1).distanceTo(rogue));
	*/
	Site current = Site(r+1,c);

	if (current.distanceTo(rogue) > Site(r-1,c).distanceTo(rogue)) current = Site(r-1,c);
	if (current.distanceTo(rogue) > Site(r,c+1).distanceTo(rogue)) current = Site(r,c+1);
	if (current.distanceTo(rogue) > Site(r,c-1).distanceTo(rogue)) current = Site(r,c-1);

	setLocation(current);
    }

    public void setLocation(Site location){
	this.location = location;
    }

    public Site getMonsterLocation(){
	return location;
    }

    

}