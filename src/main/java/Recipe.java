/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MimiHMB
 */

import java.util.ArrayList;

public class Recipe {
    private String name;
    private int time;
    private ArrayList<String> list_;
    
    public Recipe(String name, int time, ArrayList<String> list) {
        this.name = name;
        this.time = time;
        this.list_ = list;
    }
    
    public String getName(){
        return this.name;
    }
    
    public int getTime() {
        return this.time;
    }
    
    public ArrayList<String> getIngredient() {
        return this.list_;
    }
    
    public String toString() {
        return (this.name + ", cooking time: " + this.time);
    }
}
