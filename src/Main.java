import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        // --------------------------------------------------------------------------------
        // 정렬 비교 테스트
//
//        int n = 1000000; // 배열 길이
//        int testCount = 5; // 배열 개수
//
//        ArrayGenerator arrayGenerator = new ArrayGenerator();
//        MergeSortDC mergeSortDC = new MergeSortDC(n);
//        QuickSortDC quickSortDC = new QuickSortDC();
//
//        // 합병 정렬 시간 측정을 위한 변수
//        long mergeSortStartTime;
//        long mergeSortEndTime;
//
//        // 퀵 정렬 시간 측정을 위한 변수
//        long quickSortStartTime;
//        long quickSortEndTime;
//
//        // 합병 정렬과 퀵 정렬 시간의 총합 변수
//        long totalMergeSortTime = 0;
//        long totalQuickSortTime = 0;
//
//        // 비교를 위한 2차원 배열
//        // 여러 개의 1차원 배열을 가진다.
//        int[][] arrays1 = arrayGenerator.generateArray(testCount, n, ArrayType.RANDOM);
//        int[][] arrays2 = new int[testCount][n];
//
//        // arrays2에 arrays1을 복사하는 for 문
//        for (int i = 0; i < testCount; i++) {
//            arrays2[i] = Arrays.copyOf(arrays1[i], n);
//        }
//
//        // 웜업 실행.
//        // 첫 번째 정렬 수행 결과만 유독 높은 시간을 가진다.
//        // 첫 번째 정렬 후에야, 최적화 상태가 되기에, 컴파일러가 최적의 상태로 측정을 시작하도록 웜업을 실행한다.
//        for (int i = 0; i < 3; i++) {
//            int[] warmupArray = arrayGenerator.generateArray(1, n, ArrayType.RANDOM)[0];
//            mergeSortDC.mergeSortDC(Arrays.copyOf(warmupArray, n), 0, n - 1);
//            quickSortDC.quickSortDC(Arrays.copyOf(warmupArray, n), 0, n - 1);
//        }
//
//        System.out.println("n = " + n);
//        for (int i = 0; i < testCount; i++) {
//            System.out.println("-----------------------------------");
//
//            System.out.println((i + 1) + "번째 배열 합병 정렬 수행");
//            mergeSortStartTime = System.currentTimeMillis();
//            mergeSortDC.mergeSortDC(arrays1[i], 0, arrays1[i].length - 1);
//            mergeSortEndTime = System.currentTimeMillis();
//            totalMergeSortTime += (mergeSortEndTime - mergeSortStartTime);
//            System.out.println((i + 1) + "번째 배열 합병 정렬 수행 시간(초): " + (double) (mergeSortEndTime - mergeSortStartTime) / 1000);
//
//
//            System.out.println((i + 1) + "번째 배열 퀵 정렬 수행");
//            quickSortStartTime = System.currentTimeMillis();
//            quickSortDC.quickSortDC(arrays2[i], 0, arrays2[i].length - 1);
//            quickSortEndTime = System.currentTimeMillis();
//            totalQuickSortTime += (quickSortEndTime - quickSortStartTime);
//            System.out.println((i + 1) + "번째 배열 퀵 정렬 수행 시간(초): " + (double) (quickSortEndTime - quickSortStartTime) / 1000);
//
//        }
//
//        System.out.println("-----------------------------------");
//
//        double averageMergeSortTime = (double) totalMergeSortTime / testCount / 1000;
//        double averageQuickSortTime = (double) totalQuickSortTime / testCount / 1000;
//        System.out.println("합병 정렬 평균 수행 시간(초): " + averageMergeSortTime);
//        System.out.println("퀵 정렬 평균 수행 시간(초): " + averageQuickSortTime);

        // --------------------------------------------------------------------------------
        // Threshold 테스트

        int n = 100000; // 데이터 크기 설정
        int thresholdMax = 2000; // 임계값 최대 범위
        int testCount = 5; // 동일한 임계값에 대해 여러 번 실행하여 평균을 구함

        QuickSortDC_Threshold quickWithThreshold = new QuickSortDC_Threshold();
        ArrayGenerator arrayGenerator = new ArrayGenerator();
        int[][] arrays3 = arrayGenerator.generateArray(testCount, n, ArrayType.RANDOM);

        // 웜업 실행.
        // 첫 번째 정렬 수행 결과만 유독 높은 시간을 가진다.
        // 첫 번째 정렬 후에야, 최적화 상태가 되기에, 컴파일러가 최적의 상태로 측정을 시작하도록 웜업을 실행한다.
        System.out.println("웜업 시작");
        for (int i = 0; i < 3; i++) {
            int[] warmupArray = arrayGenerator.generateArray(1, n, ArrayType.RANDOM)[0];
            quickWithThreshold.quickSortDC(Arrays.copyOf(warmupArray, n), 0, n - 1);
        }
        System.out.println("웜업 완료.");

        // 임계값에 따른 성능 비교
        for (int t = 0; t <= thresholdMax; t += 25) {
            long totalTime = 0;

            for (int[] array : arrays3) {
                int[] temp = Arrays.copyOf(array, array.length);

                long start = System.currentTimeMillis();
                quickWithThreshold.quickSortDC(temp, 0, n - 1, t);
                totalTime += System.currentTimeMillis() - start;
            }

            double averageTimeSec = (double) totalTime / testCount / 1000;
//            System.out.println("임계값 " + t + "일 때 평균 실행 시간: " + averageTimeSec + " 초");
            System.out.println(averageTimeSec);
        }
    }
}