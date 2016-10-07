package edu.byu.cs.superasteroids.base;

import android.util.Pair;

import java.util.Iterator;
import java.util.List;

/**
 * A class used for easy debugging
 * @author Scott Leland Crossen
 */
public class Debug {
/*
FIELDS
 */
    /**
     * The extent of instantiated objects
     */
    private static List<Debug> extent;
    /**
     * Whether the class is turned on
     */
    private static final boolean turned_on=true;
    /**
     * The ID of the object
     */
    private int id=0;
    /**
     * The list of flags encountered
     */
    private static List<Pair<Integer,Integer>> flag_list;
/*
CONSTRUCTORS
 */
    /**
     * The default constructor of the object
     */
    Debug(){
        extent.add(this);
    }
    /**
     * The constructor of the object with ID
     * @param _id   the ID of the object
     */
    Debug(int _id){
        id=_id;
        extent.add(this);
    }
/*
METHODS
 */
    /**
     * The flag method adds a flag to the stack for later recall
     * @param flag
     */
    public void flag(int flag){
        if(turned_on) {
            Pair<Integer, Integer> new_pair = new Pair<>(id, flag);
            flag_list.add(new_pair);
        }
    }
    /**
     * This method prints the flags on the stack that have been previously pushed.
     */
    public void printFlags(){
        if(turned_on) {
            String print_line=new String();
            print_line+="Flags Encountered: ";
            Iterator<Pair<Integer,Integer>> iter=flag_list.iterator();
            while(iter.hasNext()){
                Pair<Integer,Integer> current_iter=iter.next();
                print_line+=(" ("+current_iter.first+","+current_iter.second+")");
            }
            System.out.println(print_line);
        }
        clearFlags();
    }
    /**
     * This method prints the flags on the stack that have been previously pushed.
     * @param flag  the current flag
     */
    public void printFlags(int flag){
        if(turned_on) {
            flag(flag);
            printFlags();
        }
    }
    /**
     * This method clears all flags on the stack
     */
    public void clearFlags(){
        flag_list.clear();
    }
    /**
     * This method outputs a string to the terminal
     * @param output    the desired output string.
     */
    public void output(String output){
        if(turned_on){
            System.out.println(output);
        }
    }
}
