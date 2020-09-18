package com.partitionlist;

import com.partitionlist.mypartition.MyPartitionList;

import java.util.Arrays;
import java.util.List;

public class PartitionListApplication {

    public static void main(String[] args) {

        final List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7);

        //output
        System.out.println(numbers + "Initial list");
        System.out.println(MyPartitionList.partition(numbers, 1));
        System.out.println(MyPartitionList.partition(numbers, 2));
        System.out.println(MyPartitionList.partition(numbers, 3));
        System.out.println(MyPartitionList.partition(numbers, 4));
        System.out.println(MyPartitionList.partition(numbers, 5));
        System.out.println(MyPartitionList.partition(numbers, 6));
        System.out.println(MyPartitionList.partition(numbers, 7));
        System.out.println(MyPartitionList.partition(numbers, 8));
        System.out.println(MyPartitionList.partition(numbers, 9));


    }

}
