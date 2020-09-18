package com.partitionlist.mypartitiontest;

import com.partitionlist.mypartition.MyPartitionList;
import org.assertj.core.util.Lists;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MyPartitionListTest {
    private List<Integer> intList;

    @Test
    public void partitionShouldBeSuccessful_WhenBucketSizeIsGreaterThanListSize() {
        //given
        int bucketSize = 8;
        intList = buildList();

        //when
        final List<List<Integer>> subLists = MyPartitionList.partition(intList, bucketSize);
        final List<Integer> lastPartition = subLists.get(0);
        final List<Integer> expectedLastPartition = Lists.<Integer>newArrayList(1, 2, 3, 4, 5, 6, 7);

        //then
        assertTrue(intList.size() == 7);

        assertThat(subLists.size(), equalTo(1));
        assertThat(lastPartition, equalTo(expectedLastPartition));

    }

    @Test
    public void shouldReturnMaxNumberElementInEachBucket() {
        //given
        intList = buildList();
        int buckets = 2;
        int divide = intList.size() / buckets;
        if (intList.size() % buckets != 0) {
            divide++;
        }
        System.out.println("Max. number of element in each bucket " + divide);
        //when
        final List<List<Integer>> subLists = MyPartitionList.partition(intList, divide);
        //then
        assertTrue(subLists.size() == buckets);

    }

    @Test
    public void partitionShouldBeSuccessful_WhenBucketSizeIsSmallerThanListSize() {
        //given
        int bucketSize = 3;
        intList = buildList();

        //when
        final List<List<Integer>> subLists = MyPartitionList.partition(intList, bucketSize);
        final List<Integer> lastPartition = subLists.get(2);
        final List<Integer> expectedLastPartition = Lists.<Integer>newArrayList(7);

        //then
        assertTrue(intList.size() == 7);

        assertThat(subLists.size(), equalTo(3));
        assertThat(lastPartition, equalTo(expectedLastPartition));

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_WhenBucketSizePlusListSizeIsGreaterThanOrEqualToIntegerMAX_VALUE() {

        intList = buildList();

        final List<List<Integer>> subLists = MyPartitionList.partition(intList, Integer.MAX_VALUE - intList.size());
    }


    @Test(expected = NullPointerException.class)
    public void shouldThrowException_whenListIsNull() throws NullPointerException {

        //given
        int bucketSize = 3;
        intList = null;

        //when
        final List<List<Integer>> subLists = MyPartitionList.partition(intList, bucketSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_whenNegativeBucketsSize() throws IllegalArgumentException {

        //given
        int bucketSize = -3;
        intList = buildList();

        //when
        final List<List<Integer>> subLists = MyPartitionList.partition(intList, bucketSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_whenBucketSizeEqualZero() throws IllegalArgumentException {

        //given
        int bucketSize = 0;
        intList = buildList();

        //when
        final List<List<Integer>> subLists = MyPartitionList.partition(intList, bucketSize);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowException_whenListIsEmpty() throws IllegalArgumentException {

        //given
        int bucketSize = 0;
        intList = new ArrayList<>();

        //when
        final List<List<Integer>> subLists = MyPartitionList.partition(intList, bucketSize);
    }

    private List<Integer> buildList() {
        intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        intList.add(7);
        return intList;
    }
}
