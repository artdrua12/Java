package main.homework.lesson17;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WorkWichFiles {
    public static void writeFile(List<String> listName, List<String> list) {

        String name = getName(listName);

        try {
            File outputFile = new File("src/main/homework/lesson17/" + name);
            FileOutputStream outputStream = new FileOutputStream(outputFile, false);
            for (String el : list) {
                byte[] strToBytes = (el + "\n").getBytes();
                outputStream.write(strToBytes);
            }
            outputStream.close();
            System.out.println("Итоговый файл " + name + " создан!");
        } catch (FileNotFoundException e) {
            System.err.println("FileStreamsTest: " + e);
        } catch (IOException e) {
            System.err.println("FileStreamsTest: " + e);
        }
    }

    private static String getName(List<String> name) {
        StringBuffer sBufferName = new StringBuffer();

        for (String lst : name) {
            sBufferName.append(lst);
        }
        return sBufferName.toString() + ".txt";
    }
}
