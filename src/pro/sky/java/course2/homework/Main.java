package pro.sky.java.course2.homework;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        IntegerListImpl array = new IntegerListImpl();

        System.out.println("array.contains(98_765) = " + array.contains(98_765));

        System.out.println("array = " + array);

        Integer[] arrayForTest = array.toArray();

        long startBubble = System.currentTimeMillis();
        sortBubble(arrayForTest);
        System.out.println("Time: " + (System.currentTimeMillis() - startBubble));
        //Time: 76913

        Integer[] arrayForTest2 = array.toArray();

        long startSelection = System.currentTimeMillis();
        sortSelection(arrayForTest2);
        System.out.println("arrayForTest2 = " + Arrays.toString(arrayForTest2));
        System.out.println("Time: " + (System.currentTimeMillis() - startSelection));
        //Time: 10186

        Integer[] arrayForTest3 = array.toArray();

        long startInsertion = System.currentTimeMillis();
        sortInsertion(arrayForTest3);
        System.out.println("Time: " + (System.currentTimeMillis() - startInsertion));
        //Time: 19087

    }

    private static void sortBubble(Integer[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]){
                    swapElements(arr, j, j +1);
                }
            }
        }
    }

    public static void sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    public static void sortInsertion(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }


}
