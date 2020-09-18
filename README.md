# partitionList
A java library allow partition a list to sublists of n size
## How to install
Build the project with maven
```
mvn package
```
Jar file generated
```
target/partition-list-0.0.1-SNAPSHOT.jar
```

## How to use

```java
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

```
#### Inputs
 
```
([1,2,3,4,5,6,7], 1)
([1,2,3,4,5,6,7], 2)
([1,2,3,4,5,6,7], 3)
([1,2,3,4,5,6,7], 4)
([1,2,3,4,5,6,7], 5)
([1,2,3,4,5,6,7], 6)
([1,2,3,4,5,6,7], 7)
([1,2,3,4,5,6,7], 8)
([1,2,3,4,5,6,7], 8)

 ```
#### Output
 
```
[1, 2, 3, 4, 5, 6, 7]Initial list
[[1], [2], [3], [4], [5], [6], [7]]
[[1, 2], [3, 4], [5, 6], [7]]
[[1, 2, 3], [4, 5, 6], [7]]
[[1, 2, 3, 4], [5, 6, 7]]
[[1, 2, 3, 4, 5], [6, 7]]
[[1, 2, 3, 4, 5, 6], [7]]
[[1, 2, 3, 4, 5, 6, 7]]
[[1, 2, 3, 4, 5, 6, 7]]
[[1, 2, 3, 4, 5, 6, 7]]
