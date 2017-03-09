package logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import static java.lang.Math.abs;
import java.util.ArrayList;

public class AuthLogic {
    private UserData data = null;
    
    public AuthLogic(){
    	ObjectInputStream ois=null;
		try {
			ois = new ObjectInputStream(new FileInputStream("src/data.dat"));
			this.data = (UserData) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			this.data = new UserData();
		}finally {
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
				}
			}
		}        
    }
    
    private void saveData(){
    	ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("src/data.dat"));
            oos.writeObject(this.data);
        } catch (IOException e) {
        }finally{
            if (oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                }
            }
        }
    }

    public void signUp(String username, float[] widths, float[] lengths){
        this.data.getUsers().add(new User(username, widths, lengths));
        saveData();
    }

    public String signIn(float[] widths, float[] lengths){
    	if (data.getUsers().size()==0){
    		return "";
    	}
    	
    	float deviation = Float.MAX_VALUE;
    	float calc_deviation;
    	User appr_user=null;
    	for(User user:data.getUsers()){
    		calc_deviation = getDeviation(user, widths, lengths);
    		if (calc_deviation<deviation){
    			deviation = calc_deviation;
    			appr_user = user;
    		}
    	}
    	
    	if (deviation<1){
    		System.out.println("Username : " + appr_user.getUsername());
    		System.out.println("Deviation : " + String.valueOf(deviation));
    		return appr_user.getUsername();
    	}else{
    		System.out.println("No user found");
    		return "";
    	}
    	
    }
    
    private float getDeviation(User user, float[] widths, float[] lengths){
    	float deviation = 0;
    	float[] user_widths = user.getWidths();
    	float[] user_lengths = user.getLengths();
       
    	for (int i=0; i<5; i++){
    		deviation += abs(user_widths[i] - widths[i]);
    		deviation += abs(user_lengths[i] - lengths[i]);
    	}
    	
    	return deviation;
    }

    public int getNumberOfUsers(){
    	return data.getUsers().size();
    }
}
