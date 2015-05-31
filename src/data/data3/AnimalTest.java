package data.data3;


public class AnimalTest {
	public Cat cat;
	public Dog dog;
	public static void main(String[] args) {
		Cat[] cats = new Cat[6];
		Dog[] dogs = new Dog[6];
		Cow[] cows = new Cow[6];
		for(int i=0; i<3; i++) cats[i] = new Cat(" Cat " + i);
		for(int i=0; i<3; i++) dogs[i] = new Dog(" Dog " + i);
		for(int i=0; i<3; i++) cows[i] = new Cow(" Cow " + i);
		for(int i=3; i<6; i++) cats[i] = cats[i-3].giveBirth();
		for(int i=3; i<6; i++) dogs[i] = dogs[i-3].giveBirth();
		for(int i=3; i<6; i++) cows[i] = cows[i-3].giveBirth();
		
		for(int i=0; i<6; i++) {
			cats[i].introduce();
			dogs[i].introduce();
			cows[i].introduce();
		}

		System.out.println(" + Cat's population: " + cats[0].getPopulation());
		System.out.println(" + Dog's population: " + dogs[0].getPopulation());
		System.out.println(" + Cow's population: " + cows[0].getPopulation());
		System.out.println(" + Total population: " + cats[0].getTotalPopulation());
		
		cats[0].finalize();
		dogs[0].finalize();
		cows[0].finalize();
		
		
		for(int i=0; i<6; i++) {
			cats[i].introduce();
			dogs[i].introduce();
			cows[i].introduce();
		}
		
		System.out.println(" + Cat's population: " + cats[0].getPopulation());
		System.out.println(" + Dog's population: " + dogs[0].getPopulation());
		System.out.println(" + Cow's population: " + cows[0].getPopulation());
		
		System.out.println(" + Total population: " + cats[0].getTotalPopulation());
		
		
	}
}
