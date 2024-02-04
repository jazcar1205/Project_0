import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.*;

public class Files{
  private int listLength;
  private File myFile ;
  private Scanner myReader;
  // constructor that creates a scanner with given file
  public Files(String fileName){
       resetScan(fileName);
    }
  // goes through the text file and counts how many lines there are with numbers
  public int getLength(String doc){
      resetScan(doc);
      while (myReader.hasNextLine()) {
        myReader.nextLine();
        listLength++;
      }
      return listLength;
    }
  // gets the values of each line for the given text file
  public String[] getValues(String txtFile){
      resetScan(txtFile);
      String[] values = new String[listLength];   
      
      for(int i =0; i<=listLength-1; i++){
        if(myReader.hasNextLine()){
          String data = myReader.nextLine();
          values[i] = data;
        }
      }
      myReader.close();
      return values;
    }
  // resets the Scanner to the file given
  public void resetScan(String file){
    myFile = new File(file);
      try {
        myReader = new Scanner(myFile);
      } catch(FileNotFoundException error) {
        System.out.println("File not found.");
        }
  }
// Adds the text given to the document given 
  public void addToText(String doc, String text){
    try(FileWriter fw = new FileWriter(doc, true);
    BufferedWriter bw = new BufferedWriter(fw);
    PrintWriter out = new PrintWriter(bw))
    {
      out.println(text);
      
    } catch (IOException e) {
     e.printStackTrace();
}
  }

}