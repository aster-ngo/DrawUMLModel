package data.data2;

import java.util.Scanner;

public class CoffeeTest {
	private static Scanner input;
	public static void main(String[] args) throws TemperatureException {
		CoffeeCup cup = new CoffeeCup();
		input = new Scanner(System.in);
		int temperature;
		VirtualPerson person = new VirtualPerson();
		try {
			System.out.print(" + Enter the temperature: ");
			temperature = input.nextInt();
			cup.setTemperature(temperature);
			person.drinkCoffee(cup);
		} catch (TemperatureException e) {
			try {
				throw new Exception(e);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}
}
