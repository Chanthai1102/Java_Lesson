package PracticeFileIO.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileService  {
    private static String fileName = "C:/Users/Public/Documents/Student/students.txt";
    public static void saveToFile(String data){
        File file = new File(fileName);
        try {
            FileWriter fileWriter = new FileWriter(file,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.newLine();
            bufferedWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static List<String> readData(){
        File file = new File(fileName);
        List<String> dataList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = null;
            do {
               line = bufferedReader.readLine();

            }while (line != null);
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }
}
