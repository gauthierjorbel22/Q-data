
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Gauthier
 */
public final class DataFile {

    private String data;

    public DataFile() throws IOException {
        data = arrayToString(fileData);
        openFile();

    }

    public String getData() {
        return data;
    }

    public int[][] getFileData() {
        return fileData;
    }

    int[][] fileData = {{76, 81, 72, 76, 85, 85},
    {87, 76, 88, 83, 76, 87},
    {86, 54, 40, 3, 2, 1},
    {72, 89, 55, 62, 68, 77},
    {94, 63, 92, 45, 75, 99},
    {85, 95, 88, 100, 60, 85},
    {76, 84, 10, 94, 75, 74},
    {57, 49, 58, 67, 80, 56}};

    public String arrayToString(int[][] array) {
        String stFile = "";
        for (int[] rowArray : array) {
            for (int col : rowArray) {
                stFile += col + " ";
            }
//            stFile += "\n";
            stFile += "\n";
        }
        return stFile;
    }

    public void openFile() throws IOException {
        File file = new File("qdata.txt");
//         FileWriter fileWriter = new FileWriter("qdata.txt");
        FileOutputStream output=new FileOutputStream(file);
         
        BufferedWriter bfWriter = new BufferedWriter(new OutputStreamWriter(output));
        String[] token = getData().split("\n");

        for (String line : token) {
//            System.out.println(line);
            bfWriter.write(line);
            bfWriter.newLine();
        }
        bfWriter.close();

        /* try {
         
         fileWriter.write(getData());
         fileWriter.close();
         } catch (IOException ex) {
         Logger.getLogger(DataFile.class.getName()).log(Level.SEVERE, null, ex);
         }
         */
    }

}
