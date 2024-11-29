public class QuickSortDC {

    public QuickSortDC() {}

    /**
     * 교재 내 알고리즘 3.10을 참고하여 구현한 퀵 정렬 메소드.
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

    /**
     * 배열을 분할하여 피벗의 최종 위치를 반환하는 메소드.
     * 피벗보다 작은 요소는 왼쪽으로, 큰 요소는 오른쪽으로 이동시킨다.
     *
     * @param list 분할할 배열
     * @param low 분할 시작 인덱스
     * @param high 분할 끝 인덱스
     * @return 피벗의 최종 위치 인덱스
     */
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
