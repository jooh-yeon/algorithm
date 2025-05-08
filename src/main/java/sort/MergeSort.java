package sort;

import java.util.Arrays;

public class MergeSort {
    // 배열을 하나가 될 때까지 반으로 쪼개서 정렬하는 재귀 메서드
    public static void mergeSort(int[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(array, left, mid);  // 왼쪽 절반 정렬
            mergeSort(array, mid + 1, right);  // 오른쪽 절반 정렬
            merge(array, left, mid, right);  // 정렬된 두 절반 병합
        }
    }

    // 두 개의 정렬된 부분 배열을 병합하는 메서드
    public static void merge(int[] array, int left, int mid, int right) {
        // 왼쪽 배열 : array[Left] ~ array[mid] 복사
        // Arrays.copyOfRange(arr, from, to) - from : 포함 / to : 포함 X
        int[] L = Arrays.copyOfRange(array, left, mid + 1);
        // 오른쪽 배열 : array[mid + 1] ~ array[right] 복사
        int[] R = Arrays.copyOfRange(array, mid + 1, right + 1);

        // L 배열 인덱스, R 배열 인덱스, 원래 배열(array)에 병합할 위치
        int i = 0, j = 0, k = left;

        // 두 배열 모두 남아있을 때 작은 값을 array에 넣기
        while (i < L.length && j < R.length) {
            if (L[i] <= R[j]) {
                array[k] = L[i];  // L이 더 작거나 같으면 복사
                i++;    // L 인덱스 증가
            } else {
                array[k] = R[j];  // R이 더 작으면 복사
                j++;    // R 인덱스 증가
            }
            k++;  // 병합 위치 인덱스 증가
        }

        // L 배열에 남은 값들 복사
        while (i < L.length) {
            array[k] = L[i];
            i++;
            k++;
        }

        // R 배열에 남은 값들 복사
        while (j < R.length) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
