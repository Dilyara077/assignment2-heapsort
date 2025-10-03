# HeapSort Algorithm

## Project Structure
- `src/main/java/algorithms/HeapSort.java` — implementation of the HeapSort algorithm.
- `src/main/java/algorithms/Main.java` — benchmark runner and CSV generator.
- `src/test/java/algorithms/HeapSortTest.java` — JUnit tests.
- `docs/performance-plots/heapsort_bench.csv` — benchmark results.

## How to Run
1. Run tests:
   ```bash
   mvn test
   ```

Run benchmark:

open Main.java

click Run

results will be printed to the console and saved to docs/performance-plots/heapsort_bench.csv

## Example Output
```
n   trial   time(ms)   comp      swaps     ok
100     1      0       1030      582       true
1000    1      0       16861     9088      true
10000   1      4       235376    124167    true
100000  1      44      3019015   1574476   true
```
## Author
Dilyara  
Assignment 2 — Design and Data Analysis
✅ Tested with Java 24 and Maven 3.9
