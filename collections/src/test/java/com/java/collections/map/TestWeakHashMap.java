package com.java.collections.map;

import com.java.collections.model.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.lang.ref.WeakReference;
import java.time.Duration;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TestWeakHashMap {

    @Test
    public void testWeakReference1() {
        WeakReference<Student> studentWeakReference = new WeakReference<>(new Student(1, "Alice", 95.0));
        log.info("Student before GC: {}", studentWeakReference.get());
        System.gc();
        log.info("Student after GC: {}", studentWeakReference.get());
    }

    @Test
    public void testWeakReference2() throws InterruptedException {
        WeakReference<Student> studentWeakReference = new WeakReference<>(new Student(1, "Alice", 95.0));
        log.info("Student before GC: {}", studentWeakReference.get());
        try {
            Thread.sleep(10000);
        } catch (Exception ignored) {

        }
        log.info("Student after GC: {}", studentWeakReference.get());
    }

    @Test
    public void testWeakReferenceWithDelay() throws InterruptedException {
        WeakReference<Student> studentWeakReference = new WeakReference<>(new Student(1, "Alice", 95.0));
        log.info("Student before GC: {}", studentWeakReference.get());
        TimeUnit.SECONDS.sleep(5);
        System.gc();
        TimeUnit.SECONDS.sleep(5);
        log.info("Student after GC: {}", studentWeakReference.get());
    }

    @Data
    @AllArgsConstructor
    static class Image {
        private String name;
    }

    @Test
    public void testWeakHashMap() throws InterruptedException {
        WeakHashMap<String, Image> imageCache = new WeakHashMap<>();
        loadCache(imageCache);
        log.info("Image Cache before GC: {}", imageCache);
        System.gc();
        TimeUnit.SECONDS.sleep(10);
        log.info("Image Cache after GC: {}", imageCache);
    }

    private void loadCache(WeakHashMap<String, Image> imageCache) {
        imageCache.put(new String("image1"), new Image("Image 1"));
        imageCache.put(new String("image2"), new Image("Image 2"));
    }

}
