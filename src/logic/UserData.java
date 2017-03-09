package logic;

import java.io.Serializable;
import java.util.ArrayList;

public class UserData implements Serializable {
	private ArrayList<User> users;
	
	public UserData(){
		users = new ArrayList<User>();
	}
	
	public ArrayList<User> getUsers(){
		return users;
	}
}
