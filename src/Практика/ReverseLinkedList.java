package Практика;

import java.util.LinkedList;

public class ReverseLinkedList {
    public static <T> void reverseInPlace(LinkedList<T> list) {
        int left = 0;
        int right = list.size() - 1;
        while (left < right) {
            T temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
    //Минус: get(index) и set(index) в LinkedList работают за O(n),
    // поэтому алгоритм получается O(n²). Для больших списков так делать не стоит.
}
