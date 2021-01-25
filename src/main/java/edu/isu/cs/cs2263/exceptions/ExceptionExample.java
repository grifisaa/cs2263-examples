/**
 * Copyright 2021 Isaac Griffith
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in the
 * Software without restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies of the Software,
 * and to permit persons to whom the Software is furnished to do so, subject to the
 * following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
 * SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package edu.isu.cs.cs2263.exceptions;

import com.google.common.collect.Lists;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;


/**
 * @author Isaac Griffith
 * @version 0.2.1
 */
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
