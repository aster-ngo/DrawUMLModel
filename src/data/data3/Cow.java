package data.data3;


public class Cow extends Animal{
	private static int population = 0;
	Cow(String name) {
		this.name = name;
		System.out.println(" + Cow Constructor");
		population++;
	}
	public void makeASound() {
		System.out.print(" + Cow cow");
	}
	public int getPopulation() {
		return population;
	}
	public int getTotalPopulation() {
		return super.getPopulation();
	}
	public Cow giveBirth() {
		return new Cow(name + "'s Baby");
	}
	public void finalize() {
		population--;
		super.setPopulation(super.getPopulation()-1);
		System.out.println(" + " + name + " DIED.");
		this.name = "DIED";
	}
}
