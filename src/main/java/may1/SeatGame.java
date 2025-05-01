package may1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SeatGame {

    private static List<Integer> deck() {
        List<Integer> deck = new ArrayList<>();
        for (int r = 0; r < 2; r++) {
            for (int i = 1; i <= 10; i++) {
                deck.add(i);
            }
        }
        return deck;
    }

    private static int getScore(int A, int B) {
        if (A == B){
            return A + 10;
        } else {
            return (A + B) % 10;
        }
    }

    public static float calculator(List<Integer> deck, int A, int B) {
        int win = 0;
        int total = 0;
        int myScore = getScore(A, B);

        for (int i = 0; i < deck.size(); i++) {
            for (int j = 0; j < deck.size(); j++) {
                if (i != j) {
                    if (myScore > getScore(deck.get(i), deck.get(j))) {
                        win++;
                    }
                    total++;
                }
            }
        }
        return (float) win / total;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        int B = scanner.nextInt();

        List<Integer> deck = deck();

        deck.remove(Integer.valueOf(A));
        deck.remove(Integer.valueOf(B));

        float probability = calculator(deck, A, B);
        System.out.printf("%.3f\n", probability);
    }
}