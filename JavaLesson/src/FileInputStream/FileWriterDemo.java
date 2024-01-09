package FileInputStream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileWriterDemo {
    public static void main(String[] args){
        try {
            String text = "Hello i am me ";
            Writer writer = new FileWriter("C:/Users/Public/Documents/dataOutput.txt");
            writer.write(text);
            writer.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
