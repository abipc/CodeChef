/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author abiniks
 */
public class KnightTour {

    private Set<ChessCell> visited = new HashSet<>();
    private static final int CHESS_BOARD_SIZE = 64;
    private static final Map<ChessCell, Set<ChessCell>> chessCellToOptionsMap = new HashMap<>();
    
    static {
        for(int i=1; i<=64; i++) {
            ChessCell aCell = getChessCellByIndex(i);
            chessCellToOptionsMap.put(aCell, null);
        }
    }
    
    private static ChessCell getChessCellByIndex(int i) {
        return null;
    }
    
    private void printAll() {
        for(ChessCell aChessCell : visited) 
            System.out.println("x: " + aChessCell.getX() + "y: " + aChessCell.getY());
    }
    
    private Set<ChessCell> getAllOptions(int x, int y) {
        
        return null;        
    }
    
    public void doKnightTour(int x, int y) {
        //visited.add(new CC(x,y))      
        ChessCell cell = new ChessCell(x, y);
        visited.add(cell);
        //if visited.size == 64
        if(CHESS_BOARD_SIZE == visited.size()) {
            //print all
            //return            
            printAll();
        } else {
        //else
            //get all possibilities at x,y
            Set<ChessCell> allOptions = getAllOptions(x, y);
            //for each possibility p
            for(ChessCell anOption : allOptions) {
                //if anOption not visited
                //doKnightTour(p)
                if(!visited.contains(anOption)) {
                    doKnightTour(anOption.getX(), anOption.getY());
                }
            }
            //remove x,y from visited
            if(CHESS_BOARD_SIZE != visited.size())
                visited.remove(cell);
        }
        
    }
            
    private class ChessCell {
        private int x;
        private int y;

        public ChessCell(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ChessCell other = (ChessCell) obj;
            if (this.x != other.x) {
                return false;
            }
            if (this.y != other.y) {
                return false;
            }
            return true;
        }                
    }
}
