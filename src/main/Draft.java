package main;

import java.util.ArrayList;

public class Draft {

    private ArrayList<Hero> blueTeam;
    private ArrayList<Hero> redTeam;

    public Draft() 
    {
        blueTeam = new ArrayList<>();
        redTeam = new ArrayList<>();
    }

    public void addBlueHero(Hero hero) 
    {
        blueTeam.add(hero);
    }

    public void addRedHero(Hero hero) 
    {
        redTeam.add(hero);
    }

    public void displayTeams() 
    {

        System.out.println("\nBlue Team");

        for (Hero hero : blueTeam) 
        {
            System.out.println("- " + hero);
        }

        System.out.println("\nRed Team");

        for (Hero hero : redTeam) 
        {
            System.out.println("- " + hero);
        }
    }
    
    public boolean heroAlreadyPicked(Hero hero) 
    {
        return blueTeam.contains(hero) || redTeam.contains(hero);
    }
    
    public boolean draftComplete() 
    {
        return blueTeam.size() == 6 && redTeam.size() == 6;
    }
}
