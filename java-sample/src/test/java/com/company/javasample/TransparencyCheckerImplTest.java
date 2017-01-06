package com.company.javasample;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;


public class TransparencyCheckerImplTest {
  

  @Test
  public void testIsTransparentOneExchanges() {

    Set<Exchange> exchangeSet = new HashSet<Exchange>();
    exchangeSet.add(new ExchangeImpl("1", Arrays.asList("2", "3", "4")));
    TransparencyChecker transparencyChecker = new TransparencyCheckerImpl();
    assertFalse("Exchange is transparent", transparencyChecker.isTransparent(exchangeSet));
  }

  @Test
  public void testIsTransparentTwoExchanges() {

    Set<Exchange> exchangeSet = new HashSet<Exchange>();
    exchangeSet.add(new ExchangeImpl("1", Arrays.asList("2")));
    exchangeSet.add(new ExchangeImpl("2", Arrays.asList("1")));
    TransparencyChecker transparencyChecker = new TransparencyCheckerImpl();
    assertTrue("Exchange is transparent", transparencyChecker.isTransparent(exchangeSet));
  }

  @Test
  public void testIsTransparentTwoExchangesFalse() {

    Set<Exchange> exchangeSet = new HashSet<Exchange>();
    exchangeSet.add(new ExchangeImpl("1", Arrays.asList("2", "3")));
    exchangeSet.add(new ExchangeImpl("2", Arrays.asList("1")));
    TransparencyChecker transparencyChecker = new TransparencyCheckerImpl();
    assertFalse("Exchange is transparent", transparencyChecker.isTransparent(exchangeSet));
  }

  @Test
  public void testIsTransparentThreeExchanges() {

    Set<Exchange> exchangeSet = new HashSet<Exchange>();
    exchangeSet.add(new ExchangeImpl("1", Arrays.asList("2", "3")));
    exchangeSet.add(new ExchangeImpl("2", Arrays.asList("1", "3")));
    exchangeSet.add(new ExchangeImpl("3", Arrays.asList("1", "2")));
    TransparencyChecker transparencyChecker = new TransparencyCheckerImpl();
    assertTrue("Exchange is transparent", transparencyChecker.isTransparent(exchangeSet));
  }

}
