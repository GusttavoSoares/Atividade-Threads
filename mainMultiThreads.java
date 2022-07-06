package Arquivos.Thread.MultiThreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class mainMultiThreads {

    public static void main(String[] args)
            throws InterruptedException {
        // TODO Auto-generated method stub
        ExecutorService threadRun =
                Executors.newCachedThreadPool();
        buffer sharedLocation = new unsysnchronizedBuffer();

        System.out.printf("Thread running\t\tValue\t "
                + "Sum write\tSum read\n");
        System.out.println("-------------------------------------------------------------------");
        threadRun.execute(new writeBuffer(sharedLocation));
        threadRun.execute(new readBuffer(sharedLocation));
        threadRun.shutdown();
        threadRun.awaitTermination(1, TimeUnit.MINUTES);
    }
}
