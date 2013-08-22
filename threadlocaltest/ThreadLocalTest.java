/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threadlocaltest;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author abiniks
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(new TaskPlusPlusExt());
        Thread t2 = new Thread(new TaskPlusPlus());
        t1.start();
        t2.start();
    }
    
    public static int getUniqueID() {
        return PerThreadUniqueID.getID();
    }    

//    public static void main(String args[]) throws IOException {
//        Thread t1 = new Thread(new Task());   
//        Thread t2 = new Thread( new Task());
//      
//        t1.start();
//        t2.start();       
//      
//    }
    
    /*
     * Thread safe format method because every thread will use its own DateFormat
     */
//    public static String threadSafeFormat(Date date){
//        DateFormat formatter = PerThreadFormatter.getDateFormatter();
//        return formatter.format(date);
//    }
}

//class PerThreadFormatter {
//    public static ThreadLocal<SimpleDateFormat> dateFormatHolder = new ThreadLocal<SimpleDateFormat>() {    
//        @Override
//        protected SimpleDateFormat initialValue() {
//            System.out.println("Creating SimpleDateFormat for Thread : " + Thread.currentThread().getName());
//            return new SimpleDateFormat("dd/MM/yyyy");
//        }
//    };
//    
//    public static DateFormat getDateFormatter() {
//        return dateFormatHolder.get();
//    }    
//}
//
//class Task implements Runnable {
//    
//    @Override
//    public void run() {
//        System.out.println(ThreadLocalTest.threadSafeFormat(new Date()));
//    }
//}

//class ThreadLocalTestPlusPlus {
////    
////    public static void main(String[] args) {
////        Thread t1 = new Thread(new TaskPlusPlusExt());
////        Thread t2 = new Thread(new TaskPlusPlus());
////        t1.start();
////        t2.start();
////    }
////    
////    public static int getUniqueID() {
////        return PerThreadUniqueID.getID();
////    }
////}

class PerThreadUniqueID {
    private static AtomicInteger nextId = new AtomicInteger();
    private static ThreadLocal<Integer> uniqueID = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return getNextID();
        }
    };
    
    private static int getNextID() {
        return nextId.getAndIncrement();
    }
    
    public static int getID() {
        int seed = uniqueID.get();
        Double d = Math.random();
        return seed + 1 + 99*d.intValue();
    }        
}

class TaskPlusPlus implements Runnable {
    @Override
    public void run() {
        
        System.out.println("Name: " + Thread.currentThread().getName()+ " ID: " + ThreadLocalTest.getUniqueID());
        for(int idx=0;idx<100 ;idx++) {
            
        }
        
        System.out.println("Name: " + Thread.currentThread().getName()+ " ID: " + ThreadLocalTest.getUniqueID());
    }
}

class TaskPlusPlusExt implements Runnable {
    @Override
    public void run() {
        
        System.out.println("Name: " + Thread.currentThread().getName()+ " ID: " + ThreadLocalTest.getUniqueID());
    }
}