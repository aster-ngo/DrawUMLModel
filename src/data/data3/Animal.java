package data.data3;


public abstract class Animal {
	protected String name;
	private static int population = 0;
	public abstract void makeASound();
	public void introduce() {
		if(name != "DIED") {
			makeASound();
			System.out.println(", My name is " + name);
		}
	};
	Animal() {
		System.out.println(" + Animal Constructor");
		population++;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int x){
		population = x;
	}
	public abstract Animal giveBirth();
	public abstract void finalize();
}
