public class Main {
    public static void main(String[] args) {

        int n = 100000;

        long startTime;
        long endTime;

        ArrayGenerator arrayGenerator = new ArrayGenerator();
        MergeSortDC mergeSortDC = new MergeSortDC(n);

        Integer[][] arrays = new Integer[7][n];

        for (int i = 0; i < 7; i++) {
            arrays[i] = arrayGenerator.generateArray(n, ArrayType.RANDOM);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println("------------------------------");
            System.out.println((i + 1) + "번째 배열 정렬 수행");

            startTime = System.currentTimeMillis();
            mergeSortDC.mergeSortDC(arrays[i], 0, arrays[i].length - 1);
            endTime = System.currentTimeMillis();

            System.out.println((i + 1) + "번째 배열 정렬 수행 시간(초): " + (double) (endTime - startTime) / 1000);
        }
        System.out.println("------------------------------");

    }
}