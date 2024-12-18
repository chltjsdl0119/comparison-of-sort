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
    public void mergeSortDC(int[] list, int low, int high) {
        int middle;

        if (low < high) {
            middle = (low + high) / 2;
            mergeSortDC(list, low, middle);
            mergeSortDC(list, middle + 1, high);
            merge(list, low, middle, high);
        }
    }


    /**
     * 두 부분 배열을 병합하여 정렬하는 메소드.
     * @param list 정렬할 배열
     * @param low 첫 번째 부분 배열의 시작 인덱스
     * @param mid 첫 번째 부분 배열의 끝 인덱스 (두 번째 부분 배열 시작 인덱스는 mid + 1)
     * @param high 두 번째 부분 배열의 끝 인덱스
     */
    private void merge(int[] list, int low, int mid, int high) {
        int n1 = low, n2 = mid + 1, s = low, i;
        Integer[] sorted = new Integer[MAX_SIZE]; // 배열의 길이 n으로 설정. MAX_SIZE는 객체화될 때 값을 가진다.

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
