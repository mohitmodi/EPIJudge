package educative;

import java.util.*;
import java.util.stream.Collectors;

public class Java8 {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        strings.add("apple");
        strings.add("banana");
        strings.add("cherry");
        strings.add("date");
        strings.add("fig");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println(strings.stream()
                .collect(Collectors.groupingBy(String::length)));

        System.out.println(strings.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.mapping(String::length, Collectors.toList()))));

        System.out.println(numbers.stream().filter(e -> e % 2 == 0).mapToInt(e -> e * 2).sum());

        //employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

    }
}
