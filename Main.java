import java.util.Scanner; 

public class Main {
  public static void main(String[] args) {
    String fileName = "Nums.txt"; // File with the numbers 
    String EncodedFile = "encoded.txt" ; // name of the file were encrypted/decoded messages will be placed
    int length ; // variable for count of numbers in given file
    
    Files list = new Files(fileName);
    Change messages = new Change();
    Scanner input = new Scanner(System.in);

    //Gets number if given numbers to be encrypted/decrypted
    length = list.getLength(fileName);
    //Gets the numbers in the text file and puts them into a String array
    String[] text = (list.getValues(fileName));

    //Asks the user if they want to decrypt or encrypt the numbers
    System.out.print("-------------------------------------------------\nWould you like to decrypt or encrypt the numbers. \n-------------------------------------------------\n");
    String key = input.nextLine();
    
    String newZ;
    // goes through the array and based of response of the user decrypt/ encrypts all the numbers and adds them to the file listed
    for(int i =0; i<= length-1; i++){
      /*if((key.toLowerCase()).equals("encrypt")){
          newZ = messages.encrypt(text[i]);
          text[i] = newZ;
          list.addToText(EncodedFile,newZ);
        
      }else*/ if((key.toLowerCase()).equals("decrypt")){
          newZ = messages.decrypt(text[i]);
          text[i] = newZ;
          list.addToText(EncodedFile,newZ);
        
      }else{
        return; 
      }
        
    }
    System.out.print("--------------\nFinished\n--------------");
  }
}
