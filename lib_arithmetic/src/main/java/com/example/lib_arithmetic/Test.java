package com.example.lib_arithmetic;

import com.example.lib_arithmetic.queue.ArrayQueue;
import com.example.lib_arithmetic.queue.LoopQueue;
import com.example.lib_arithmetic.queue.Queue;

import java.util.Random;

public class Test {

    private static double testQueue(Queue<Integer> queue,int optCount){
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0 ; i < optCount; i++){
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for (int i = 0 ; i < optCount; i++){
            queue.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args){
        int optCount = 100000;
        double  arrtime = testQueue(new ArrayQueue<Integer>(),optCount);
        double loopTime = testQueue(new LoopQueue<Integer>(),optCount);
        System.out.println(arrtime);
        System.out.println(loopTime);
    }
}