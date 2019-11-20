package lesson2;

public class MyThread {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("明天");
            }
        });
        thread.start();
        //下面的代码常常先执行，因为以上创建线程的部分很耗时
        //不调用join时，创建线程耗时较长，下面的main方法会先执行
        //若调用join方法，会等待子线程执行完再执行下一条程序
        thread.join();
        System.out.println("今天");
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {

        }
    };


}
