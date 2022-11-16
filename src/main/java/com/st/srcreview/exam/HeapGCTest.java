package com.st.srcreview.exam;

public class HeapGCTest {

    private static byte[] alloc() {
        byte[] data = new byte[1024 * 1022];//未发生逃逸
        return data;
    }

    public static void main(String[] args) {
        Runtime.getRuntime().gc();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 26; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("花费的时间为： " + (end - start) + " ms");
        // 为了方便查看堆内存中对象个数，线程sleep
//        TimeUnit.MINUTES.sleep(5);
        System.out.println("-----------------");
        System.out.println("最大堆：" + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "M");
        System.out.println("空闲堆：" + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "M");
        System.out.println("总的堆：" + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "M");
        System.out.println(System.getenv().get("gc"));
    }


}
