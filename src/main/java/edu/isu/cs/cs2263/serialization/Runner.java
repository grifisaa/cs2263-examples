package edu.isu.cs.cs2263.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Runner {

    public static void main(String args[]) {
        Professor isaac = new Professor("Isaac", "Griffith",
                new PhoneNumber("208", "282-4876"), "grifisaa@isu.edu",
                "BA 315");

        System.out.println(isaac);
        //javaSerialize(isaac);
        gsonSerialize(isaac);

    }

    private static void gsonSerialize(Professor isaac) {
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        String json = gson.toJson(isaac);
        System.out.println();
        System.out.println(json);

        try { Files.write(Paths.get("./prof.json"), json.getBytes()); }
        catch (IOException ex) { ex.printStackTrace(); }

        String json2 = "";
        try { json2 = Files.readString(Paths.get("./prof.json")); }
        catch (IOException ex) { ex.printStackTrace(); }

        Professor other = gson.fromJson(json2, Professor.class);
        System.out.println();
        System.out.println(other);
    }

    private static void javaSerialize(Professor isaac) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("serial_test.obj"))) {
            out.writeObject(isaac);
        } catch (IOException ex) {
            System.err.printf("IOException: %s", ex.getMessage());
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("serial_test.obj"))) {
            Professor other = (Professor) in.readObject();
            System.out.println(other);
        } catch (IOException | ClassNotFoundException ex) {
            System.err.printf("%s: %s", ex.getClass().getSimpleName(), ex.getMessage());
        }
    }
}
