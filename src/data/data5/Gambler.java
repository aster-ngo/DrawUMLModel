package data.data5;

public class Gambler extends Account {
	public Gambler(double balance) {
		super(balance);
		// TODO Auto-generated constructor stub
	}
	public static double fee = (double) 0.5;
	public void withdraw(double a){
		int ran = (int)(100*Math.random());
		if(ran >=0 && ran<=49) balance-=0;
		else balance-=(2*a);
		transactions++;
	}
	//@Override
	
	public double endMonthCharge() {
		return balance;
	}
	
}
