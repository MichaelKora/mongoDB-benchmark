import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
    private  String path;
    private File file;
    private FileWriter outputFile;
    private CSVWriter writer;


    public DataWriter(String path) {
        this.path = path;
        file = new File(path);

        try {
            outputFile = new FileWriter(file);
            writer = new CSVWriter(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(String [] line) {
        //String start, String end, String type:insert/delete/modify
        writer.writeNext(line);
    }

    public void closeWriter(){
        try {
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
