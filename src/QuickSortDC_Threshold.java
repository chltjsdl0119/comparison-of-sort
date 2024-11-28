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
            insertionSort(list, low, high);  // 삽입 정렬 호출
        } else {
            if (low < high) {
                int pivotPos = partition(list, low, high);
                quickSortDC(list, low, pivotPos - 1, threshold);
                quickSortDC(list, pivotPos + 1, high, threshold);
            }
        }
    }

    // 삽입 정렬 메서드 추가
    private void insertionSort(int[] list, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = list[i];
            int j = i - 1;
            while (j >= low && list[j] > key) {
                list[j + 1] = list[j];
                j--;
            }
            list[j + 1] = key;
        }
    }
}
