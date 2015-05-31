package data.data1;

public class Dog extends Animal{

    private static int population = 0;

    Dog(String name)
    {
        super(name);
        population++;
    }

    @Override
    public Dog getBirth()
    {
        return new Dog(name + "'s baby");
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
        System.out.println("\t+ A Sound of Dog: Go Go");
        System.out.println("\t+ Popuplation = " + population);
    }
}
