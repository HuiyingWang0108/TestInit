public class MergeSort3
{
  public static void mergeSort(int[] arr) {
    int n = arr.length;
    int window;
    for(window = 2; window < n; window *=2){
      for(int i = 0; i < n; i += window){
        int begin = i;
        int end = i + window;
        int mid = i + window/2;
        if(end < n){
          mSort(arr, begin, mid, end);
        }else if(mid < n) {
          mSort(arr, begin, mid, n);
        }
      }
    }
    mSort(arr, 0, window / 2, n);
  }

  public static void  mSort(int[] arr, int begin, int mid, int end){
    int[] l = new int[mid -begin];
    //int[] r = new int[end -mid];
    int i = 0, j = mid, k = begin;

    for (int m = begin; m < mid; m++) {
      l[i++] = arr[m];
    }
    //for (int m = mid; m < end; m++) {
    //  r[j++] = arr[m];
    //}
    i = 0;
    //j = 0;
    while (i < mid-begin && j < end){
      if(l[i] < arr[j]){
        arr[k++] = l[i++];
      }else {
        arr[k++] = arr[j++];
      }
    }
    while (i < mid-begin){
      arr[k++] = l[i++];
    }
    //while (j < end-mid){
    //  arr[k++] = r[j++];
    //}
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
    int arr[] = {12, 11, 13, 5, 6, 7, 4, 3, 2};

    MergeSort3 ob = new MergeSort3();
    ob.mergeSort(arr);

    System.out.println("Sorted array is");
    printArray(arr);
  }

}