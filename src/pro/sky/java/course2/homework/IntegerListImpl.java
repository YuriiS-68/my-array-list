package pro.sky.java.course2.homework;

import pro.sky.java.course2.homework.exception.IllegalIndexException;
import pro.sky.java.course2.homework.exception.ObjectIsNullException;

import java.util.Arrays;
import java.util.Random;
import java.util.StringJoiner;

public class IntegerListImpl implements IntegerList{
    private static final int INIT_SIZE = 100_000;
    private static final int CUT_POINTER = 50_000;
    private Integer[] arrays;
    private static int pointer = 0;

    public IntegerListImpl(){
        this.arrays = new Integer[INIT_SIZE];
        generateRandomArray();
    }

    @Override
    public Integer add(Integer item) {
        if (pointer == arrays.length - 1){
            resize(arrays.length * 2);
        }
        arrays[pointer++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if (item == null){
            throw new ObjectIsNullException("Object is null");
        }
        checkIndex(index);
        if (pointer == arrays.length - 1){
            resize(arrays.length * 2);
        }

        System.arraycopy(arrays, index, arrays,  index + 1, arrays.length - index - 1);
        arrays[index] = item;
        pointer++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        if (checkIndex(index)){
            arrays[index] = item;
        }
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        int indexDelete = -1;

        for (int i = 0; i < pointer; i++){
            if (arrays[i].equals(item)){
                indexDelete = i;
                break;
            }
        }

        if (indexDelete == -1){
            throw new ObjectIsNullException("Object is null");
        }
        remove(indexDelete);
        return item;
    }

    @Override
    public Integer remove(int index) {
        Integer removedItem = get(index);

        for (int i = index; i < pointer; i++){
            arrays[i] = arrays[i + 1];
            arrays[pointer] = null;
        }
        pointer--;
        if (arrays.length > INIT_SIZE && pointer < arrays.length / CUT_POINTER){
            resize(arrays.length / 2);
        }
        return removedItem;
    }

    @Override
    public boolean contains(Integer item) {
        Integer[] arraysSearchItems = Arrays.copyOf(arrays, arrays.length);
        return binarySearch(sortSelection(arraysSearchItems), item);
    }

    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < pointer; i++) {
            if (arrays[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
        for (int i = pointer - 1; i >= 0; i--){
            if (arrays[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Integer get(int index) {
        checkIndex(index);
        return arrays[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null){
            return false;
        }
        if (pointer != otherList.size()){
            return false;
        }

        for (int i = 0; i < pointer; i++) {
            if (!get(i).equals(otherList.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return pointer;
    }

    @Override
    public boolean isEmpty() {
        return pointer == 0;
    }

    @Override
    public void clear() {
        arrays = new Integer[INIT_SIZE];
    }

    @Override
    public Integer[] toArray() {
        return Arrays.copyOf(arrays, arrays.length);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MyListImpl.class.getSimpleName() + "", "")
                .add(Arrays.toString(arrays))
                .toString();
    }


    private void resize(int newLength){
        Integer[] newArrays = new Integer[newLength];
        System.arraycopy(arrays, 0, newArrays, 0, pointer);
        arrays = newArrays;
    }

    private void generateRandomArray()  {
        Random random = new Random();

        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = random.nextInt(100_000);
        }
    }

    private Integer[] sortSelection(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
        return arr;
    }

    private void swapElements(Integer[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }

    private boolean binarySearch(Integer[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    private boolean checkIndex(int index){
        if (index < 0 || index >= pointer){
            throw new IllegalIndexException("Invalid value " + index);
        }
        return true;
    }
}
