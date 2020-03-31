package com.utknl.katas;

import java.util.List;

/**
 * @param <I> https://www.codewars.com/kata/515bb423de843ea99400000a/train/java
 *            <p>
 *            For this exercise you will be strengthening your page-fu mastery.
 *            You will complete the PaginationHelper class, which is a utility class helpful for
 *            querying paging information related to an array.
 *            <p>
 *            The class is designed to take in an array of values and an integer indicating how many
 *            items will be allowed per each page. The types of values contained within the collection/array are not relevant.
 *            <p>
 *            The following are some examples of how this class is used:
 *            <p>
 *            PaginationHelper<Character> helper = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
 *            helper.pageCount(); //should == 2
 *            helper.itemCount(); //should == 6
 *            helper.pageItemCount(0); //should == 4
 *            helper.pageItemCount(1); // last page - should == 2
 *            helper.pageItemCount(2); // should == -1 since the page is invalid
 *            <p>
 *            // pageIndex takes an item index and returns the page that it belongs on
 *            helper.pageIndex(5); //should == 1 (zero based index)
 *            helper.pageIndex(2); //should == 0
 *            helper.pageIndex(20); //should == -1
 *            helper.pageIndex(-10); //should == -1
 */

public class PaginationHelper<I> {

    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */

    private List<I> collection;
    private int itemsPerPAge;

    public PaginationHelper(List<I> collection, int itemsPerPage) {
        if (collection == null)
            throw new RuntimeException("Collection can not be null or empty");
        this.collection = collection;
        if (itemsPerPage == 0) throw new RuntimeException("item per page can not be zero");
        this.itemsPerPAge = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        int division = collection.size() / itemsPerPAge;
        int remaining = collection.size() % itemsPerPAge;

        if (remaining == 0) {
            return division;
        } else return division + 1;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {

        int pageCount = this.pageCount();

        if (pageIndex < 0 || pageIndex > pageCount - 1) {
            return -1;
        }

        if (pageIndex == pageCount - 1) {
            return collection.size() % itemsPerPAge;
        } else return itemsPerPAge;

    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {

        int collectionSize = collection.size();

        if (itemIndex < 0 || itemIndex > collectionSize || collectionSize == 0) {
            return -1;
        }

        int division = (itemIndex + 1) / itemsPerPAge;
        int remaining = (itemIndex + 1) % itemsPerPAge;

        if (remaining == 0) {
            return division-1;
        } else return division;

    }
}