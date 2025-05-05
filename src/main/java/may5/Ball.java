package may5;

import java.util.Scanner;

public class Ball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[] cup = {1, 0, 0};

        while (m > 0) {
            int x = scanner.nextInt() - 1;
            int y = scanner.nextInt() - 1;

            int temp = 0;
            temp = cup[x];
            cup[x] = cup[y];
            cup[y] = temp;
            m--;
        }
        for (int i = 0; i < 3; i++) {
            if (cup[i] == 1) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
