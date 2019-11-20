package lesson2;

public class InterruptThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i < 5;i++){
                    System.out.println(Thread.currentThread().isInterrupted());
                }
                try {
                    //调用sleep()/wait()/join()方式时，线程进入阻塞状态
                    //此时也是可以中断，中断后抛出异常InterruptedException
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        for(int i = 0;i < 5;i++){
            System.out.println(Thread.currentThread().isInterrupted());
        }
        thread.start();
       // Thread.sleep(1000);
        thread.interrupt();

//先start，为默认的false；
//再interrup，修改了标志位成true(并没有真正的中断线程)
//遇见sleep()/wait()/join()方式时，抛异常，标志位重置。
//isInterrupted()返回真正的标志位

//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i  = 0;i < 10;i++){
//                    // 默认为false，在thread2.interrupt();打开后为true
//                    //作用：重置标志位为false，并且返回之前的标志位
//                    boolean b = Thread.interrupted();
//                    //初始标志位为false
//                    //isInterrupted()获取当前标志位
//                    //boolean b = Thread.currentThread().isInterrupted();
//                    System.out.println(b);
//                }
//            }
//        });//线程创建之后有一个默认的标志位 = false
//        thread2.start();
//        //调用下列操作后为true；修改标志位 = true.
//        thread2.interrupt();
    }
}
