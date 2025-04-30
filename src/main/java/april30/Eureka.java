package april30;

import java.util.Scanner;

public class Eureka {
    static int[] triangleNum = new int[46];

    public static void generateTriangleNumbers() {
        for (int i = 1; i <= 45; i++) {
            triangleNum[i] = i * (i + 1) / 2;
        }
    }

    public static boolean canBeExpressedAsThreeTriangularNumbers(int K) {
        for (int i = 1; i <= 45; i++) {
            for (int j = 1; j <= 45; j++) {
                for (int k = 1; k <= 45; k++) {
                    if (triangleNum[i] + triangleNum[j] + triangleNum[k] == K) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        generateTriangleNumbers();

        for (int i = 0; i < t; i++) {
            int v = scanner.nextInt();
            System.out.println(canBeExpressedAsThreeTriangularNumbers(v) ? 1 : 0);
        }
    }
}
