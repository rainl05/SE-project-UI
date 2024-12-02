package unit12.practicum;

import java.util.LinkedList;
import java.util.List;

public class EvensAndOdds implements Runnable{
    private Object lock;
    private static List<Integer> odd = new LinkedList<>();
    private static List<Integer> even = new LinkedList<>();
    
        public EvensAndOdds(Object lock) {
            this.lock = lock;
        }
        
        @Override
        public void run() {
            for(int i = 1; i <= 100; i++){
                if(i % 2 == 0){
                    even.add(i);
            } else{
                odd.add(i);
            }
            }

            while(!odd.isEmpty() && !even.isEmpty()){
                synchronized(lock) {
                    if(even.get(0) < odd.get(0)){
                        System.out.println(even.get(0));
                        even.remove(0);
                    } else{
                        System.out.println(odd.get(0));
                        odd.remove(0);
                    }
                }
            }
        }
    
        public static void main(String[] args) {
            Object lcok = new Object();
            EvensAndOdds stuff = new EvensAndOdds(lcok);

            Thread thread = new Thread(stuff);
            thread.start();
        }
}
