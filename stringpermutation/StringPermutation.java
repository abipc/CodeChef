/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package stringpermutation;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author abiniks
 */
public class StringPermutation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String one = "AACD";//AACDDF
        Set<String> resultList = permute(one);
        for(String str : resultList) {
            System.out.println(str);
        }
    }
    
    public static Set<String> permute(String input) {
        Set<String> result = new HashSet<String>();
        if(null == input || input.equals("")) 
            return result;
        if(input.length() == 1) {
            result.add(input);
            return result;
        }
        int len = input.length();
        for(int idx=0; idx<len; idx++) {
            String character = String.valueOf(input.charAt(idx)), strToPermute;
            if(idx < len-1)
                strToPermute = input.substring(0, idx) + input.substring(idx +1, input.length());
            else
                strToPermute = input.substring(0, idx);
            Set<String> tempRes = permute(strToPermute);
            for(String str : tempRes) {
                result.add(character+str);
            }                
        }                
        return result;
    }
}
