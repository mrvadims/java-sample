package com.company.javasample;

import java.util.Set;

interface TransparencyChecker {

  /**
   * Checks the transparency of the network. The network is the collection of exchanges and each of them has a unique name.
   * 
   * @param exchanges
   *          list of exchanges in the network
   * @return true if all trading information is available for every exchange
   */
  boolean isTransparent(Set<Exchange> exchanges);
  
}