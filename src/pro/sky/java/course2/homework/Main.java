package pro.sky.java.course2.homework;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        IntegerListImpl array = new IntegerListImpl();
        //Integer[] arrayForTest = array.toArray();

        /*long start = System.currentTimeMillis();
        mergeSort(arrayForTest);
        System.out.println("Time: " + (System.currentTimeMillis() - start));*/
        //Time: 104

        /*long start = System.currentTimeMillis();
        quickSort(arrayForTest, 0, arrayForTest.length - 1);
        System.out.println("Time: " + (System.currentTimeMillis() - start));*/
        //Time: 75


        //long start = System.currentTimeMillis();
        System.out.println("array.contains(98_765) = " + array.contains(98_765));
        //System.out.println("Time: " + (System.currentTimeMillis() - start));
        //Time: 10691
        //System.out.println("array = " + array);

        /*Integer[] arrayForTest = array.toArray();

        long startBubble = System.currentTimeMillis();
        sortBubble(arrayForTest);
        System.out.println("Time: " + (System.currentTimeMillis() - startBubble));*/
        //Time: 76913

        /*Integer[] arrayForTest2 = array.toArray();

        long startSelection = System.currentTimeMillis();
        sortSelection(arrayForTest2);
        System.out.println("arrayForTest2 = " + Arrays.toString(arrayForTest2));
        System.out.println("Time: " + (System.currentTimeMillis() - startSelection));*/
        //Time: 10186

        /*Integer[] arrayForTest3 = array.toArray();

        long startInsertion = System.currentTimeMillis();
        sortInsertion(arrayForTest3);
        System.out.println("Time: " + (System.currentTimeMillis() - startInsertion));*/
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

    public static void quickSort(Integer[] arr, int begin, int end){
        if (begin < end){
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }

    public static void mergeSort(Integer[] arr){
        if (arr.length < 2) {
            return;
        }
        int mid = arr.length / 2;
        Integer[] firstArray = new Integer[mid];
        Integer[] secondArray = new Integer[arr.length - mid];

        for (int i = 0; i < firstArray.length; i++) {
            firstArray[i] = arr[i];
        }

        for (int i = 0; i < secondArray.length; i++) {
            secondArray[i] = arr[mid + i];
        }

        mergeSort(firstArray);
        mergeSort(secondArray);

        merge(arr, firstArray, secondArray);
    }

    private static void merge(Integer[] arr, Integer[] firstArray, Integer[] secondArray){
        int main = 0;
        int left = 0;
        int right = 0;

        while (left < firstArray.length && right < secondArray.length){
            if (firstArray[left] <= secondArray[right]){
                arr[main++] = firstArray[left++];
            } else {
                arr[main++] = secondArray[right++];
            }
        }

        while (left < firstArray.length){
            arr[main++] = firstArray[left++];
        }
        while (right < secondArray.length){
            arr[main++] = secondArray[right++];
        }
    }

    private static int partition(Integer[] arr, int begin, int end){
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot){
                i++;
                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }

    private static void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }


}
