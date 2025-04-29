package april28;

import java.util.Arrays;
import java.util.Scanner;

public class Dwarf {
    public int[] findSevenDwarfs() {
        int[] heights = new int[9];
        int[] result = new int[7];
        int sum = 0;

        // 1. Scanner로 키 입력받기
        Scanner scanner = new Scanner(System.in);

        // 2. for문으로 입력 값 배열에 삽입 (크기는 9로 고정)
        // 2-1. 동시에 int sum으로 전체 합 구하기
        for (int i = 0; i < 9; i++) {
            heights[i] = scanner.nextInt();
            sum += heights[i];
        }
        scanner.close();

        // 3. sum - 두 명의 키 = 100
        // 3-1. 두 값 따로 저장
        int a = -1;
        int b = -1;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if ((sum - heights[i] - heights[j]) == 100) {
                    // heights[i], heights[j] 값 배열에서 제거
                    a = heights[i];
                    b = heights[j];
                    break;
                }
            }
            if (a != -1) break;
        }

        // 4. 두 값 제외하고 배열에 담기
        int idx = 0;
        for (int i = 0; i < 9; i++) {
            if (heights[i] != a && heights[i] != b) {
                result[idx++] = heights[i];
            }
        }

        // 5. 정렬
        Arrays.sort(result);
        return result;
    }

    public static void main(String[] args) {
        Dwarf dwarf = new Dwarf();
        int[] result = dwarf.findSevenDwarfs();

        // 6. 100 찾으면 print(Arrays.sort(배열));
        for (int height : result) {
            System.out.println(height);
        }
    }
}
