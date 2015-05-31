package data.data1;

public class AnimalTest {

    public static void main(String[] args) {

        Animal a = new  Animal();

        Cat cat = new Cat("Cat");
        cat.getBirth();
        cat.finalize();
        a.finalize();
        cat.introduce();
        System.out.println();

        Cow cow = new Cow("Cow");
        cow.getBirth();
        cow.introduce();
        System.out.println();

        Dog dog = new Dog("Dog");
        dog.finalize();
        a.finalize();
        dog.introduce();
        System.out.println();

        System.out.println("+ Sum Animal = " + a.getPopulation());
    }
}