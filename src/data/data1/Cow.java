package data.data1;

public class Cow extends Animal {

    private static int population = 0;

    Cow(String name)
    {
        super(name);
        population ++;
    }

    @Override
    public Cow getBirth()
    {
        return new Cow(name + "'s baby");
    }

    @Override
    protected void finalize()
    {
        System.out.println("\t+ " + name + " is die.");
        population--;
    }

    @Override
    public void makeASound()
    {
        System.out.println("\t+ A Sound of Cow : be be");
        System.out.println("\t+ Popuplation = " + population);
    }
}