package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{

    public static void main(String[] args) 
    {
    	HeroDatabase database = HeroDatabase.getInstance();
    	ArrayList<IHeroCreator> heroes = new ArrayList<>(database.getHeroFactories());

        Scanner scanner = new Scanner(System.in);


        while (true) 
        {

            System.out.println("\n===== DEADLOCK DRAFT ANALYZER =====");
            System.out.println("1. Start Draft");
            System.out.println("2. View Hero List");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();

            switch (choice) 
            {

                case 1:
                	Draft draft = new Draft();               	
                	
                	while (!draft.draftComplete()) 
                	{
                    	System.out.println("\nSelect a hero for Blue Team");

                    	for (int i = 0; i < heroes.size(); i++) {

                    	    IHero hero = heroes.get(i).createHero();

                    	    System.out.println((i + 1) + ". " + hero.getName());

                    	}

                    	int blue = scanner.nextInt();
                    
                    	IHero blueHero = heroes.get(blue - 1).createHero();
                    
                    	if (!draft.heroAlreadyPicked(blueHero)) 
                    	{
                        	draft.addBlueHero(blueHero);
                        	heroes.remove(blue - 1);
                    	}
                    
                    	System.out.println("\nSelect a hero for Red Team");

                    	for (int i = 0; i < heroes.size(); i++) 
                    	{
                        	System.out.println((i + 1) + ". " + heroes.get(i));
                    	}

                    	int red = scanner.nextInt();

                    	IHero redHero = heroes.get(red - 1).createHero();
                    
                    	if (!draft.heroAlreadyPicked(redHero)) 
                    	{
                        	draft.addRedHero(redHero);
                        	heroes.remove(red - 1);
                    	}

                    	draft.displayTeams();
            		}

                    break;

                case 2:
                	for (int i = 0; i < heroes.size(); i++) {

                	    IHero hero = heroes.get(i).createHero();

                	    System.out.println((i + 1) + ". " + hero.getName());

                	}
                    break;

                case 3:

                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
            }
        }
    }
}