package DividenConquer;
public class DividenConquer {

    // -----------Merge_Sort--------------

    public static void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        // kaam
        int mid = si + (ei - si) / 2; // (si+ei)/2
        mergeSort(arr, si, mid); // left part
        mergeSort(arr, mid + 1, ei); // right part
        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // -iterator- for left part
        int j = mid + 1; // -iterator- for right part
        int k = 0; // -iterator- for temp Arr

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++; // k++ ;
            } else {
                temp[k] = arr[j];
                j++; // k++ ;
            }
            k++;
        }
        // Copy remaining elements of the left part
        while (i <= mid) {
            temp[k++] = arr[i++]; // urinary operator [post-increment: prints, then increases]
        }

        // Copy remaining elements of the right part
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // Copy temp array back to original array
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }

    // --------------Quick_Sort--------------

    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void quickSort(int arr[], int si, int ei) {
        if (si >= ei) { // base case
            return;
        }

        // last element
        int pIdx = partition(arr, si, ei);
        quickSort(arr, si, pIdx - 1); // Sort left part
        quickSort(arr, pIdx + 1, ei); // Sort right part
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei]; // Last element as pivot
        int i = si - 1; // to make place for elms smaller than pivot

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) { // Swap if element is smaller than pivot
                i++;
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
        i++;
        // Place the pivot at the correct sorted position
        int temp = arr[i];
        arr[i] = arr[ei];
        arr[ei] = temp;

        return i;
    }

    // ----Search in Rotated (Sorted) Array----

    public static int search(int arr[], int tar, int si, int ei) {
        if(si>ei){
            return -1;
        }
        // kaam
        int mid = si + (ei - si) / 2;
        // Case Found
        if (arr[mid] == tar) {
            return mid;
        }

        // mid on L1
        if (arr[si] <= arr[mid]) {
            // case a : left
            if (arr[si] <= tar && tar <= arr[mid]) {
                return search(arr, tar, si, mid - 1);
            } else {
                // case b: right
                return search(arr, tar, mid + 1, ei);
            }

        }
        // mid on L2
        else {
            // case c : right
            if (arr[mid] <= tar && tar <= arr[ei]) {
                return search(arr, tar, mid + 1, ei);
            } else {
                // case d: left
                return search(arr, tar, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {

        // // --Merge_Sort--
        // int arr[] = { 6, 3, 9, 5, 2, 8 };
        // System.out.println("Original Array:");
        // printArray(arr);

        // mergeSort(arr, 0, arr.length - 1);

        // System.out.println("Sorted Array:");
        // printArray(arr);

        // // --Quick_Sort--
        // int arr[] = { 6, 3, 9, 8, 2, 5 };

        // System.out.println("Original Array:");
        // printArr(arr);
        // quickSort(arr, 0, arr.length - 1);

        // System.out.println("Sorted Array:");
        // printArr(arr);

        //Rotated (Sorted) Array
        int arr[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0; // OUTPUT: 4
        int tarIdx = search(arr, target, 0, arr.length-1);
        System.out.println(tarIdx);
          
    }
}
