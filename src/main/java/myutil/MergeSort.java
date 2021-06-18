package myutil;

public class MergeSort {

    public void mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return;

        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    public void merge(int[] arr, int start, int mid, int end) {
        int[] sortedArr = new int[end - start + 1];
        int sortedIdx = 0, leftArrIdx = start, rightArrIdx = mid + 1;
        while (sortedIdx < sortedArr.length) {
            if (leftArrIdx > mid) {
                for (int i = sortedIdx; i < sortedArr.length; i++)
                    sortedArr[i] = arr[rightArrIdx++];
                break;
            } else if (rightArrIdx > end) {
                for (int i = sortedIdx; i < sortedArr.length; i++)
                    sortedArr[i] = arr[leftArrIdx++];
                break;
            }

            sortedArr[sortedIdx++] = arr[leftArrIdx] <= arr[rightArrIdx] ?
                    arr[leftArrIdx++] : arr[rightArrIdx++];
        }

        for (int i = start; i <= end; i++)
            arr[i] = sortedArr[i - start];
    }
}
