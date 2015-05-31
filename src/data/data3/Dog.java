package data.data3;


public class Dog extends Animal {
	private static int population = 0;
	Dog(String name) {
		this.name = name;
		System.out.println(" + Dog Constructor");
		population++;
	}
	public void makeASound() {
		System.out.print(" + Gau Gau");
	}
	public int getPopulation() {
		return population;
	}
	public int getTotalPopulation() {
		return super.getPopulation();
	}
	public Dog giveBirth() {
		return new Dog(name + "'s Baby");
	}
	public void finalize() {
		population--;
		super.setPopulation(super.getPopulation()-1);
		System.out.println(" + " + name + " DIED.");
		this.name = "DIED";
	}
}
