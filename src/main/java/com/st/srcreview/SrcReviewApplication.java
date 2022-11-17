package com.st.srcreview;

import com.st.srcreview.bean.A;
import com.st.srcreview.bean.B;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, MongoAutoConfiguration.class})
public class SrcReviewApplication {

    private final int a = 1;
    private final int b = 3;

    @Bean
    public A A() {
        return new A();
    }

    @Bean
    public B B() {
        return new B();
    }

//    private final static int CORE_SIZE = 2;

//    private final static int MAX_SIZE = 4;

//    private final static LinkedBlockingQueue<Req<String>> rql = new LinkedBlockingQueue<>(MAX_SIZE);

//    @Builder
//    @Accessors(chain = true)
//    @Getter
//    static class Req<T> {
//        private String id;
//        private String state;
//        private CompletableFuture<T> result;
//    }
//
//    private final static ThreadPoolExecutor service = new ThreadPoolExecutor(CORE_SIZE, MAX_SIZE, 0, TimeUnit.NANOSECONDS,
//            new LinkedBlockingQueue<>());

//    private static String ss = "one more time";

    public static void main(String[] args) throws Exception {
//        /*CompletableFuture<String> code = CompletableFuture.supplyAsync(() -> "grandson");
//        CompletableFuture<String> code2 = CompletableFuture.supplyAsync(() -> "father");
//        CompletableFuture<String> code3 = CompletableFuture.supplyAsync(() -> "son");
//        rql.offer(Req.<String>builder().id("1").state("200").result(code).build());
//        rql.offer(Req.<String>builder().id("2").state("201").result(code2).build());
//        rql.offer(Req.<String>builder().id("3").state("202").result(code3).build());
//        rql.offer(Req.<String>builder().id("4").state("202").result(null).build());
//
//        CountDownLatch cdl = new CountDownLatch(3);
//
//        service.submit(() -> {
//            while (!rql.isEmpty()) {
//                try {
//                    Req<String> poll = rql.poll();
//                    if (Objects.nonNull(poll)) {
//                        System.out.println(poll.result.get());
//                        System.out.println("remain: " + cdl.getCount());
//                        cdl.countDown();
//                    } else {
//                        cdl.await();
//                        System.out.println("G");
//                    }
//                } catch (Exception e) {
//                    System.out.println("error");;
//                }
//            }
//            service.shutdownNow();
//        });
//        System.out.println("service over");*/
        SpringApplication.run(SrcReviewApplication.class, args);
//        ApplicationContext ctx = new AnnotationConfigApplicationContext(SrcReviewApplication.class);
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
//        A a = ctx.getBean(A.class);
//        B b = ctx.getBean(B.class);
//        System.out.println(a);
//        System.out.println(b);
//        Double x = Double.valueOf("1.2");
//        Double x2 = Double.valueOf(1.2);
//        Integer w = Integer.valueOf("111");
//        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
//        Map<String, String> mp = new HashMap<>();
//        mp.put("1", "2");

    }

}
