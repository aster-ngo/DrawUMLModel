package data.data2;

public class VirtualPerson {
	private int tooCold = 65;
	private int tooHot = 85;
	public void drinkCoffee(CoffeeCup cup) throws TooColdException, TooHotException {
		if(cup.getTemperature() >= tooHot) throw new TooHotException(" Too Hot");
		else
		if(cup.getTemperature() <= tooCold) throw new TooColdException(" Too Cold");
		else 
		System.out.println(" + This temperature: " + cup.getTemperature() + ", you can drink it now :)");
	}
}
