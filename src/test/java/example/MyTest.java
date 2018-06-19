package example;

import org.junit.Test;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by 宋东东 on 2018/6/19.
 */
public class MyTest {
    @Test
    public void demo() {
        // 定义一个缓冲的线程值 线程池的大小根据任务变化
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            threadPool.execute(new Runnable() {
                public void run() {
                    try {
                        Random random=new Random();
                        work("in.txt", random.nextInt(99)+"out.txt");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        //启动一次顺序关闭，执行以前提交的任务，但不接受新任务。
        threadPool.shutdown();
        try {
            // 请求关闭、发生超时或者当前线程中断，无论哪一个首先发生之后，都将导致阻塞，直到所有任务完成执行
            // 设置最长等待10秒
            threadPool.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线执行。");
    }

    public void work(String inName, String outName) throws Exception {
        long start =System.currentTimeMillis();
        String[] array = read(inName);

        strSort(array);

        write(array, outName);

        System.out.println("耗时："+(System.currentTimeMillis()-start)+"毫秒  "+outName);
    }

    /**
     * 对字符串进行由小到大排序
     *
     * @param str String[] 需要排序的字符串数组
     */
    public void strSort(String[] str) {
        for (int i = 0; i < str.length; i++) {
            for (int j = i + 1; j < str.length; j++) {
                if (str[i].compareTo(str[j]) > 0) {    //对象排序用camparTo方法
                    swap(str, i, j);
                }
            }
        }

    }

    /**
     * 交换两个元素的位置的方法
     *
     * @param strSort 需要交换元素的数组
     * @param i       索引i
     * @param j       索引j
     */
    private void swap(String[] strSort, int i, int j) {
        String t = strSort[i];
        strSort[i] = strSort[j];
        strSort[j] = t;
    }

    /**
     * 打印字符串数组
     *
     * @param str
     */
    private void printArr(String[] str) {
        for (int i = 0; i < str.length; i++) {
            System.out.print(str[i] + "\t");
        }
        System.out.println();
    }

    private String[] read(String name) {
        File in = new File(name);
        BufferedReader reader = null;
        String string = null;
        ArrayList<String> list = new ArrayList<String>();
        try {
            reader = new BufferedReader(new FileReader(in));
            while ((string = reader.readLine()) != null) {
                list.add(string);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list.toArray(new String[list.size()]);
    }

    private void write(String[] array, String name) {
        File out = new File(name);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(out));
            for (int i = 0; i < array.length; i++) {
                writer.write(array[i]);
                writer.newLine();
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
