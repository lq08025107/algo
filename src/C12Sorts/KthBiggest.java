package C12Sorts;

public class KthBiggest {
	public static int KthSmallest(int[] array, int k) {
		if(array == null || array.length < k) {
			return -1;
		}
		int partition = partition(array, 0, array.length - 1);
		while(partition + 1 != k) {
			if(partition + 1 < k) {
				partition = partition(array, partition + 1, array.length -1);
			} else {
				partition = partition(array, 0, partition - 1);
			}
		}
		return array[partition];
	}

	public static int partition(int[] array, int p, int r) {
		int pivot = array[r];

		int i = p;
		for(int j = p; j < r; ++j) {
			if(array[j] <= pivot) {
				int tmp = array[i];
				array[i] = array[j];
				array[j] = tmp;

				i++;
			}
		}
		int tmp = array[i];
		array[i] = array[r];
		array[r] = tmp;
		return i;
	}

	public static void main(String[] args) {
		int[] array = new int[]{4, 10, 1,2,5};
		System.out.println(KthSmallest(array, 3));
	}
}
