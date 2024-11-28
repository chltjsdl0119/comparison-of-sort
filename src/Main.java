import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int n = 100000; // 배열 길이
        int count = 5; // 배열 개수

        ArrayGenerator arrayGenerator = new ArrayGenerator();
        MergeSortDC mergeSortDC = new MergeSortDC(n);
        QuickSortDC quickSortDC = new QuickSortDC();

        // 합병 정렬 시간 측정을 위한 변수
        long mergeSortStartTime;
        long mergeSortEndTime;

        // 퀵 정렬 시간 측정을 위한 변수
        long quickSortStartTime;
        long quickSortEndTime;

        // 합병 정렬과 퀵 정렬 시간의 총합 변수
        long totalMergeSortTime = 0;
        long totalQuickSortTime = 0;

        // 비교를 위한 2차원 배열
        // 여러 개의 1차원 배열을 가진다.
        int[][] arrays1 = arrayGenerator.generateArray(count, n, ArrayType.RANDOM);
        int[][] arrays2 = new int[count][n];

        // arrays2에 arrays1을 복사하는 for 문
        for (int i = 0; i < count; i++) {
            arrays2[i] = Arrays.copyOf(arrays1[i], n);
        }

        // 웜업 실행.
        // 첫 번째 정렬 수행 결과만 유독 높은 시간을 가진다.
        // 첫 번째 정렬 후에야, 최적화 상태가 되기에, 컴파일러가 최적의 상태로 측정을 시작하도록 웜업을 실행한다.
        for (int i = 0; i < 3; i++) {
            int[] warmupArray = arrayGenerator.generateArray(1, n, ArrayType.RANDOM)[0];
            mergeSortDC.mergeSortDC(Arrays.copyOf(warmupArray, n), 0, n - 1);
            quickSortDC.quickSortDC(Arrays.copyOf(warmupArray, n), 0, n - 1);
        }

        System.out.println("n = " + n);
        for (int i = 0; i < count; i++) {
            System.out.println("-----------------------------------");

            System.out.println((i + 1) + "번째 배열 합병 정렬 수행");
            mergeSortStartTime = System.currentTimeMillis();
            mergeSortDC.mergeSortDC(arrays1[i], 0, arrays1[i].length - 1);
            mergeSortEndTime = System.currentTimeMillis();
            totalMergeSortTime += (mergeSortEndTime - mergeSortStartTime);
            System.out.println((i + 1) + "번째 배열 합병 정렬 수행 시간(초): " + (double) (mergeSortEndTime - mergeSortStartTime) / 1000);


            System.out.println((i + 1) + "번째 배열 퀵 정렬 수행");
            quickSortStartTime = System.currentTimeMillis();
            quickSortDC.quickSortDC(arrays2[i], 0, arrays2[i].length - 1);
            quickSortEndTime = System.currentTimeMillis();
            totalQuickSortTime += (quickSortEndTime - quickSortStartTime);
            System.out.println((i + 1) + "번째 배열 퀵 정렬 수행 시간(초): " + (double) (quickSortEndTime - quickSortStartTime) / 1000);

        }

        System.out.println("-----------------------------------");

        double averageMergeSortTime = (double) totalMergeSortTime / count / 1000;
        double averageQuickSortTime = (double) totalQuickSortTime / count / 1000;
        System.out.println("합병 정렬 평균 수행 시간(초): " + averageMergeSortTime);
        System.out.println("퀵 정렬 평균 수행 시간(초): " + averageQuickSortTime);

    }
}