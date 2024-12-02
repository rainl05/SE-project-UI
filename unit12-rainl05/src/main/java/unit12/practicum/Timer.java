package unit12.practicum;

import java.util.List;

public class Timer{
    public static void time(String name, List<Integer> list, List<Integer> numberOfValues){
        long start = System.nanoTime();

        for(Integer e : numberOfValues){
            list.add(e);
        }

        long end = System.nanoTime();

        System.out.println("Filed " + name + " with " + numberOfValues.toString() + " in " + (end - start) + " nanoseconds.");
    }

    public static void main(String[] args) {
    
    }
}
