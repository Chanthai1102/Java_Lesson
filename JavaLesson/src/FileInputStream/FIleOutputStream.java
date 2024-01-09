package FileInputStream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class FIleOutputStream {
    public static void main(String[] args){
        try {
            String text = "Thy Chanthai";
            OutputStream output = new FileOutputStream("C:/Users/Public/Documents/dataOutput.txt",true);
            output.write(text.getBytes());
            output.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
