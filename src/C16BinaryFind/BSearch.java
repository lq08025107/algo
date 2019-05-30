package C16BinaryFind;

public class BSearch {
    //寻找第一个值等于给定值的元素
    public static int bsearch1(int[] arr, int n, int value) {
        int low = 0;
        int high = n -1;
        while(low <= high) {
            int mid = low + ((high - low) >> 1);
            if(arr[mid] < value) {
                low = mid + 1;
            } else if(arr[mid] > value) {
                high = mid - 1;
            } else {
                if(mid == 0 || arr[mid-1] != value){
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
    //寻找最后一个等于给定值的元素
    public static int bsearch2(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + ((high-low)>>1)/2;
            if(arr[mid] < value) {
                low = mid + 1;
            } else if(arr[mid] > value) {
                high = mid - 1;
            } else {
                if(mid == n -1 || arr[mid + 1] != value){
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return -1;
    }
    //查找第一个大于等于给定值的元素
    public static int bsearch3(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if(arr[mid] < value){
                low = mid + 1;
            } else if(arr[mid]  >= value) {
                if(mid == 0 || arr[mid - 1] < value) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }
    //查找最后一个小于等于给定值的元素
    public static int bsearch4(int[] arr, int n, int value) {
        int low = 0;
        int high = n - 1;
        while(low <= high) {
            int mid = low + ((high - low) / 2);
            if(arr[mid] <= value){
                if(mid == n - 1 || arr[mid + 1] > value) return mid;
                else low = mid + 1;
            } else if(arr[mid]  > value) {
                high = mid - 1;
            }
        }
        return -1;
    }
}
