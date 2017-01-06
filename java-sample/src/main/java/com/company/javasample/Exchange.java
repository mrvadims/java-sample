package com.company.javasample;

import java.util.Set;

interface Exchange {

  /**
   * Returns list of names of exchanges which receive all trading information from this exchange.
   * 
   * @return list of exchanges
   */
  Set<String> getOutgoingConnections();

  /**
   * Name of the exchange
   * 
   * @return name
   */
  String getName();
  
}