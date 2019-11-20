package lesson2;

public class StopThread {

    private static volatile boolean myInterrupted;//自己定义标志位(默认为false)

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //while(true)
                while (!myInterrupted){
                    //空转，一直运行
                    System.out.println("hello");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        Thread.sleep(5000);
        myInterrupted = true;
    }
}
