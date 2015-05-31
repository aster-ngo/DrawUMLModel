package data.data3;


public class Cat extends Animal{
	private static int population = 0;
	Cat(String name) {
		this.name = name;
		System.out.println(" + Cat Constructor");
		population++;
	}
	public void makeASound() {
		System.out.print(" + Meo meo");
	}
	
	public int getPopulation() {
		return population;
	}
	public int getTotalPopulation() {
		return super.getPopulation();
	}
	public Cat giveBirth() {
		return new Cat(name + "'s Baby");
	}
	public void finalize() {
		population--;
		super.setPopulation(super.getPopulation()-1);
		System.out.println(" + " + name + " DIED.");
		this.name = "DIED";
	}
}
