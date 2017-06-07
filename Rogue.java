public class Rogue {

    Site location;
    int hp;

    public Rogue(int x,int y){
	location = new Site(x,y);
	hp = 10;
    }

    public void hurt(int hp){
	this.hp-=hp;
    }

    public boolean isAlive(){
	return hp > 0;
    }

    public void move(int x,int y){
	location = new Site(x,y);
    }

    public Site getLocation(){
	return location;
    }
    
    

}