package ru.otus.l22;

import java.lang.management.ManagementFactory;
        //vm options -Xmx1g -Xms1g
public class Main {

    public static void main(String... args) {
        System.out.println("Start pid: " + ManagementFactory.getRuntimeMXBean().getName());
        Benchmark benchmark = new  Benchmark();
        benchmark.prepare();

        benchmark.measure(Object::new, "Object" );
        benchmark.clean();

        benchmark.measure(String::, "String" );
        benchmark.clean();

        benchmark.measure(() -> new String(new byte[0])), "String of list bytes");
        benchmark.clean();

        benchmark.measure(() -> new Benchmark(10), "Benchmark(10)");
        benchmark.clean();
    }
}
