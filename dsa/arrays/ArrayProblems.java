package adee.samples.dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class ArrayProblems {

	public static void shiftZerosEnd() {
		int a[] = { 1, 2, 0, 4, 3, 0, 5, 0 };
		int c = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				a[c++] = a[i];
			}
		}
		while (c < a.length) {
			a[c++] = 0;
		}
		printArr(a);
	}

	public static int[] swapNegativeNumbersToLeft(int[] a) {
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 0) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				j++;
			}
		}
		return a;
	}

	public static void missingNumber() {
		int a[] = { 1, 2, 4, 6, 3, 7, 8 };
		int n = a.length;
		int sum = (n + 1) * (n + 2) / 2;
		for (int i = 0; i < n; i++) {
			sum = sum - a[i];
		}
		System.out.println("Missing number is " + sum);
	}

	public static int missingNumberSortedArray() {
		int a[] = { 0, 1, 3, 4, 5, 6, 7, 8 };
		int low = 0;
		int high = a.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] != mid) {
				if (a[mid - 1] == (mid - 1)) {
					return mid;
				}
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}

	/*
	 * swap negative numbers to one side iterate through the array , mark the
	 * presence of a number x by making the value at index negative first positive
	 * number index + 1
	 */
	public static void missingSmallestPositive() {
		int a[] = { 1, 2, -7, 6, 3, 1, -5, 5 };
		a = swapNegativeNumbersToLeft(a);
		for (int i = 0; i < a.length; i++) {
			int x = Math.abs(a[i]);
			if ((x - 1) < a.length && a[x - 1] > 0) {
				a[x - 1] = -a[x - 1];
			}
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				System.out.println(i + 1);
				return;
			}
		}
	}

	public static void pairElementsEqualToSum() {
		int arr[] = { 1, 4, 45, 6, 10, -8 };
		int sum = 16;
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			int temp = sum - arr[i];
			if (temp >= 0 && s.contains(temp)) {
				System.out.println("Pair with given sum " + sum + " is (" + arr[i] + ", " + temp + ")");
			}
			s.add(arr[i]);
		}
	}

	public static void pairElementsEqualToDifference() {
		int arr[] = { 5, 20, 3, 2, 50, 80 };
		int diff = 78;
		HashSet<Integer> s = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			s.add(arr[i]);
		}
		for (int i = 0; i < arr.length; i++) {
			if (s.contains(diff + arr[i])) {
				System.out.println("Pair with given diff " + diff + " is " + arr[i] + ", " + (diff + arr[i]));
			}
		}
	}

	public static void sort012() {
		int a[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int c0 = 0, c1 = 0, c2 = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == 0) {
				c0++;
			} else if (a[i] == 1) {
				c1++;
			} else if (a[i] == 2) {
				c2++;
			}
		}
		int i = 0, j = 0;
		while (j < a.length) {
			while (i++ < c0) {
				a[j++] = 0;
			}
			i = 0;
			while (i++ < c1) {
				a[j++] = 1;
			}
			i = 0;
			while (i++ < c2) {
				a[j++] = 2;
			}
		}
		printArr(a);
	}

	public static void subArraySum() {

	}

	public static void removeDuplicatedSortedArray() {
		int a[] = { 1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 7, 9 };
		int j = 1;
		for (int i = 0; i < a.length - 1; i++) {
			if (a[i] != a[i + 1]) {
				a[j++] = a[i + 1];
			}
		}
		for (int i = j; i < a.length; i++) {
			a[i] = 0;
		}
		printArr(a);
	}

	public static void minDistance() {
		int a[] = { 3, 5, 3, 4, 2, 6, 5, 5, 3, 1, 6, 3, 6 };
		int dist = Integer.MAX_VALUE;
		int x = 3;
		int y = 6;
		int l = 0, r = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				l = i;
			}
			if (a[i] == y) {
				r = i;
			}
			if (r > l && ((r - l) < dist)) {
				dist = r - l;
			}
		}
		System.out.println(dist);
	}

	public static void reverse() {
		int a[] = { 1, 2, 3, 4, 5, 6, 7 };
		int start = 0;
		int end = a.length - 1;
		while (start < end) {
			int temp = a[end];
			a[end] = a[start];
			a[start] = temp;
			start++;
			end--;
		}
		printArr(a);
	}

	public static void bucketSort() {
		int a[] = { 9, 1, 30000, 3, 45, 8, 4, 2, 7, 10000 };
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max)
				max = a[i];
		}
		int bucket[] = new int[max];
		for (int i : a) {
			bucket[i - 1] = 1;
		}
		int j = 0;
		for (int i = 0; i < bucket.length; i++) {
			if (bucket[i] == 1) {
				a[j++] = i + 1;
			}
		}
		printArr(a);
	}

	int FindMaxSum(int n) {
		int arr[] = new int[] { 5, 5, 10, 100, 10, 5 };
		int incl = arr[0];
		int excl = 0;
		int excl_new;
		int i;

		for (i = 1; i < n; i++) {
			/* current max excluding i */
			excl_new = (incl > excl) ? incl : excl;

			/* current max including i */
			incl = excl + arr[i];
			excl = excl_new;
		}

		/* return max of incl and excl */
		return ((incl > excl) ? incl : excl);
	}

	public static void stringWithFrequency() {
		String x = "geeksForgeeks";
		int[] freq = new int[52];
		for (int i = 0; i < x.length(); i++) {
			int index = Math.abs(x.charAt(i) - 'a');
			freq[index] = freq[index] + 1;
		}
		for (int i = 0; i < x.length(); i++) {
			int index = Math.abs(x.charAt(i) - 'a');
			if (freq[index] != 0) {
				System.out.print(x.charAt(i));
				System.out.print(freq[Math.abs(x.charAt(i) - 'a')]);
				freq[Math.abs(x.charAt(i) - 'a')] = 0;
			}
		}
	}

	public static void shiftSpacesToBeg() {
		String x = "geeks For geeks";
		int i = x.length();
		char str[] = x.toCharArray();
		for (int j = i - 1; j >= 0; j--)
			if (str[j] != ' ') {
				str[--i] = str[j];
			}
		while (i > 0)
			str[--i] = ' ';
		System.out.println(new String(str));
	}

	/*
	 * max sum in a contiguous sub-array
	 */
	public static void kadeneAlgo() {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		int cur_max = a[0], max_so_far = a[0];
		for (int i = 1; i < a.length - 1; i++) {
			cur_max = Math.max(a[i], cur_max + a[i]);
			max_so_far = Math.max(cur_max, max_so_far);
		}
		System.out.println("Max Sum Sub-Array = " + max_so_far);
	}

	public static void unionArrays() {
		int[] a = { 1, 3, 4, 5, 7 };
		int[] b = { 2, 3, 5, 6 };
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				System.out.println(a[i]);
				i++;
			} else if (b[j] < a[i]) {
				System.out.println(b[j]);
				j++;
			} else {
				System.out.println(a[i]);
				i++;
				j++;
			}
		}
		while (i < a.length) {
			System.out.println(a[i]);
			i++;
		}
		while (j < b.length) {
			System.out.println(b[i]);
			j++;
		}
	}

	public static void peakElement() {
		int arr[] = { 10, 15, 18, 24, 28, 21 };
		peakElement(arr, 0, arr.length - 1);
	}

	private static void peakElement(int a[], int low, int high) {
		int mid = (low + high) / 2;
		if (mid == 0 || (a[mid] >= a[mid - 1]) && (mid == a.length - 1 || a[mid] > a[mid + 1])) {
			System.out.println("Peak Element - " + a[mid]);
			return;
		}
		if (a[mid - 1] > a[mid]) {
			peakElement(a, low, mid - 1);
		} else {
			peakElement(a, mid + 1, high);
		}
	}

	public static void localMaxima() {
		int arr[] = { 9, 6, 3, 14, 5, 7, 4 };
		localMaxima(arr, 0, arr.length - 1);
	}

	private static void localMaxima(int a[], int low, int high) {
		System.out.println("low = " + low + " high = " + high);
		int mid = (low + high) / 2;
		System.out.println(a[low] + " " + a[high] + " " + a[mid]);
		if (mid == 0 || (a[mid] <= a[mid - 1]) && (mid == a.length - 1 || a[mid] < a[mid + 1])) {
			System.out.println("Local Maxima Element - " + a[mid]);
			return;
		}
		if (a[mid] > a[mid - 1]) {
			localMaxima(a, low, mid - 1);
		} else {
			localMaxima(a, mid + 1, high);
		}
	}

	public static void findMajority() {
		int a[] = { 2, 2, 2, 2, 5, 5, 2, 3, 3 };
		Map<Integer, Integer> ct = new HashMap<>();
		for (int i = 0; i < a.length; i++) {
			if (ct.containsKey(a[i])) {
				int cnt = ct.get(a[i]);
				cnt++;
				ct.put(a[i], cnt);
				if (cnt > a.length / 2) {
					System.out.println(a[i]);
				}
			} else {
				ct.put(a[i], 1);
			}
		}
	}

	public static void intersectionArrays() {
		int[] a = { 1, 3, 4, 5, 7 };
		int[] b = { 2, 3, 5, 6 };
		int i = 0;
		int j = 0;
		while (i < a.length && j < b.length) {
			if (a[i] < b[j]) {
				i++;
			} else if (b[j] < a[i]) {
				j++;
			} else {
				System.out.println(a[i]);
				i++;
				j++;
			}
		}
	}

	public static void leadersInArray() {
		int a[] = { 6, 7, 4, 3, 5, 2 };
		int max = a[a.length - 1];
		System.out.println(max);
		for (int i = a.length - 2; i >= 0; i--) {
			if (a[i] > max) {
				System.out.println(a[i]);
				max = a[i];
			}
		}
	}

	public static void singleOccuranceInDupeArray() {
		// TODO
		int a[] = { 1, 1, 1, 4, 4, 5, 6, 5, 4, 3, 2, 3, 4, 6, 7, 8, 9, 11, 8, 7, 6, 5, 6, 7, 8, 4 };
		int ans = a[0];
		for (int i = 1; i < a.length; i++) {
			ans = ans ^ a[i];
		}
		System.out.println(ans);
	}

	public static void rotationCountSortedRotatedArr() {
		int a[] = { 15, 18, 2, 3, 6, 12 };
		int min = a[0];
		int m_i = 0;
		for (int i = 1; i < a.length; i++) {
			if (min > a[i]) {
				min = a[i];
				m_i = i;
			}
		}
		System.out.println(m_i);
	}

	// TODO
	public static void findMinElementInRotatedSortedArr() {

	}

	// TODO
	public static void kthLargestSmallestElement() {
		// heap
	}

	// TODO
	public static void mergeTwoSortedArrays() {
		// heap
	}

	public static void elementsSumClosestZero() {
		int a[] = { 15, 5, -20, 30, -45 };
		Arrays.sort(a);
		int i = 0, j = a.length - 1;
		int m_i = i, m_j = j;
		int min_sum = Integer.MAX_VALUE;
		while (i < j) {
			int sum = a[i] + a[j];
			if (Math.abs(sum) < Math.abs(min_sum)) {
				m_i = i;
				m_j = j;
				min_sum = sum;
			}
			if (sum < 0) {
				i++;
			}
			if (sum > 0) {
				j--;
			}
		}
		System.out.println("closest  sum = " + min_sum + " @ " + m_i + " and " + m_j);
	}

	public static void nextGreaterElement() {
		// TODO
	}

	public static void longestCommonSubsequence() {
		char[] X = "AGGTAB".toCharArray();
		char[] Y = "GXTXAYB".toCharArray();
		int sum = lcs(X, Y, X.length, Y.length);
		System.out.println(sum);
	}

	public static void rotateArr(int k) {
		int a[] = { 6, 5, 4, 3, 2, 7, 8, 9, 1 };
		printArr(a);
		System.out.println();
		int i = 1;
		while (i++ < k) {
			a = rortateByOne(a);
		}
		printArr(a);
	}

	public static int[] rortateByOne(int[] a) {
		int temp = a[0];
		for (int i = 0; i < a.length - 1; i++) {
			a[i] = a[i + 1];
		}
		a[a.length - 1] = temp;
		return a;
	}

	public static void mergeSortedArrays() {
		int[] a1 = { 1, 3, 4, 5, 11, 17, 18 };
		int[] a2 = { 2, 4, 6, 7, 8 };
		printArr(a1);
		System.out.println();
		printArr(a2);
		System.out.println();
		int[] a3 = new int[a1.length + a2.length];
		int i = 0, j = 0, k = 0;
		while (i < a1.length && j < a2.length) {
			if (a1[i] < a2[j]) {
				a3[k++] = a1[i++];
			} else {
				a3[k++] = a2[j++];
			}
		}
		while (i < a1.length) {
			a3[k++] = a1[i++];
		}
		while (j < a2.length) {
			a3[k++] = a1[j++];
		}
		printArr(a3);
	}

	public static void quicksort(int a[], int l, int h) {
		if (l < h) {
			int p = partition(a, l, h);
			System.out.println(p);
			quicksort(a, l, p - 1);
			quicksort(a, p + 1, h);
		}
	}

	private static int partition(int a[], int low, int high) {
		int i = low - 1;
		int j = low;
		int pivot = a[high];
		for (j = low; j <= high - 1; j++) {
			if (a[j] <= pivot) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		int temp = pivot;
		a[high] = a[i + 1];
		a[i + 1] = temp;
		return (i + 1);
	}

	private static int lcs(char[] x, char[] y, int xLen, int yLen) {
		if (xLen == 0 || yLen == 0) {
			return 0;
		}
		if (x[xLen - 1] == y[yLen - 1]) {
			return 1 + lcs(x, y, xLen - 1, yLen - 1);
		} else {
			return Math.max(lcs(x, y, xLen, yLen - 1), lcs(x, y, xLen - 1, yLen));
		}
	}

	static void printArr(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	static class HeapSort {
		public static void heapSort(int a[]) {
			int n = a.length;
			for (int i = 1; i < a.length; i++) {
				createHeap(a, i);
			}
			for (int i = n - 1; i > 0; i--) {
				int temp = a[0];
				a[0] = a[i];
				a[i] = temp;
				heapify(a, i, 0);
			}
			printArr(a);
		}

		public static void createHeap(int a[], int index) {
			if (index > 0) {
				int parent = (index - 1) / 2;
				if (a[index] > a[parent]) {
					int temp = a[parent];
					a[parent] = a[index];
					a[index] = temp;
					createHeap(a, parent);
				}
			}
		}

		private static void heapify(int a[], int rootIndex, int lastIndex) {
			int largest = lastIndex;
			int l = 2 * lastIndex + 1;
			int r = 2 * lastIndex + 2;
			if (l < rootIndex && a[l] > a[largest]) {
				largest = l;
			}
			if (r < rootIndex && a[r] > a[largest]) {
				largest = r;
			}
			if (largest != lastIndex) {
				int swap = a[largest];
				a[largest] = a[lastIndex];
				a[lastIndex] = swap;
				heapify(a, rootIndex, largest);
			}
		}
	}
}