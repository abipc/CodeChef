/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplejavacache;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 *
 * @author abiniks
 */
public class SimpleCache<K,V> {
    
    private final static int CACHE_MAX_SIZE = 100; 

    private Map<K,V> cache;
    
    public SimpleCache() {
        this.cache = new LinkedHashMap<K,V>() {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
                return cache.size() > CACHE_MAX_SIZE; //To change body of generated methods, choose Tools | Templates.
            }            
        };        
    }
    
    private V getValueFromExternal(K key)  {
        return null;
    }
    
    public V get(K key) {
        V value = cache.get(key);
        if(null != value)
            return value;
        value = getValueFromExternal(key);
        cache.put(key, value);
        return value;
    }
    
    public V put(K key, V value) {
        return cache.put(key, value);
    }    
}
