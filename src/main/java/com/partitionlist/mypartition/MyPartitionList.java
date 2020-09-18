package com.partitionlist.mypartition;

import java.util.AbstractList;
import java.util.List;

public class MyPartitionList {
    /**
     * @param list       the list to return consecutive sublists of
     * @param bucketSize the desired size of each sublist (the last may be
     *                   smaller)
     * @return a list of consecutive sublists
     * @throws IllegalArgumentException if {@code partitionSize} is nonpositive
     */

     /*  Use new  type of list called Partition,
      *  extend the AbstractList<List<T>> class,
      * And implement two methods - get(int index) and size()
      * The idea  is to hide the original list inside this
        class and modify its behavior
       * so instead of returning single elements from
       * the original list, we are going to return chunks
        of a given size.
     */
    public static <T> List<List<T>> partition(List<T> list, int bucketSize) {

        if (list.isEmpty()) {
            throw new IllegalArgumentException("list must not be empty");
        }
        if (list == null) {
            throw new NullPointerException("'list' must not be null");
        }
        if (bucketSize <= 0) {
            throw new IllegalArgumentException("'size' must be greater than 0");
        }
        if (bucketSize + list.size() >= Integer.MAX_VALUE) {
            throw new IllegalArgumentException("BucketSize plus list size must be less than " + Integer.MAX_VALUE);
        }
        return new Partition<T>(list, bucketSize);
    }

    private static class Partition<T> extends AbstractList<List<T>> {

        final List<T> list;
        final int size;

        Partition(List<T> list, int size) {
            this.list = list;
            this.size = size;
        }

        @Override
        public List<T> get(int index) {
            int listSize = size();
            if (listSize < 0)
                throw new IllegalArgumentException("negative size: " + listSize);
            if (index < 0)
                throw new IndexOutOfBoundsException(
                        "index " + index + " must not be negative");
            if (index >= listSize)
                throw new IndexOutOfBoundsException(
                        "index " + index + " must be less than size " + listSize);
            int start = index * size;
            int end = Math.min(start + size, list.size());
            return list.subList(start, end);
        }

        /**
         * @return the number of subLists in this partition
         */
        @Override
        public int size() {
            return (list.size() + size - 1) / size;

        }

        @Override
        public boolean isEmpty() {
            return list.isEmpty();
        }
    }


}
