package com.company.javasample;

import java.util.HashMap;
import java.util.Set;


public class TransparencyCheckerImpl implements TransparencyChecker {
  
  private HashMap<String, Integer> reachabilityMap = new HashMap<String, Integer>();

  public boolean isTransparent(Set<Exchange> exchanges) {

    // populate reachability map 
    for (Exchange exchange : exchanges) {
      String name = exchange.getName();
      
      for (String outgoingName : exchange.getOutgoingConnections()) {
        String connection = getConnectionName(name, outgoingName);
        Integer counter = reachabilityMap.get(connection);
        if ( counter == null ) {
          counter = 0;
        }
        reachabilityMap.put(connection, counter + 1);
      }
    }
    
    for (String connection : reachabilityMap.keySet()) {
      if (reachabilityMap.get(connection) < 2) {
        System.out.println("Connection is not dual: " + connection);
        return false;
      }
    }
    return true;
  }

  
  private String getConnectionName(String name1, String name2) {
    
    if (name1.compareToIgnoreCase(name2) < 0) {
      return name1 + ":" + name2;
    }
    return name2 + ":" + name1;
  }
}
