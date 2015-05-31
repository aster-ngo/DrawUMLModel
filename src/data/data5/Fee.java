package data.data5;
public class Fee extends Account{
	public static float fee= 5;
	public Fee(double balance){
		super(balance);
	}
	@Override
	public void withdraw(double a) {
		// TODO Auto-generated method stub
		balance-=a;
	}
	@Override
	public double endMonthCharge() {
		// TODO Auto-generated method stub
		balance-=fee;
		return balance;
	}
}
