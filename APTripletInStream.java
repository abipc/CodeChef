/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author abhishek87
 */
class APTripletInStream {
    
    public static void main(String[] args) {
        
        int idx=0, numInStream;
        Scanner scanIn = new Scanner(System.in), readLine;        
        
        String line = scanIn.nextLine();
        readLine = new Scanner(line);          
        
        DataStore dStore = new DataStore(30000 + 1);
        
        while(scanIn.hasNextLine()) {
            line = scanIn.nextLine();
            readLine = new Scanner(line);
            while(readLine.hasNextInt()){
                numInStream = readLine.nextInt();
                dStore.add(++idx, numInStream); 
            }
            break;                       
        }
        Long res = 0L;
        try {
            res = APProblemSolver.solveProblem(dStore);  
        } catch(Exception ex) {
            res = 0L;
        }
        System.out.println(res);        
    }
}

class APProblemSolver {
    public static Long solveProblem(DataStore dStore) {
        Long freq = 0L;
        int dSize = dStore.size();
        for(int idx=1; idx<=dSize-1; idx++) {
            Set currSet = dStore.getSetAtIndex(idx);
            if(null != currSet && !currSet.isEmpty()) {

                int size = currSet.size();
                if(size >= 3) {
                    freq += (size*(long)(size-1)*(long)(size - 2)/6L);
                }
                
                for(int right = 2*idx-1; right > idx; right--){
                    if(right >= dSize)
                        continue;
                    Set rightSet = dStore.getSetAtIndex(right);
                    Set leftSet = dStore.getSetAtIndex(2*idx - right);
                    if(null != rightSet && null != leftSet) {
                        for(Object obj : currSet) {
                            Set leftSetHeadSet = ((TreeSet)leftSet).headSet(obj);
                            Set rightSetTailSet = ((TreeSet)rightSet).tailSet(obj);
                            freq += leftSetHeadSet.size() * rightSetTailSet.size();
                            
                            Set leftSetTailSet = ((TreeSet)leftSet).tailSet(obj);
                            Set rightSetHeadSet = ((TreeSet)rightSet).headSet(obj);  
                            freq += leftSetTailSet.size() * rightSetHeadSet.size();
                        }
                    }
                }                
            }
        }        
        return freq;
    }           
}

class DataStore {
   
    private TreeSet[] list = null;
    private int size;

    public DataStore(int size) {
        this.size = size;
        list = new TreeSet[size];
    }    

    public void add(Integer idx, Integer val) {
        Set<Integer> i = list[val];
        if(null == i) {
            i = new TreeSet<Integer>();
            i.add(idx);
            list[val] = (TreeSet<Integer>)i;
        } else{
            ((TreeSet<Integer>)list[val]).add(idx);
        }
    }
    
    public int size() {
        return size;
    }    
    
    public Set getSetAtIndex(int idx) {
        return list[idx];
    }
}
