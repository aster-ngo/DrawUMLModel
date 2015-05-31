package data.data5;
import java.util.Scanner;
abstract class Account {
	protected double balance;
	protected  int transactions;
	public Account(double balance) {
		this.balance=balance;
	}
	public void deposit(double a){
		balance+=a;
		transactions+=1;
	}
	public abstract void withdraw(double a);
	public abstract double endMonthCharge();
	public void endMonth(){
		endMonthCharge();
		System.out.print("-)So tien cua ban la :"+balance);
		System.out.println("\n");
		System.out.print("+)So giao dich trong thang la :"+transactions);
		transactions =0;
	} 
	public static void main(String[] args){
		System.out.println("Tai khoan thuong: ");
		Fee fee = new Fee(1500);
		fee.deposit(500);
		fee.withdraw(400);
		fee.endMonth();
		System.out.println("\n");
		System.out.println("Tai khoan NickledNDime");
		NickleNDime nick = new NickleNDime(10000);
		nick.withdraw(1000);
		nick.withdraw(5000);
		nick.endMonth();
		System.out.println("\n");
		System.out.println("Tai khoan Gambler: ");
		Gambler gam = new Gambler(10000);
		gam.withdraw(500);
		gam.endMonth();
	}
}
