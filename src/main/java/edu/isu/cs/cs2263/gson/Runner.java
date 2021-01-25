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
package edu.isu.cs.cs2263.gson;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Isaac Griffith
 * @version 0.2.1
 */
public class Runner {

    public static void main(String args[]) {
        Professor isaac = new Professor("Isaac", "Griffith",
                new PhoneNumber("208", "282-4876"), "grifisaa@isu.edu",
                "BA 315");
        Professor paul = new Professor("Paul", "Bodily", new PhoneNumber("208", "282-4932"),
                "bodipaul@isu.edu", "BA 5XX");
        Professor dave = new Professor("David", "Beard", new PhoneNumber("208", "282-2684"),
                "beard@isu.edu", "BA 3XX");

        System.out.println(isaac);
        gsonSerialize(isaac);
        gsonSerializeList(Lists.newArrayList(isaac, paul, dave));
    }

    public static void gsonSerializeList(List<Professor> faculty) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        System.out.println("\nOriginal List:");
        for (Professor p : faculty) {
            System.out.println(p);
        }

        String json = gson.toJson(faculty);

        try { Files.writeString(Paths.get("./faculty.json"), json); }
        catch (IOException ex) { ex.printStackTrace(); }

        String json2 = "";

        try { json2 = Files.readString(Paths.get("./faculty.json")); }
        catch (IOException ex) { ex.printStackTrace(); }

        Type profList = new TypeToken<ArrayList<Professor>>() {}.getType();
        List<Professor> other = gson.fromJson(json2, profList);

        System.out.println("\nNew List:");
        for (Professor p : other) {
            System.out.println(p);
        }
    }

    public static void gsonSerialize(Professor prof) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        String json = gson.toJson(prof);
        System.out.println();
        System.out.println(json);

        try { Files.write(Paths.get("./prof.json"), json.getBytes()); }
        catch (IOException ex) { ex.printStackTrace(); }

        String json2 = "";
        try { json2 = Files.readString(Paths.get("./prof.json")); }
        catch (IOException ex) { ex.printStackTrace(); }

        Professor other = gson.fromJson(json2, Professor.class);
        System.out.println();
        System.out.println(json2);

        if (other.equals(prof))
            System.out.println("Same person");
        else
            throw new RuntimeException("Something bad happened!");
    }
}
