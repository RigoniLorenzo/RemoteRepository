package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */

    private static final int ELEMS = 100_000;

    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1000; i < 2000; i++) {
            arrayList.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final LinkedList<Integer> linkedList = new LinkedList<>(arrayList);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = arrayList.get(0);
        arrayList.set(0, arrayList.get(arrayList.size() - 1));
        arrayList.set(arrayList.size() - 1, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (var i : arrayList) {
            System.out.print(i + " ");
        }
        System.out.println();
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time1 = System.nanoTime();
        for (int i = 0; i < ELEMS; i++) {
            arrayList.add(0, i);
        }
        time1 = System.nanoTime() - time1;
        var millis1 = TimeUnit.NANOSECONDS.toMillis(time1);
        long time2 = System.nanoTime();
        for (int i = 0; i < ELEMS; i++) {
            linkedList.add(0, i);
        }
        time2 = System.nanoTime() - time2;
        var millis2 = TimeUnit.NANOSECONDS.toMillis(time2);
        System.out.println(
            "Add 100.000 elements in ArrayList and LinkedList: "
            + "ArrayList: " + time1 + " (" + millis1 + " ms)  "
            + "LinkedList: " + time2 + " (" + millis2 + " ms)  "
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        time1 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            arrayList.get((arrayList.size() - 1) / 2);
        }
        time1 = System.nanoTime() - time1;
        millis1 = TimeUnit.NANOSECONDS.toMillis(time1);
        time2 = System.nanoTime();
        for (int i = 0; i < 1000; i++) {
            linkedList.get((linkedList.size() - 1) / 2);
        }
        time2 = System.nanoTime() - time2;
        millis2 = TimeUnit.NANOSECONDS.toMillis(time2);
        System.out.println(
            "Read 1000 times the middle element in ArrayList and LinkedList: "
            + "ArrayList: " + time1 + " (" + millis1 + " ms)  "
            + "LinkedList: " + time2 + " (" + millis2 + " ms)  "
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final HashMap<String,Long> hashMap = new HashMap<>();
        hashMap.put("Africa", 1_110_635_000L);
        hashMap.put("Americas", 972_005_000L);
        hashMap.put("Antarctica", 0L);
        hashMap.put("Asia", 4_298_723_000L);
        hashMap.put("Europe", 742_452_000L);
        hashMap.put("Oceania", 38_304_000L);
        /*
         * 8) Compute the population of the world
         */
        long allWorld = 0;
        for (var pop : hashMap.entrySet()) {
            allWorld += pop.getValue();
        }
        System.out.println("Population of the world: " + allWorld);
    }
}
