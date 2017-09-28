package serwlety;

public class LogikaKalkulatora {

	public static double oblicz(double x, double y, String operacja) {
    	switch(operacja) {
        	case "+" : return x + y;
        	case "-" : return x - y;
        	case "*" : return x * y;
        	case "/" : return x / y;
        	default  : return 0;
    	}
	}
}
