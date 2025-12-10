package org.example.problems.year2016;

import org.example.template.Template;
import org.example.template.primitive.arrays.ArrUtils;

import java.util.*;

import static org.example.template.primitive.PUtils.strToI;

public class Pb2016_10 extends Template<Pb2016_10.Command[]> {

    Bot[] bots;
    int[] outputs;
    ArrayDeque<Command.Swap>[] swapQueue;
    ArrayDeque<Command.Add> addQueue;

    public Pb2016_10() {
        super(2016, 10, "Balance Bots");
    }

    @Override
    protected void init() {
        bots = ArrUtils.init(new Bot[250], Bot::new);
        outputs = new int[250];
        swapQueue = ArrUtils.init(new ArrayDeque[250], ArrayDeque::new);
        addQueue = new ArrayDeque<>();
    }

    @Override
    protected void exec_part_1(Command[] data) throws Exception {
        for (Command c : data) {
            switch (c) {
                case Command.Add add -> addQueue.push(add);
                case Command.Swap swap -> swapQueue[swap.giverId].push(swap);
            }
        }
        execAdd(addQueue.pop());
        System.out.println(Arrays.toString(bots));
        System.out.println(Arrays.toString(outputs));
    }

    @Override
    protected void exec_part_2(Command[] data) throws Exception {

    }

    private void execAdd(Command.Add add) {
        bots[add.id].accept(add.value);
        execNextBotCommand(add.id);
    }

    private void execSwap(char type, int botId, int value) {
        if (type == 'b') bots[botId].accept(value);
        else outputs[botId] = value;
        execNextBotCommand(botId);
    }

    private void execNextBotCommand(int botId) {
        checkValue(bots[botId], 61, 17, botId);
        if (bots[botId].isReady() && !swapQueue[botId].isEmpty()) {
            var head = swapQueue[botId].pop();
            int[] botValues = bots[head.giverId].consume();
            execSwap(head.lowType, head.lowId, botValues[0]);
            execSwap(head.highType, head.highId, botValues[1]);
        } else if (!addQueue.isEmpty()) {
            execAdd(addQueue.pop());
        }
    }

    private void checkValue(Bot bot, int a, int b, int index) {
        if (bot.a == a && bot.b == b || bot.a == b && bot.b == a) System.out.println("bot index :" + index);
    }

    private static class Bot {
        int a = -1;
        int b = -1;

        void accept(int value) {
            if (a == -1) a = value;
            else if (b == -1) b = value;
            else throw new IllegalStateException("bot cannot have more than two chips");
        }

        int[] consume() {
            if (a == -1 || b == -1) throw new IllegalStateException("bot cannot proceed with less than 2 chips");
            var temp = a < b ? new int[]{a, b} : new int[]{b, a};
            a = -1;
            b = -1;
            return temp;
        }

        boolean isReady() {
            return a != -1 && b != -1;
        }

        @Override
        public String toString() {
            return "Bot[" + a + "," + b + "]";
        }
    }

    @Override
    protected Command[] parseInput(String[] lines) {
        return Arrays.stream(lines).map(it -> it.split(" ")).map(it -> {
            if (it[0].charAt(0) == 'v') {
                return new Command.Add(strToI(it[1]), strToI(it[5]));
            } else {
                return new Command.Swap(strToI(it[1]), it[5].charAt(0), strToI(it[6]), it[10].charAt(0), strToI(it[11]));
            }
        }).toArray(Command[]::new);
    }

    protected sealed interface Command permits Command.Add, Command.Swap {
        record Add(int value, int id) implements Command {
        }

        record Swap(int giverId, char lowType, int lowId, char highType, int highId) implements Command {
        }
    }
}
