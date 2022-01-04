package com.example.zadanie6try100500balyka;

public class TaskStorage {

    private static TaskStorage taskStorage;
    private static String names[];
    private static boolean isDone[];

    public static TaskStorage takeTaskStorage() {
        if (taskStorage == null)
        {
            taskStorage = new TaskStorage();
            names = new String[100];
            names[0] = "pierwszy";
            names[1] = "drugi";
            names[2] = "trzeci";
            names[3] = "czwarty";
            names[4] = "piaty";
            isDone = new boolean[100];
            isDone[0] = true;
            isDone[1] = true;
            isDone[2] = false;
            isDone[3] = true;
            isDone[4] = true;
        }
        return taskStorage;
    }

    public static String[] getNames() {
        return names;
    }

    public static boolean[] getIsDone()
    {
        return isDone;
    }
}
