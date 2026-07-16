package Практика;

import java.util.Arrays;

public class Cортировка_слиянием {

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Исходный массив: " + Arrays.toString(arr));
        mergeSort(arr);
        System.out.println("Отсортированный массив: " + Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int mid = arr.length / 2;

        // Создаём левую и правую половины
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);

        // Рекурсивно сортируем каждую половину
        mergeSort(left);
        mergeSort(right);

        // Сливаем отсортированные половины
        merge(arr, left, right);
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0; // индекс для левого массива
        int j = 0; // индекс для правого массива
        int k = 0; // индекс для результирующего массива

        // Сравниваем элементы из левого и правого массивов
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k] = left[i];
                i++;
            } else {
                result[k] = right[j];
                j++;
            }
            k++;
        }

        // Копируем оставшиеся элементы из левого массива (если есть)
        while (i < left.length) {
            result[k] = left[i];
            i++;
            k++;
        }

        // Копируем оставшиеся элементы из правого массива (если есть)
        while (j < right.length) {
            result[k] = right[j];
            j++;
            k++;
        }
    }
}

