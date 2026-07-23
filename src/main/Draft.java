package main;

import java.util.ArrayList;

public class Draft {

    private ArrayList<IHero> blueTeam;
    private ArrayList<IHero> redTeam;

    public Draft() 
    {
        blueTeam = new ArrayList<>();
        redTeam = new ArrayList<>();
    }

    public void addBlueHero(IHero hero) 
    {
        blueTeam.add(hero);
    }

    public void addRedHero(IHero hero) 
    {
        redTeam.add(hero);
    }

    public void displayTeams() 
    {

        System.out.println("\nBlue Team");

        for (IHero hero : blueTeam) 
        {
            System.out.println("- " + hero);
        }

        System.out.println("\nRed Team");

        for (IHero hero : redTeam) 
        {
            System.out.println("- " + hero);
        }
    }
    
    public boolean heroAlreadyPicked(IHero hero) 
    {
        return blueTeam.contains(hero) || redTeam.contains(hero);
    }
    
    public boolean draftComplete() 
    {
        return blueTeam.size() == 6 && redTeam.size() == 6;
    }
}
