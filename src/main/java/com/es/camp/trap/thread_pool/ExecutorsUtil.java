package com.es.camp.trap.thread_pool;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

// 自定义线程池工具类, 具备监控功能
@Slf4j
public class ExecutorsUtil extends ThreadPoolExecutor {

    private ConcurrentHashMap<String, Date> startTimes;
    private String poolName;


    public ExecutorsUtil(int corePoolSize, int maximumPoolSize,
                         long keepAliveTime, TimeUnit unit,
                         BlockingQueue<Runnable> workQueue,
                         String poolName) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, new EventThreadFactory(poolName));
        this.startTimes = new ConcurrentHashMap<>();
        this.poolName = poolName;
    }

    @Override
    public void shutdown() {
        log.info("========= {} going to shutdown , Executed tasks:{}, Running tasks:{}, Pending tasks:{}.",this.poolName,
                this.getCompletedTaskCount(),this.getActiveCount(),this.getQueue().size());
        super.shutdown();
    }

    @Override
    public List<Runnable> shutdownNow() {
        log.info("========= {} going to shutdown , Executed tasks:{}, Running tasks:{}, Pending tasks:{}.",this.poolName,
                this.getCompletedTaskCount(),this.getActiveCount(),this.getQueue().size());
        return super.shutdownNow();
    }

    @Override
    protected void beforeExecute(Thread t, Runnable r) {
        startTimes.put(String.valueOf(r.hashCode()), new Date());
        super.beforeExecute(t, r);
    }

    @Override
    protected void afterExecute(Runnable r, Throwable t) {
        Date startTime = startTimes.remove(String.valueOf(r.hashCode()));
        Date finishTime = new Date();
        long diff = finishTime.getTime() - startTime.getTime();
        log.info("====== Task running time is {}", diff);
        super.afterExecute(r, t);
    }

    static class EventThreadFactory implements ThreadFactory {
        // static 为所有的 EventThreadFactory 对象共享
        private static final AtomicInteger poolNumber = new AtomicInteger(1);

        // 每个 EventThreadFactory 都有一个初始化的
        private final AtomicInteger threadNumber = new AtomicInteger(1);

        private final ThreadGroup group;
        private final String namePrefix;

        public EventThreadFactory(String poolName) {
            SecurityManager securityManager = System.getSecurityManager();
            group = (securityManager != null) ? securityManager.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = poolName + "-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            // 创建线程, stackSize:0 为0时, JVM 将分配默认大小的栈空间.
            Thread t = new Thread(group,r,namePrefix + threadNumber.getAndIncrement(),0);

            // 将线程设为非守护线程
            if (t.isDaemon()) {
                t.setDaemon(false);
            }

            // 设置线程的优先级为正常状态.
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }


    }


}
