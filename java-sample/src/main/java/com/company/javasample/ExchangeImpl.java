package com.company.javasample;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class ExchangeImpl implements Exchange {

  private String name;
  private Set<String> outgoingConnections;

  public ExchangeImpl(String name, Collection<String> outgoingConnections) {

    this.name = name;
    this.outgoingConnections = new HashSet<String>(outgoingConnections);
  }

  public Set<String> getOutgoingConnections() {

    return outgoingConnections;
  }

  public String getName() {

    return name;
  }

  public String toString() {
    
    return name + ":" + String.join(", ", getOutgoingConnections());
  }
}
