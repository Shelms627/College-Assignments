
package filesplitter;
import java.io.*;

/**
 *
 * @author shelm
 */
public class FileSplitter {

    public static void main(String[] args) throws Exception{
        //checks for correct number of arguments
        if (args.length != 2) {
            System.out.println("Usage: java FileSplitter SourceFile numberOfPieces");
            System.exit(0);
        }
        
        //create input stream for source file.
        BufferedInputStream input = new BufferedInputStream(new FileInputStream(new File(args[0])));
        
        //get number of pieces.
        int numberOfPieces = Integer.parseInt(args[1]);
        
        //Output file size.
        System.out.println("File size: " + input.available() + "bytes");
        
        //use long variables to determine the size of each chunk
        long fileSize = input.available();
        long splitFileSize = (int) Math.ceil(1.0 * fileSize / numberOfPieces);
        
        //create files
        for (int i = 1; i <= numberOfPieces; i++) {
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(new File(args[0] + "." + i)));
            
            //prepare two integers
            int value;
            int count = 0;
            
            //write to file until the necessary file size is reached
            while (count++ < splitFileSize && (value = input.read()) != -1) {
                output.write(value);
            }
            
            //close output
            output.close();
        }
        //close input
        input.close();
    }
    
}
