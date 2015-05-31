package data.data1;

public class Animal {

    protected String name;
    private static int population = 0;

    Animal(){}

    Animal(String name){
        this.name = name;
        System.out.println("+ " + name + " duoc sinh ra" );
        population++;
    }

    public static int getPopulation() {
        return population;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void makeASound()
    {
        return;
    }

    public Animal getBirth()
    {
        return this;
    }

    @Override
    protected void finalize()
    {
        population--;
    }

    public void introduce()
    {
        System.out.println("\t+ Name animal : " + name );
        makeASound();
    }
}
