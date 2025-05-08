package sort;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinarySearch {
    public static int binarySearch(int[] arr, int f) {
        // 1. 정렬 (이진 탐색은 정렬된 배열이라는 전제가 있기 때문에 생략해도 됨)
        Arrays.sort(arr);

        int start = 0;
        int end = arr.length - 1;
        int mid = 0;

        while (start <= end) {
            // 분할
            mid = (start + end) / 2;
            if (f == arr[mid]) {
                // 원하는 요소의 위치(정렬된 배열 기준 인덱스) 반환
                return mid;
                // 찾는게 가운데보다 더 크면
            } else if (arr[mid] < f) {
                // 시작점 재정의 (인덱스 갱신)
                start = mid + 1;
            } else if (f < arr[mid]) {
                end = mid - 1;
            }
        }
        throw new NoSuchElementException("존재하지 않음");
    }

    public static void main(String[] args) {
        int[] arr = {5, 1, 3, 4, 2};
        System.out.println(binarySearch(arr, 4));
    }
}
