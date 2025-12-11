package org.example.template;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class Template<T>  implements Runnable{

    static final ClassLoader loader = Template.class.getClassLoader();
    private String[] testInput;
    private String[] input;

    private int day;
    private int year;

    private String basePath;

    private String name;

    public Template(int year, int day, String name) {
        this.day = day;
        this.year = year;
        this.name = name;
        basePath =  loader.getResource( year + "/" + day + "/").toString().substring(6);
    }

    protected abstract void exec_part_1(T data) throws Exception;

    protected abstract void exec_part_2(T data) throws Exception;

    protected abstract T parseInput(String[] lines);

    protected void init() {}

    @Override
    public void run() {
        executePart(this::exec_part_1, 1);
        executePart(this::exec_part_2, 2);
    }

    private void executePart(ThrowConsumer<T> f, int part) {
        this.init();
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(" ---------------- execute day " + "day :" + day + " " + name + " part " + part + " with test data ------");
        try {
            if (testInput == null)
                testInput = Files.readAllLines(Path.of(basePath +  "test.txt")).toArray(new String[0]);
           f.accept(parseInput(testInput));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.init();
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(" ---------------- execute day " + "day :" + day + " " + name + " part " + part + " with real data -------");
        try {
            if (input == null)
                input = Files.readAllLines(Path.of(basePath +  "real.txt")).toArray(new String[0]);
            long time = System.nanoTime();
            f.accept(parseInput(input));
            long after = System.nanoTime();
            long delta = (after - time);
            System.out.println("delta time " + delta / 1_000_000 + "ms");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////");
    }

    private interface ThrowConsumer<T> {
        void accept(T arg) throws Exception;
    }
}
