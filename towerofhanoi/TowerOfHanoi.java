/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerofhanoi;

/**
 *
 * @author abiniks
 */
public class TowerOfHanoi {
    
    public static void moveDiscs(int numDiscs, int src, int by, int dest) {
        if(numDiscs > 1) {
            moveDiscs(numDiscs-1, src, dest, by);
            System.out.println("Move disc# " + numDiscs + " from " +  src + " to" + dest);
            moveDiscs(numDiscs-1, by, src, dest);
        }
    }
    
    public static void main(String[] args) {
        moveDiscs(3, 0, 1, 2);
    }
    
}
