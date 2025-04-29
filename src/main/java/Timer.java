public class Timer {
    private long startTime;

    public void start() {
        startTime = System.nanoTime();
    }

    public void end(String message) {
        long endTime = System.nanoTime();
        System.out.println(message + "걸린 시간: " + (endTime - startTime) / 1_000_000.0 + "ms");
    }
}
