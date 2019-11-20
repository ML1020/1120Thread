package lesson2;
//多线程执行的效率问题

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ThreadAdvantage {
    public static List<String> randomList(){
        char[] chars = new char[]{'a','b','c','z','A','Z'};
        List<String> list = new LinkedList<>();
        for (int i = 0;i < 100000;i++){
            int random = new Random().nextInt(chars.length);
            char c = chars[random];
            list.add(String.valueOf(c));
        }
        return list;
    }

    public static void main(String[] args) throws InterruptedException {
        //randomList();
        List<String> list = randomList();
        //创建十个线程，每个线程获取list中的10000个元素
        long start = System.currentTimeMillis();
        //long start = new Date().getTime();
        Thread[] threads=new Thread[10];
        for (int i = 0;i < 10;i++){
            final int k = i;
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0;j < 10000;j++){
                        list.get(k*10000+j);
                    }
                }
            });
            threads[i].start();
        }
        long end = System.currentTimeMillis();
        //第一种做法：线程让步yield
//        while (Thread.activeCount() > 2){
//            Thread.yield();
//        }
        //第二种做法：调用线程加入/等待操作
        for (int i = 0;i < 10;i++){
            threads[i].join();
        }
        System.out.println("耗时："+(end - start)+"毫秒");
        //此时求出的是main线程的执行时间，与子线程无关
        //想要求子线程的执行时间，解决方法如上
    }
}
