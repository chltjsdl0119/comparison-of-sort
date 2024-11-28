public class QuickSortDC {

    public QuickSortDC() {}

    /**
     * 교재 내 알고리즘 3.10를 참고하여 구현한 퀵 정렬 메소드.
     * @param list 정렬할 배열
     * @param low 배열 시작 인덱스
     * @param high 배열 마지막 인덱스
     */
    void quickSortDC(int[] list, int low, int high) {
        int pivotPos;
        if (low < high) {
            pivotPos = partition(list, low, high);
            quickSortDC(list, low, pivotPos - 1);
            quickSortDC(list, pivotPos + 1, high);
        }
    }

    int partition(int[] list, int low, int high) {
        int i, j = low;

        for (i = low + 1; i <= high; i++) {
            if (list[i] < list[low]) {
                j++;
                swap(list, i, j);
            }
        }

        swap(list, low, j);

        return j;
    }

    private void swap(int[] list, int index1, int index2) {
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }
}
