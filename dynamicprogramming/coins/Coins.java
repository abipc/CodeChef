/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming.coins;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author abiniks
 */
public class Coins {
    
    private Set<Integer> denominations = new HashSet<>();
    private Map<Integer, Integer> denomToCountMap = new HashMap<>();
    private int size = denominations.size();
    
    private void init() {
        for(int i : denominations) {
            denomToCountMap.put(i, 0);
        }
    }

    public Coins(Set<Integer> d) {
        this.denominations = d;
        this.size = d.size();
        init();
    } 
    
    public int findMinElementIndex(List<Integer> input) {
        int minIdx = 0;
        int size = input.size();
        for(int idx=1;idx<size;idx++)
            if(input.get(idx) < input.get(minIdx))
                minIdx = idx;
        return minIdx;
    }
    
    public int numCoins(int sum) {
        int[] temp = new int[size];
        Integer[] possibilities = new Integer[size];
        if(sum==0) {
            return 0;
        }
        
        if(sum < 0) {
            return Integer.MAX_VALUE;
        }
        int idx =0;
        for(int i : denominations) {
            temp[idx] = sum - i;
            possibilities[idx] = numCoins(temp[idx]);
            if(i==sum) {
//                int val = denomToCountMap.get(i);
//                denomToCountMap.put(i, val+1);
                return 1;
            }
            idx++;
        }
//        int minIdx = findMinElementIndex(Arrays.asList(possibilities));
//        int val = sum-temp[minIdx];
//        int k = denomToCountMap.get(val);
//        denomToCountMap.put(val, k+1);
        int ans = Collections.min(Arrays.asList(possibilities));
        return ans == Integer.MAX_VALUE ? Integer.MAX_VALUE : ans+1;
    }
    
    public static void main(String[] args) {
        Set<Integer> d = new HashSet<>();
        d.add(1);
        d.add(5);
        d.add(10);
        d.add(20);
        Coins c = new Coins(d);
        int ans = c.numCoins(17);
        System.out.println( ans == Integer.MAX_VALUE ? "Cannot be possible" : ans);
//        for(Map.Entry<Integer, Integer> entry : c.denomToCountMap.entrySet()) {
//            System.out.println(entry.getKey() + ": " + entry.getValue()); 
//        }
    }
    
}
