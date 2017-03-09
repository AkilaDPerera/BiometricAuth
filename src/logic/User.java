package logic;

import java.io.Serializable;


public class User implements Serializable  {
    private String username;
    private float[] widths;
    private float[] lengths;
    
    public User(String username, float[] widths, float[] lengths){
        this.username = username;
        this.widths = widths;
        this.lengths = lengths;
    }
    
    public String getUsername(){
        return this.username;
    }
    public float[] getWidths(){
        return this.widths;
    }
    public float[] getLengths(){
        return this.lengths;
    }
}
