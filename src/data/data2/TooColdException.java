package data.data2;

public class TooColdException extends TemperatureException {
	public TooColdException(){
	}
	public TooColdException(String str) {
		super(str);
	}
}
