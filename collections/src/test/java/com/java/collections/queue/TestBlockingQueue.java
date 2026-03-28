package com.java.collections.queue;

import com.java.collections.model.Student;
import com.java.collections.service.StudentService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.concurrent.*;

@Slf4j
public class TestBlockingQueue {

    static class Producer implements Runnable {
        private final BlockingQueue<Integer> queue;

        private int value = 0;

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while(true) {
                log.info("Producing value: {}", value);
                try {
                    queue.put(value++);
                    // log.info("Queue after producing: {}", queue);
                    Thread.sleep(500); // Simulate time taken to produce
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue<Integer> queue;

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    Integer value = queue.take();
                    log.info("Consuming value: {}", value);
                    // log.info("Queue after consuming: {}", queue);
                    Thread.sleep(3000); // Simulate time taken to consume
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    @Test
    public void testProducerConsumer() throws InterruptedException {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        Thread producer = new Thread(new Producer(queue));
        Thread consumer = new Thread(new Consumer(queue));
        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }

    @Test
    public void testArrayBlockingQueue() {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<Integer>(5);
        try {
            // Adding elements to the queue
            for (int i = 0; i < 5; i++) {
                blockingQueue.put(i);
                log.info("Added element: {}, Current Queue: {}", i, blockingQueue);
            }

            // Attempting to add one more element (will block if queue is full)
            log.info("Attempting to add element 5 to the full queue...");
            // blockingQueue.put(5); // Uncommenting this line will block the thread

            // Removing elements from the queue
            for (int i = 0; i < 5; i++) {
                Integer removed = blockingQueue.take();
                log.info("Removed element: {}, Current Queue: {}", removed, blockingQueue);
            }

            // Attempting to remove one more element (will block if queue is empty)
            log.info("Attempting to remove element from the empty queue...");
            // Integer removed = blockingQueue.take(); // Uncommenting this line will block the thread

        } catch (InterruptedException e) {
            log.error("Thread was interrupted", e);
        }
    }

    @Test
    public void testLinkedBlockingQueue() {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(5);
    }

    @Test
    public void testPriorityBlockingQueue() throws InterruptedException {
        BlockingQueue<Student> blockingQueue = new PriorityBlockingQueue<>(5, Comparator.reverseOrder());
        StudentService.students().forEach(student -> {
            try {
                blockingQueue.put(student);
            } catch (InterruptedException ignored) {}
        });
        log.info("PriorityBlockingQueue: {}", blockingQueue);
        while (!blockingQueue.isEmpty()) {
            Student student = blockingQueue.take();
            log.info("Polled Student: {}", student);
        }
    }

    @Test
    public void testSynchronousQueue() throws InterruptedException {
        BlockingQueue<String> queue = new SynchronousQueue<>();
        Thread producer = new Thread(() -> {
            try {
                log.info("Producer is waiting to put a message...");
                queue.put("Hello from Producer");
                log.info("Producer has transferred the message.");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        Thread consumer = new Thread(() -> {
            try {
                Thread.sleep(2000); // Simulate some delay before consuming
                log.info("Consumer is ready to take a message...");
                String message = queue.take();
                log.info("Consumer received message: {}", message);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();

        producer.join();
        consumer.join();
    }

    @Test
    public void testDelayQueue() throws InterruptedException {
        BlockingQueue<Task> delayQueue = new DelayQueue<>();
        delayQueue.put(new Task("Task1", 5, TimeUnit.SECONDS));
        delayQueue.put(new Task("Task2", 3, TimeUnit.SECONDS));
        delayQueue.put(new Task("Task3", 8, TimeUnit.SECONDS));
        while (!delayQueue.isEmpty()) {
            Task task = delayQueue.take();
            log.info("Executed: {} at {}", task.getTaskName(), System.currentTimeMillis());
        }
    }

    @Getter
    class Task implements Delayed {
        private final String taskName;
        private final long startTime;

        public Task(String taskName, long delayTime, TimeUnit unit) {
            this.taskName = taskName;
            this.startTime = System.currentTimeMillis() + unit.toMillis(delayTime);
        }

        @Override
        public long getDelay(TimeUnit unit) {
            long remaining = startTime - System.currentTimeMillis();
            return unit.convert(remaining, TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.startTime < ((Task) o).startTime) {
                return -1;
            } else if (this.startTime > ((Task) o).startTime) {
                return 1;
            }
            return 0;
        }

    }
}
