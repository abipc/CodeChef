/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PriorityQueueImpl;

import java.util.Comparator;
import java.util.List;

public class PriorityQueueImpl<V> {
    
    private List<V> priorityQ;
    private Comparator<? super V> comparator;
    private int size;

    public PriorityQueueImpl(List<V> priorityQ) {
        this.priorityQ = priorityQ;
        this.size = priorityQ.size();
        heapify();
    }

    public PriorityQueueImpl(List<V> priorityQ, Comparator<? super V> comparator) {
        this.priorityQ = priorityQ;
        this.comparator = comparator;
        this.size = priorityQ.size();
        heapify();
    }  
    
    private void swap(int idx1, int idx2) {
        V temp = priorityQ.get(idx2);
        priorityQ.add(idx2, priorityQ.get(idx1));
        priorityQ.add(idx1, temp);
    }
    
    private int minimum(int parent, int lChild, int rChild) {
        V leftChild = priorityQ.get(lChild);
        V rightChild = priorityQ.get(rChild);   
        V parentVal = priorityQ.get(parent);
        if(comparator.compare(parentVal, rightChild) < 0) {
            if(comparator.compare(parentVal, leftChild) < 0)
                return parent;
            else
                return lChild;
        } else {
            if(comparator.compare(rightChild, leftChild) < 0)
                return rChild;
            else
                return lChild;
        }
    }
    
    private void heapifyDown(int idx) {
        int rightChildIdx = getRightChild(idx);
        int leftChildIdx = getLeftChild(idx);

        int minValIdx = minimum(idx, leftChildIdx, rightChildIdx);
        if(minValIdx == idx)
            return;
        else {
            swap(idx, minValIdx);
            heapifyDown(minValIdx);
        }
    }
    
    public final void heapify() {
        for(int idx=size-1; idx>-1; idx--) {
            if(getLeftChild(idx) > size-1)
                continue;
            heapifyDown(idx);            
        }
    }
    
    private int getParent(int i) {
        return (i-1)/2;
    }
    
    private int getLeftChild(int i) {
        return 2*i+1;
    }
    
    private int getRightChild(int i) {
        return 2*i+2;
    }
    
    public boolean add(V value) {
        priorityQ.add(value);
        heapify();
        return true;
    }
    
    public V remove(V value) {
        int idxOfValue =-1;
        for(int i=0; i<size;i++)
            if(priorityQ.get(i) == value)
                idxOfValue = i;
        if(-1 == idxOfValue)
            return null;
        swap(idxOfValue, size-1);
        V valRemoved = priorityQ.remove(size-1);
        heapify();
        return valRemoved;
    }    
}
