/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package FrequencyStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 * @author abiniks
 */
public class FrequencyStack {
    
    private int maxCount=0;
    private Map<Integer, Stack<Integer>> countToStackMap = new HashMap<>();;
    private Map<Integer, Integer> elemToCountMap = new HashMap<>();
    
    public void add(int val) {
        int temp=0;
        if(null == elemToCountMap.get(val)) {
            elemToCountMap.put(val, ++temp);
            if(maxCount < temp)
                maxCount = temp;
            if(null == countToStackMap.get(temp)) {
                Stack<Integer> stack = new Stack<>();
                stack.add(val);
                countToStackMap.put(temp, stack);
            }                
        } else {
            temp = elemToCountMap.get(val);
            elemToCountMap.put(val, ++temp);
            if(maxCount < temp)
                maxCount = temp;
        }
    }        
}
