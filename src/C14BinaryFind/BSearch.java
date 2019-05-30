package C14BinaryFind;

public class BSearch {

    public static int bsearch(int[] array, int n, int value) {
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            //int mid = (low + high) / 2;
            int mid = low + ((high-low)>>1);
            if(array[mid] == value) {
                return mid;
            } else if(array[mid] < value) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
