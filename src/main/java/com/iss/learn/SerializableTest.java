package com.iss.learn;

import com.iss.learn.records.Policy;

import java.io.*;

public class SerializableTest {

    static Policy policy1 = new Policy(1, "Policy 1", 10, 0.1);
    static Policy policy2 = new Policy(2, "Policy 2", 20, 0.2);
    static Policy policy3 = new Policy(3, "Policy 3", 30, 0.3);
    static Policy policy4 = new Policy(4, "Policy 4", 40, 0.4);

    public static void main(String[] args) {
        String policyFile = "./policy.ser";
        writeFiles(policyFile);
        readFiles(policyFile);
    }

    public static void writeFiles(String fileName) {
        try (FileWriter fileWriter = new FileWriter(fileName, true)) {

            FileOutputStream fileOut = new FileOutputStream(fileName, false);
            PrintStream out2 = new PrintStream(fileOut, true);
            out2.println(policy2);
            System.out.println("Policy saved to file using FileOutputStream: " + fileName);
            out2.close();
            fileOut.close();

            fileWriter.write(policy3.toString());
            fileWriter.write(policy4.toString());
            fileWriter.close();

            PrintStream out = new PrintStream(fileOut); //PrintStream by default deletes the file unless we use another stream athat supports append like FileOutputStream
            out.append(policy1.toString());
            System.out.println("Policy saved to file: " + fileName);
            out.close();

        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException: " + e.getMessage() + ".");
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage() + ".");
        } finally {
            System.out.println("Done.");
        }
    }

    public static void readFiles(String fileName) {
        try (InputStreamReader read = new InputStreamReader(System.in);
             BufferedReader in = new BufferedReader(read);
             FileReader fileReader = new FileReader(fileName)) {

            // lectura de input
            System.out.println("Enter your name:");
            String name = in.readLine();
            System.out.println("you entered: " + name + ".");

            System.out.println("Select file to open");
            System.out.println("1. policy.ser");
            System.out.println("2. temps.txt");

            String opt = in.readLine();

            if (opt.equals("1")) {
                //lectgura de archivo
                BufferedReader inFile = new BufferedReader(fileReader);
                String line;
                while ((line = inFile.readLine()) != null) {
                    System.out.println(line);
                }
            } else if (opt.equals("2")) {
                FileReader file2 = new FileReader("./temps.txt");
                System.out.println("Prueba con fileReader directo: " + (char)file2.read());

                System.out.println("prueba con bufferrereader");
                BufferedReader fileReader2 = new BufferedReader(file2);
                String line;
                String headers = fileReader2.readLine();
                System.out.println("reading from file, headers:");
                System.out.println(headers);
                System.out.println("------------------------------");
                int counter = 0;
                double sum = 0.0;
                while((line = fileReader2.readLine()) != null) {
                    counter++;
                    System.out.println(line);
                    String cleanedUp = line.replaceAll("[^0-9]", "");
                    sum += Double.parseDouble(cleanedUp);
                    System.out.println("reading double; " + sum);
                }
                System.out.println("""
                        --------------------------------------""");
                System.out.println("------------  summary  --------------");
                System.out.println("--------------------------------------");
                System.out.println("counter: " + counter);
                System.out.println("sum: " + sum);
                System.out.println("average: " + sum/counter);

            }

        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage() + ".");
        }
    }
}
