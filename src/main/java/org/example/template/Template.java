package org.example.template;

public abstract class Template<T> implements Runnable {


    private String[] testInput;
    private String[] input;

    private String day;
    private String year;
    private String name;

    public Template(int year, int day, String name) {
        this.day = String.valueOf(day);
        this.year = String.valueOf(year);
        this.name = name;
    }

    protected abstract void exec_part_1(T data) throws Exception;

    protected abstract void exec_part_2(T data) throws Exception;

    protected abstract T parseInput(String[] lines);

    protected void init() {
    }

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
                testInput = Utils.readFile(year, day, "test.txt");
            f.accept(parseInput(testInput));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        this.init();
        System.out.println("////////////////////////////////////////////////////////////////////////////////////////////");
        System.out.println(" ---------------- execute day " + "day :" + day + " " + name + " part " + part + " with real data -------");
        try {
            if (input == null)
                testInput = Utils.readFile(year, day, "real.txt");
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
