package algorithms;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.Random;

public class Main {
    static final int[] SIZES = {100, 1000, 10_000, 100_000};
    static final int TRIALS = 5;
    static final int MIN = -1000, MAX = 1000;

    public static void main(String[] args) throws Exception {
        Path outDir = Paths.get("docs", "performance-plots");
        Files.createDirectories(outDir);
        Path csv = outDir.resolve("heapsort_bench.csv");

        try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(csv))) {
            pw.println("n,trial,time_ms,comparisons,swaps,ok");
            System.out.println("n\ttrial\ttime(ms)\tcomp\tswaps\tok");

            Random rnd = new Random();
            for (int n : SIZES) {
                for (int t = 1; t <= TRIALS; t++) {
                    int[] arr = rnd.ints(n, MIN, MAX).toArray();

                    long start = System.nanoTime();
                    HeapSort.sort(arr);
                    long end = System.nanoTime();

                    long ms = (end - start) / 1_000_000;
                    boolean ok = isSorted(arr);

                    System.out.printf("%d\t%d\t%d\t%d\t%d\t%b%n",
                            n, t, ms, HeapSort.comparisons, HeapSort.swaps, ok);
                    pw.printf(Locale.US, "%d,%d,%d,%d,%d,%b%n",
                            n, t, ms, HeapSort.comparisons, HeapSort.swaps, ok);
                }
            }
        }
        System.out.println("\nCSV saved to " + csv.toAbsolutePath());
    }

    private static boolean isSorted(int[] a) {
        for (int i = 1; i < a.length; i++) if (a[i - 1] > a[i]) return false;
        return true;
    }
}
