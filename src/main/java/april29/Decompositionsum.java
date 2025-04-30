package april29;

import java.util.Scanner;

public class Decompositionsum {
    public static int digit(int N) {
        if (N < 10) {
            return N;
        }
        return (N % 10) + digit(N / 10);
    }

    public static int digitSum(int N) {
        return digit(N) + N;
    }

    public static void main(String[] args) {
        // 1. 입력 받기
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        scanner.close();

        int result = 0;
        boolean found = false;

        // 2. 1-M까지 중 생성자 찾기
        for (int N = 1; N <= M; N++) {
            if (digitSum(N) == M) {
                result = N;
                found = true;
                break;
            }
        }

        // 3. return 0
        System.out.println(found ? result : 0);
    }
}
