/**
@author Hridika Banik <a 
href="mailto:hridika.banik@ucalgary.ca">firstname.lastname@ucalgary.ca</a>
@version 1.6
@since 1.0
UCID: 30123716
Tutorial number: T05
TA Name: Roghayeh Heidari
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.text.DecimalFormat;
public class Assign5{
    public static void main(String[] args) throws IOException { 
        if (args.length != 3) {
            System.out.println("Arguments are of invalid number. Enter again.");
            System.exit(1);
        }
        String inputFile = args[0] + ".txt"; 
        String output1 = args[1] + ".txt" ;
        String output2 = args[2] + ".txt" ;
        ArrayList<String> Arrstr = new ArrayList<>();
        /*This code has been adapted from:
        Reference: https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java
        */
        try {
            File myFile = new File(inputFile);
            Scanner myReader = new Scanner(myFile);
                while (myReader.hasNextLine()) {
                    String data = myReader.nextLine();
                    Arrstr.add(data);
                    
                }
            myReader.close();
            } 
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
          }
          int num = 0;
          int init = (int) (Arrstr.size() * 1.4);

          for(int x = init;x > 0; x-- ){
              int flag = 1;
              for(int y = 2; y < x; y++){
                if(x % y  == 0){
                    flag = 0;
                    break;
                }
              }
              if(flag == 1){
                num = x;
                break;
              }
          }
        HashTable hashtable = new HashTable(num, "l");
        HashTable hashq = new HashTable(num, "q");
        for(int m = 0; m < Arrstr.size(); m++){
            hashtable.add(Arrstr.get(m));
            hashq.add(Arrstr.get(m));}
        DecimalFormat decfor = new DecimalFormat("00.00");
        DecimalFormat dec = new DecimalFormat("0.00");
        hashtable.LoadFactor();
        hashtable.HashEffeciency();
        hashtable.longestChain();
        hashq.LoadFactor();
        hashq.HashEffeciency();
        hashq.longestChain();
        /* This code has been adapted from:
        Reference: https://jenkov.com/tutorials/java-io/filewriter.html
        */
        try{
            FileWriter writeopt1 = new FileWriter(output1);
            FileWriter writeBONUS = new FileWriter(output2);
            writeopt1.write("Statistics of Linear probing=" + '\n');
            writeopt1.write('\n');
            writeopt1.write("Average reads/record=" + dec.format(hashtable.rRecord()) + '\n' );
            writeopt1.write("Longest chain= " + hashtable.longestChain() + '\n');
            writeopt1.write("Hash Efficiency is= " + decfor.format(hashtable.HashEffeciency()) + " %" + '\n');
            writeopt1.write("Load Factor i=:" + decfor.format(hashtable.LoadFactor()) + " %" + '\n');
            writeopt1.close();
            writeBONUS.write("Output of Bonus Part" + '\n');
            writeBONUS.write("Statistics for Quadratic probing=" + '\n');
            writeBONUS.write('\n');
            writeBONUS.write("Average reads/record=" + dec.format(hashq.rRecord()) + '\n' );
            writeBONUS.write("Longest chain= " + hashq.longestChain() + '\n');
            writeBONUS.write("Hash Efficiency is= " + decfor.format(hashq.HashEffeciency()) + " %" + '\n');
            writeBONUS.write("Load Factor is=" + decfor.format(hashq.LoadFactor()) + " %" + '\n');
            writeBONUS.close();

          }
          catch(IOException e){e.printStackTrace();}
          String[] size = new String[Arrstr.size()];
          for(int i = 0; i < Arrstr.size();i++){
            size[i] = Arrstr.get(i);
          }
        }
        
}

