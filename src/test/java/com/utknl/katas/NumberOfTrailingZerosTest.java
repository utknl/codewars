package com.utknl.katas;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

public class NumberOfTrailingZerosTest {

    @Test
    public void testZeros() throws Exception {
      assertThat(NumberOfTrailingZeros.zeros(0), is(0)); 
      assertThat(NumberOfTrailingZeros.zeros(6), is(1)); 
      assertThat(NumberOfTrailingZeros.zeros(14), is(2));    
    }

}