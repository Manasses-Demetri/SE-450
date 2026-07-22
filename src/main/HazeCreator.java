package main;

public class HazeCreator implements IHeroCreator{
	 @Override
	    public IHero createHero() 
	 {
	        return new Haze();
	    }
}
