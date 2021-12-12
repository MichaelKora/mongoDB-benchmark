import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
    private String fileName;
    private FileWriter csvWriter;

    public DataWriter(String name) {
        this.fileName = name;
        try {

            csvWriter = new FileWriter(this.fileName);
            csvWriter.append("TimeZone");
            csvWriter.append(",");
            csvWriter.append("Start");
            csvWriter.append(",");
            csvWriter.append("End");
            csvWriter.append(",");
            csvWriter.append("Command");
            csvWriter.append("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeLine(String[] line) {
        //String start, String end, String type:insert/delete/modify
        try {
            csvWriter.append(String.join(",", line));
            csvWriter.append("\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeWriter() {
        try {
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
