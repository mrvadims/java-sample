package com.company.javasample;


public class StringOperations {
  
  public boolean isPermutation(String str1, String str2) {
    
    String smStr = str1;
    String lgStr = str2;
    
    if (str1.length() > str2.length()) {
      smStr = str2;
      lgStr = str1;
    }
    
    for (char ch : lgStr.toCharArray()) {
      
    }
    return false;
  }

}
