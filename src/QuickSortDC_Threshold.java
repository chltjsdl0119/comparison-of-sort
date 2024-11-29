public class QuickSortDC_Threshold extends QuickSortDC{

    /**
     * 퀵 정렬과 삽입 정렬을 임계값에 따라 혼합한 메소드.
     * @param list 정렬할 배열
     * @param low 배열 시작 인덱스
     * @param high 배열 마지막 인덱스
     * @param threshold 임계값
     */
    void quickSortDC(int[] list, int low, int high, int threshold) {
        if (high - low + 1 <= threshold) {
            insertionSort(list, high + 1);
        } else {
            if (low < high) {
                int pivotPos = partition(list, low, high);
                quickSortDC(list, low, pivotPos - 1, threshold);
                quickSortDC(list, pivotPos + 1, high, threshold);
            }
        }
    }

    /**
     * quickSortDC(int[] list, int low, int high, int threshold)에서 임계값 이하일 때, 실행할 삽입 정렬 메소드.
     * 교재 내, 알고리즘 6.1을 참고하여 구현.
     * @param list 정렬할 배열
     * @param n 배열의 길이
     */
    private void insertionSort(int[] list, int n) {
        int i, j, next;
        for (i = 1; i < n; i++) {
            next = list[i];
            for (j = i - 1; j >= 0 && next < list[j]; j--) {
                list[j + 1] = list[j];
            }
            list[j + 1] = next;
        }
    }
}
