package C11Sorts;

import java.util.Arrays;

public class Sorts {
    public static void bubbleSort(int[] a, int n) {
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n - i - 1; j++) {
                if(a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }
    public static void insertSort(int[] a, int n) {
        for(int i = 1; i < n; i++) {
            int value = a[i];
            int j = i - 1;
            for(;j >= 0; j--) {
                if(a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j+1] = value;
        }
    }
    public static void selectSort(int[] a, int n) {
        for(int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for(int j = i+1; j < n; j++) {
                if(a[minIndex] > a[j]){
                    minIndex = j;
                }
            }
            int temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    public static void main(String[] args){
        int[] array = new int[]{4,5,6,1,2,3};
        selectSort(array, 6);
        System.out.println(Arrays.toString(array));
    }
}
