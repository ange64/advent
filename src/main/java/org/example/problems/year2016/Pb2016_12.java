package org.example.problems.year2016;

import org.example.template.Template;

import java.util.function.BiConsumer;

public class Pb2016_12 extends Template<Pb2016_12.Command[]> {

    int[] registers;
    int cursor;
    public Pb2016_12() {
        super(2016, 12, "Leonardo's Monorail");
    }

    @Override
    protected void init() {
        registers = new int[126];
        cursor = 0;
    }

    @Override
    protected void exec_part_1(Command[] data) throws Exception {
        while (cursor < data.length) {
           //String str = data[cursor].ins + " | " + cursor;
            data[cursor++].apply();
            //System.out.println(str + "|" + registersStr());
        }
        System.out.println(registers['a']);
    }

    private String registersStr() {
        return "[" + registers['a'] + "," + registers['b'] + "," + registers['c'] + "," + registers['d'] + "]";
    }

    @Override
    protected void exec_part_2(Command[] data) throws Exception {
        registers['c'] = 1;
        exec_part_1(data);
    }

    private void cpy(String value, String target) {
        registers[target.charAt(0)] = value.charAt(0) >= 'a' ?  registers[value.charAt(0)] : Integer.parseInt(value);
    }

    private void jnz(String condition, String offset) {
        char c = condition.charAt(0);
        if (c == '0' || c >= 'a' && registers[c] == 0) return;
        cursor += Integer.parseInt(offset) - 1;
    }

    private void inc(String register, String UNUSED) {
        registers[register.charAt(0)]++;
    }

    private void dec(String register, String UNUSED) {
        registers[register.charAt(0)]--;
    }

    @Override
    protected Command[] parseInput(String[] lines) {
        Command[] commands = new Command[lines.length];
        int i = 0;
        for (String line : lines) {
            var split = line.split(" ");
            var c = switch (split[0]){
                case "cpy" -> new Command(split[0], this::cpy, split[1], split[2]);
                case "jnz" -> new Command(split[0], this::jnz, split[1], split[2]);
                case "dec" -> new Command(split[0], this::dec, split[1], "");
                case "inc" -> new Command(split[0], this::inc, split[1], "");
                default -> throw new IllegalStateException("Unexpected value: " + line.charAt(0));
            };
            commands[i++] = c;
        }
        return commands;
    }

    protected record Command(String ins, BiConsumer<String, String> func, String arg1, String arg2) {
        void apply() {
            func.accept(arg1, arg2);
        }
    }
}
