package main;

public class Hero {

    private String name;

    public Hero(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    
    @Override
    public String toString() 
    {
        return name;
    }

}