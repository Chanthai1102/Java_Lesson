package FileInputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class FileInputStreamDemo {
    public static void main(String[] args){
        byte[] data = new byte[100];
        try{
            InputStream input = new FileInputStream("C:/Users/Public/Documents/data.txt");
            System.out.println(input.available());
            input.read(data);
            //System.out.println(Arrays.toString(data));
            for (byte b : data){
                System.out.print((char)b);
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
