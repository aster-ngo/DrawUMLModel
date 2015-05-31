package data.data1;

public class Cat extends Animal{

    private static int population = 0;

    Cat(String name){
        super(name);
        population++;
       
    }

    @Override
    public Cat getBirth()
    {
        return new Cat(name  + "'s baby");
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
        System.out.println("\t+ A Sound of Cat: meo meo");
        System.out.println("\t+ Popuplation = " + population);
    }
}
