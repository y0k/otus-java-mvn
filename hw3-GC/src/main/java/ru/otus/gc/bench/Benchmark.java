package ru.otus.gc.bench;

import java.util.ArrayList;
import java.util.List;

class Benchmark implements BenchmarkMBean {
  private final int loopCounter;

  public Benchmark(int loopCounter) {
    this.loopCounter = loopCounter;
  }

  private static List<Object> objContainer = new ArrayList<>();

  void run() throws InterruptedException {

    long beginTime = System.currentTimeMillis();

    while (objContainer.size() < loopCounter ) {
      for (double i = 0; i < loopCounter; i++) {
        Object newObj = i;
        objContainer.add(newObj);
      }
      System.out.println("after adding: " + objContainer.size());

      objContainer = objContainer.subList(objContainer.size() / 2, objContainer.size());

      System.out.println("after remove: " + objContainer.size());

      System.out.println("time: " + (System.currentTimeMillis() - beginTime) +"ms");
      Thread.sleep(10000);
    }
    System.out.println("total time: " + (System.currentTimeMillis() - beginTime)+"ms");

  }

}
