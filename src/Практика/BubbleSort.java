package Практика;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        //Bubble Sort имеет временную сложность O(n²) в
        // среднем и худшем случаях. В лучшем О(n) - если массив изначально отсортирован
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; // массив уже отсортирован
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        bubbleSort(arr);
        for (int x : arr) System.out.print(x + " ");
        // → 11 12 22 25 34 64 90
    }
}

