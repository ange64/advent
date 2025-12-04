package org.example.template;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Consumer;
import java.util.function.Function;

public abstract class Template<T>  implements Runnable{

    static final ClassLoader loader = Template.class.getClassLoader();
    private T testInput;
    private T input;

    private int day;
    private int year;

    private String name;

    public Template(int year, int day, String name) {
        this.day = day;
        this.year = year;
        var base = loader.getResource( year + "/" + day + "/").toString().substring(6);
        try {
            this.testInput = parseInput(
                    Files.readAllLines(Path.of(base +  "test.txt")).toArray(new String[0])
            );
            this.input = parseInput(
                    Files.readAllLines(Path.of(base  + "real.txt")).toArray(new String[0])
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.name = name;
    }

    protected abstract void exec_part_1(T data) throws Exception;

    protected abstract void exec_part_2(T data) throws Exception;

    protected abstract T parseInput(String[] lines);


    protected void resetState() {}


    @Override
    public void run() {
        executePart(this::exec_part_1, 1);
        executePart(this::exec_part_2, 2);
    }

    private void executePart(ThrowConsumer<T> f, int part) {
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(" ---------------- execute " + name + " part " + part + " with test data -------------");
        resetState();
        try {
           f.accept(testInput);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(" ---------------- execute " + name + " part " + part + " with real data -------------");
        resetState();
        try {
            long time = System.nanoTime();
            f.accept(input);
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
