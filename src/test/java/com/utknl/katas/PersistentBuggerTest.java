package com.utknl.katas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersistentBuggerTest {


    @Test
    public void BasicTests() {
        System.out.println("****** Basic Tests ******");
        assertEquals(3, PersistentBugger.persistence(39));
        assertEquals(0, PersistentBugger.persistence(4));
        assertEquals(2, PersistentBugger.persistence(25));
        assertEquals(4, PersistentBugger.persistence(999));
    }

    @Test
    public void numberSplit(){


    }

}