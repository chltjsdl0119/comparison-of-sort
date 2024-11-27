public class MergeSortDC {
    int MAX_SIZE;

    public MergeSortDC(int N) {
        MAX_SIZE = N;
    }

    /**
     * 교재 내 알고리즘 3.9를 참고하여 구현한 합병 정렬 메소드.
     * @param list 정렬할 배열
     * @param low 배열 시작 인덱스
     * @param high 배열 마지막 인덱스
     */
    public void mergeSortDC(Integer[] list, int low, int high) {
        int middle;

        if (low < high) {
            middle = (low + high) / 2;
            mergeSortDC(list, low, middle);
            mergeSortDC(list, middle + 1, high);
            merge(list, low, middle, high);
        }
    }

    private void merge(Integer[] list, int low, int mid, int high) {
        int n1 = low, n2 = mid + 1, s = low, i;
        Integer[] sorted = new Integer[MAX_SIZE]; // 배열의 길이로 설정.

        while (n1 <= mid && n2 <= high) {
            if (list[n1] <= list[n2]) {
                sorted[s++] = list[n1++];
            } else {
                sorted[s++] = list[n2++];
            }
        }

        if (n1 > mid) {
            while (n2 <= high) {
                sorted[s++] = list[n2++];
            }
        } else {
            while (n1 <= mid) {
                sorted[s++] = list[n1++];
            }
        }

        for (i = low; i <= high; i++) {
            list[i] = sorted[i];
        }
    }
}
