

public class Change{
  private String orgNum;
  private String encNum;
  private String dycNum;
  private int changeO;
  private int changeT;
  private int [] num = new int[4];
  
  //Change constructor
  public Change(){
    //creates the change object
  }
  
  //method that takes the number and encrypts it
  public String encrypt(String number){ 
    // checks the length is 4
    if (number.length() == 4){
      // for loop that separates each digit, turns into a integer, and does the encryption. 
      for(int i =0; i <= 3; i++){
        num[i] = ((Integer.parseInt(Character.toString(number.charAt(i)))) +7)%10 ;
      }
      //Switches the first digit and thrid digit; 
      changeO = num[2];
      num[2]=num[0];
      num[0]= changeO;

      //Switches the second and fouth digit
      changeT = num[3];
      num[3]=num[1];
      num[1]=changeT;
      encNum = new String();
      //turns the digits to String and adds them together
      for(int j =0; j <= 3; j++){
        encNum = encNum + (Integer.toString(num[j]));
      }
    }
    // returns the encrypted number
    return encNum ; 
  }
  //method that takes the number and decrypts it
  public String decrypt(String given){
    // checks the length is 4
    if( given.length() == 4){
      // for loop that separates each digit, turns into a integer
      for(int i =0; i <= 3; i++){
        num[i] = Integer.parseInt(Character.toString(given.charAt(i)));
      }
      //Switches the first digit and thrid digit; 
      changeO = num[2];
      num[2]=num[0];
      num[0]= changeO;

      //Switches the second and fouth digit
      changeT = num[3];
      num[3]=num[1];
      num[1]=changeT;
      // reverses the encryption
      for(int i =0; i <= 3; i++){
        num[i] = (num[i]+3)%10 ;
      }
      //turns the digits to String and adds them together
      dycNum = new String();
      for(int j =0; j <= 3; j++){
        dycNum = dycNum + (Integer.toString(num[j]));
      }
    }
    // returns the decrypted number
  return dycNum ;
  }

  
  
}
