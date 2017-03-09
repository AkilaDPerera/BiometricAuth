package validation;

public class Validation {
	public static Boolean isValid(String text){
		try{
			Float.valueOf(text);
			return true;
		}catch(Exception e){
			return false;
		}
	}
}
