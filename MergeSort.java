public class MergeSort
{
  public static void mergeSort(int[] a, int n) {
    if (n < 2) {
      return;
    }
    int mid = (n + 1) / 2;
    int[] l = new int[mid];
    int[] r = new int[n - mid];

    for (int i = 0; i < mid; i++) {
      l[i] = a[i];
    }
    for (int i = mid; i < n; i++) {
      r[i - mid] = a[i];
    }
    mergeSort(l, mid);
    mergeSort(r, n - mid);

    merge(a, l, r, mid, n - mid);
  }
  public static void merge(
      int[] a, int[] l, int[] r, int left, int right) {

    int i = 0, j = 0, k = 0;
    while (i < left && j < right) {
      if (l[i] <= r[j]) {
        a[k++] = l[i++];
      }
      else {
        a[k++] = r[j++];
      }
    }
    while (i < left) {
      a[k++] = l[i++];
    }
    while (j < right) {
      a[k++] = r[j++];
    }
  }

  static void printArray(int arr[])
  {
    int n = arr.length;
    for (int i=0; i<n; ++i)
      System.out.print(arr[i]+" ");
    System.out.println();
  }

  // Driver program
  public static void main(String args[])
  {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int n = arr.length;

    MergeSort ob = new MergeSort();
    ob.mergeSort(arr, n);

    System.out.println("Sorted array is");
    printArray(arr);
  }

}