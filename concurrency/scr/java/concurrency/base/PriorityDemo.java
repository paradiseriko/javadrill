package concurrency.base;

public class PriorityDemo {
    public static class HightPriority extends Thread{
        static int count = 0;
        @Override
        public void run(){
            while(true){
                synchronized (PriorityDemo.class){
                    count++;
                    if(count>10000000){
                        System.out.println("Hight priority is done");
                        break;
                    }
                }
            }
        }
    }
    public static class LowPriority extends Thread{
        static int count = 0;
        @Override
        public void run(){
            while(true){
                synchronized (PriorityDemo.class){
                    count++;
                    if(count>10000000){
                        System.out.println("Low priority is done");
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread high = new HightPriority();
        Thread low = new LowPriority();
        high.setPriority(Thread.MAX_PRIORITY);
        low.setPriority(Thread.MIN_PRIORITY);
        low.start();
        high.start();
    }
}
