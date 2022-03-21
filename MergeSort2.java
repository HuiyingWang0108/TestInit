public class MergeSort2 {

  public static void mergeSort(int[] data) {
    int n = data.length;
    //步长
    int s = 2;
    int i;
    while (s <= n) {
      i = 0;
      while (i + s <= n) {
        merge(data, i, i + s / 2 - 1, i + s - 1);
        i += s;
      }
      //处理末尾残余部分
      merge(data, i, i + s / 2 - 1, n - 1);
      s *= 2;
    }
    //最后再从头到尾处理一遍
    merge(data, 0, s / 2 - 1, n - 1);
  }

  /**
   * 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
   *
   * @param data   数组对象
   * @param left   左数组的第一个元素的索引
   * @param center 左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
   * @param right  右数组最后一个元素的索引
   */
  public static void merge(int[] data, int left, int center, int right) {
    // 临时数组
    int[] tmpArray = new int[data.length];
    // 右数组第一个元素索引
    int midNew = center + 1;
    // third 记录临时数组的索引
    int third = left;
    // 缓存左数组第一个元素的索引
    int tmp = left;
    while (left <= center && midNew <= right) {
      // 从两个数组中取出最小的放入临时数组
      if (data[left] <= data[midNew]) {
        tmpArray[third++] = data[left++];
      } else {
        tmpArray[third++] = data[midNew++];
      }
    }
    // 剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
    while (midNew <= right) {
      tmpArray[third++] = data[midNew++];
    }
    while (left <= center) {
      tmpArray[third++] = data[left++];
    }
    // 将临时数组中的内容拷贝回原数组中
    // （原left-right范围的内容被复制回原数组）
    while (tmp <= right) {
      data[tmp] = tmpArray[tmp++];
    }
  }

  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  // Driver program
  public static void main(String args[]) {
    int arr[] = {12, 11, 13, 5, 6, 7};
    int n = arr.length;

    MergeSort ob = new MergeSort();
    ob.mergeSort(arr, n);

    System.out.println("Sorted array is");
    printArray(arr);
  }

}