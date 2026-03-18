package Практика;

import java.util.List;
import java.util.stream.Collectors;

public class WbBank {

    private static List<Integer> list1 = List.of(1,2,3,4,5,6);
    private static List<Integer> list2 = List.of(1,2,3,4,7,8);
    // найти элементы второго которых нет в первом
    static  <T> List<T> task(List<T> list1, List<T> list2) {
        var set = list1.stream().collect(Collectors.toSet());
        return list2.stream().filter(item -> set.contains(item) == false).toList();
    }

    public static void main(String[] args) {
        task(list1,list2).forEach(s -> System.out.println(s)); // Вывод 7,8;
    }

}
