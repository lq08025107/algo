package C12Sorts;

import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] array, int start, int end){
        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, 0, mid);
            mergeSort(array, mid+1, end);
            merge(array, start, mid, end);
        }
    }

    public static void merge(int[] array, int start, int mid, int end) {
        int[] tmp = new int[array.length];
        int i = start, j = mid + 1, k = start;
        while(i != mid+1 && j != end+1) {
            if (array[i] < array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
            }
        }
        while(i != mid + 1){
            tmp[k++] = array[i++];
        }
        while(j != end + 1) {
            tmp[k++] = array[j++];
        }
        for(i = start; i <= end; i++) {
            array[i] = tmp[i];
        }

    }
    public static void main(String[] args){
        int[] array = new int[]{4,5,6,1,2,3};
        mergeSort(array, 0, 5);
        System.out.println(Arrays.toString(array));
    }
}
