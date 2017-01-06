package com.company.warehouse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GenericMapList {

  private Map<Class<?>, List<?>> map = new HashMap<Class<?>, List<?>>();
  
  public <T> void put(Class<T> key, T value) {
    
    List<T> list = (List<T>) map.get(key);
    if (list == null) {
      list = new ArrayList<T>();
    }
//    list.add(key.cast(value));
    list.add(value);
    map.put(key, list);
  }
  
  public <T> List<T> get(Class<T> key) {
    
    if (key == null) {
      return null;
    }

    return (List<T>)map.get(key);
//    List<T> list = (List<T>)map.get(key);
//    if(list == null) {
//      return null;
//    }
//    
//    return key.cast(list.get(0));
  }
  
  public <T> T getRemoveFirst(Class<T> key) {
    
    if (key == null) {
      return null;
    }

    List<T> list = (List<T>)map.get(key);
    if(list == null || list.size() == 0) {
      return null;
    }

    return key.cast(list.remove(0));
  }
  
  public Set<Class<?>> keySet() {
    
    return map.keySet();
  }
  
  public int size() {
    
    return keySet().size();
  }
  
  public String toString() {
    
    StringBuilder sb = new StringBuilder();
    for (Class<?> key : map.keySet()) {
      sb.append(key.getSimpleName() + " : ");
      sb.append(get(key));
      sb.append(System.lineSeparator());
    }
    return sb.toString();
  }
}
