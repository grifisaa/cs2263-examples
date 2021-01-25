package edu.isu.cs.cs2263.exceptions;

import com.google.common.collect.Lists;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

public class ExceptionExample {

    private static final int SIZE = 10;
    private List<Integer> list = Lists.newArrayList();

    public static void main(String args[]) {
        ExceptionExample app = new ExceptionExample();
        app.createList();
        app.writeList();
    }

    public void createList() {
        Random rand = new Random();
        for (int i = 0; i < SIZE; i++) {
            list.add(rand.nextInt(100) + 1);
        }
    }

    public void writeList() {
        try (PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"))){
            for (int i = 0; i < SIZE; i++) {
                out.printf("Value at: %d = %d\n", i, list.get(i));
            }
        } catch (IOException | IndexOutOfBoundsException ex) {
            System.err.printf("%s: %s\n", ex.getClass().getSimpleName(), ex.getMessage());
        }
    }
}
