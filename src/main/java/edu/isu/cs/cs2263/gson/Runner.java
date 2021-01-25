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
