package pro.sky.java.course2.homework;

import pro.sky.java.course2.homework.exception.IllegalIndexException;
import pro.sky.java.course2.homework.exception.ObjectIsNullException;

import java.util.Arrays;
import java.util.StringJoiner;

public class MyListImpl implements StringList{
    private static final int INIT_SIZE = 4;
    private static final int CUT_POINTER = 2;
    private String[] arrays;
    private static int pointer = 0;

    public MyListImpl(){
        this.arrays = new String[INIT_SIZE];
    }

    @Override
    public String add(String item) {
        if (pointer == arrays.length - 1){
            resize(arrays.length * 2);
        }
        arrays[pointer++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (pointer == arrays.length - 1){
            resize(arrays.length * 2);
        }

        if (index == arrays.length - 1){
            return add(item);
        }

        if (checkIndex(index)){
            for (int i = 0; i < pointer; i++){
                if (i == index) {
                    System.arraycopy(arrays, index, arrays,  index + 1, arrays.length - index);
                    arrays[index] = item;
                    break;
                }
            }
            pointer++;
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (checkIndex(index)){
            arrays[index] = item;
        }
        return item;
    }

    @Override
    public String remove(String item) {
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
    public String remove(int index) {
        String removedItem = get(index);

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
    public boolean contains(String item) {
        for (int i = 0; i < pointer; i++) {
            if (arrays[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < pointer; i++) {
            if (arrays[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = pointer - 1; i >= 0; i--){
            if (arrays[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        checkIndex(index);
        return arrays[index];
    }

    @Override
    public boolean equals(StringList otherList) {
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
        arrays = new String[INIT_SIZE];
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(arrays, arrays.length);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", MyListImpl.class.getSimpleName() + "", "")
                .add(Arrays.toString(arrays))
                .toString();
    }

    private void resize(int newLength){
        String[] newArrays = new String[newLength];
        System.arraycopy(arrays, 0, newArrays, 0, pointer);
        arrays = newArrays;
    }

    private boolean checkIndex(int index){
        if (index < 0 || index >= pointer){
            throw new IllegalIndexException("Invalid value " + index);
        }
        return true;
    }
}
