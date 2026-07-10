package main;

import java.util.ArrayList;
import java.util.Scanner;

public class Main 
{

    public static void main(String[] args) 
    {

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
                	
                    ArrayList<Hero> heroes = HeroDatabase.getHeroes();
                    
                	while (!draft.draftComplete()) 
                	{
                    	System.out.println("\nSelect a hero for Blue Team");

                    	for (int i = 0; i < heroes.size(); i++) 
                    	{
                        	System.out.println((i + 1) + ". " + heroes.get(i));
                    	}

                    	int blue = scanner.nextInt();
                    
                    	Hero blueHero = heroes.get(blue - 1);
                    
                    	if (!draft.heroAlreadyPicked(blueHero)) 
                    	{
                        	draft.addBlueHero(blueHero);
                        	heroes.remove(blueHero);
                    	}
                    
                    	System.out.println("\nSelect a hero for Red Team");

                    	for (int i = 0; i < heroes.size(); i++) 
                    	{
                        	System.out.println((i + 1) + ". " + heroes.get(i));
                    	}

                    	int red = scanner.nextInt();

                    	Hero redHero = heroes.get(red - 1);
                    
                    	if (!draft.heroAlreadyPicked(redHero)) 
                    	{
                        	draft.addRedHero(redHero);
                        	heroes.remove(redHero);
                    	}

                    	draft.displayTeams();
            		}

                    break;

                case 2:
                	ArrayList<Hero> HeroList = HeroDatabase.getHeroes();
                    for (Hero hero : HeroList) 
                    {
                        System.out.println(hero);
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