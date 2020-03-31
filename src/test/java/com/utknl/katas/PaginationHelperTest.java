package com.utknl.katas;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class PaginationHelperTest {


    @Test
    public void itemCountTest() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        System.out.println(helper.itemCount());
    }

    @Test
    public void pageCountTest() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        Assert.assertEquals(2, helper.pageCount());
    }

    @Test
    public void pageItemCountTest() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        Assert.assertEquals(4, helper.pageItemCount(0));
        Assert.assertEquals(2, helper.pageItemCount(1));
        Assert.assertEquals(-1, helper.pageItemCount(2));
    }

    @Test
    public void pageIndexTest() {
        PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        Assert.assertEquals(1, helper.pageIndex(5)); //should == 1 (zero based index)
        Assert.assertEquals(0, helper.pageIndex(2)); //should == 0
        Assert.assertEquals(-1, helper.pageIndex(20)); //should == -1
        Assert.assertEquals(-1, helper.pageIndex(-10)); //should == -1
    }
}