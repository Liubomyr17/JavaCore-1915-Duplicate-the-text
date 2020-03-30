package com.company;

/*

1915 Duplicate the text
Read the file name from the console.
In the main method, replace the System.out object with the reader wrapper you wrote, similar to a lecture.
Your reader wrapper should duplicate the output of all text to a file whose name you counted.
Call the ready printSomething () method, use testString.
Return the System.out variable to its original stream.
Close the file stream.
Screen output example:
it's a text for testing
Example file body:
it's a text for testing

Requirements:
1. The Solution class must contain the TestString class.
2. The Solution class must contain a public static field testString of type TestString, which is immediately initialized.
3. The TestString class must contain the public void method printSomething ().
4. The printSomething () method of the TestString class should display the string "it's a text for testing".
5. In the main (String [] args) method, the program should read the file names from the console (use BufferedReader).
6. In the main (String [] args) method, the BufferedReader must be closed to read data from the console.
7. The main (String [] args) method of the Solution class should create a PrintStream stream (use PrintStream with the ByteArrayOutputStream constructor parameter).
8. The main (String [] args) method of the Solution class should replace and restore the output stream to the console of the System.out object.
9. The main (String [] args) method of the Solution class should call the printSomething () method of the testString object.
10. The main (String [] args) method of the Solution class should write to the file the string output by the printSomething () method (use FileOutputStream), and duplicate it to the console.
11. The stream of writing to the file (FileOutputStream) should be closed.

*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = conReader.readLine();
        conReader.close();


        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);

        testString.printSomething();
        //Возвращаем как было
        System.setOut(consoleStream);

        //Пишем в файл
        FileOutputStream outFile = new FileOutputStream(fileName1);
        outputStream.writeTo(outFile);
        System.out.println(outputStream.toString());


        outFile.close();
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}





