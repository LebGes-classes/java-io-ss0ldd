package org.example;

public class Main {
    public static void main(String[] args) {
        Deserialization ds = new Deserialization();
        unitingData dp = new unitingData(ds.readFile("C:\\Users\\cscsm\\IdeaProjects\\JSON2\\src\\main\\java\\org\\example\\start.csv"));
        Serialization sr = new Serialization(dp.updateData());
        sr.convertToJson();
    }

}