/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dynamicprogramming.LCS;

/**
 *
 * @author abiniks
 */
public class LCS {
    // and 
    
    public static void main(String[] args) {
        String one = "nikita";
        String two = "abhishek";
        
        System.out.println(findLCS(one, two));                
    }        
    
    public static String findLCS(String str1, String str2 ) {
        if(null == str1 || null == str2)
            return "";
        if("".equals(str1) || "".equals(str2)) {
            return "";
        }
        if(str1.charAt(str1.length()-1) == str2.charAt(str2.length()-1)) {
            return findLCS(str1.substring(0, str1.length() -1), str2.substring(0, str2.length()-1)) + str1.substring(str1.length()-1, str1.length());
        } else {
           String opt1 = findLCS(str1.substring(0, str1.length() -1), str2); 
           String opt2 = findLCS(str1, str2.substring(0, str2.length()-1));
           if(opt1.length() >= opt2.length())
               return opt1;
           else
               return opt2;
        }
    }
}
