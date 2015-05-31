package data.data5;

public  class NickleNDime extends Account{
	private double withdrawCount;
	static final double  fee= 0.5;
	public NickleNDime(double balance) {
		super(balance);
		withdrawCount=0;
	}
	public void withdraw(double amount){
		balance-=amount;
		transactions++;
		withdrawCount++;
	}
	@Override
	public double endMonthCharge() {
		balance-=withdrawCount*fee;
		return balance;
	}
	}
	
