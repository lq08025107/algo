package C12Sorts;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array, int start, int end) {
        if(start >= end) return;
        int i = partition(array, start, end);
        quickSort(array, start, i - 1);
        quickSort(array, i+1, end);
    }

    public static int partition(int[] array, int left, int right) {
        int i, j, x;
        i = left;
        j = right;
        x = array[left];
        while(i < j) {
            while(array[j] >= x && i < j){
                j--;
            }
            if(i < j){
                array[i] = array[j];
                i++;
            }
            while(array[i] < x && i < j) {
                i++;
            }
            if(i < j) {
                array[j] = array[i];
                j--;
            }
        }
        array[i] = x;
        return i;
    }
    public static void main(String[] args){
        int[] array = new int[]{4,5,6,1,2,3};
        quickSort(array, 0, 5);
        System.out.println(Arrays.toString(array));
    }
}
