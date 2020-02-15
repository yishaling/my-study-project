package javaio;

import java.io.*;

public class IoTest {
    public static void main(String[] args) throws Exception{
        new BufferedReader(new FileReader(""));
        FileInputStream fileInputStream = new FileInputStream(new File(""));
        fileInputStream.read(new byte[1024]);
        FileOutputStream fileoutputStream = new FileOutputStream(new File(""));
        fileoutputStream.write(new byte[1024]);

        new BufferedInputStream(new FileInputStream(new File("")));
    }
}
