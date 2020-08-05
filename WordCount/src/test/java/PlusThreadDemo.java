import java.util.Random;
import java.util.concurrent.*;

/**
 * @author yanjh
 * @date 2020/8/5 22:15
 */
public class PlusThreadDemo {
    public static void main(String[] args) {

        // 自定义线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                5,
                7,
                10  ,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        try
        {
            for (int i = 1; i <=100; i++)//模拟n个客户来银行办理业务，提交请求。customer
            {
                threadPoolExecutor.execute(() -> {
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务"+new Random().nextInt(100));
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPoolExecutor.shutdown();
        }
    }
}
