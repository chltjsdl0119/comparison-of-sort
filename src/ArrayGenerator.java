import java.util.Arrays;
import java.util.Collections;

/**
 * 배열을 생성해주는 ArrayGenerator 클래스.
 * 인스턴스를 생성한 후, generateArray(int N, ArrayType arrayType) 메소드를 호출하여 배열을 생성한다.
 */
public class ArrayGenerator {

    public ArrayGenerator() {
    }

    /**
     * 배열을 생성해주는 메소드
     * @param n 배열의 길이
     * @param arrayType 배열의 타입. SORTED(오름차순 정렬), REVERSE(내람차순 정렬), RANDOM(각 원소를 무작위 배열) 세 가지 타입으로 생성 가능.
     * @return 지정된 타입으로 생성된 배열
     */
    public Integer[] generateArray(int n, ArrayType arrayType) {
        Integer[] array = new Integer[n];

        if (arrayType == ArrayType.SORTED) {
            for (int i = 0; i < n; i++) {
                array[i] = i;
            }

        } else if (arrayType == ArrayType.REVERSE) {
            for (int i = 0; i < n; i++) {
                array[i] = n - i - 1;
            }

        } else if (arrayType == ArrayType.RANDOM) {
            for (int i = 0; i < n; i++) {
                array[i] = i;
            }

            Collections.shuffle(Arrays.asList(array));
        } else return null;

        return array;
    }
}
