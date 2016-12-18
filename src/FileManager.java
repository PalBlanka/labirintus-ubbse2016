import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileManager {
    
    private static BufferedReader in;
    private static BufferedWriter out;
    private static File source;
    
    public FileManager(String filePath) {
    	source = new File(filePath);
    }

    public void openFileRead() {
        try {
            in = new BufferedReader(new FileReader(source));
        } catch (IOException e) {
            System.out.println("Error - Read");
        }
    }
       
    public void closeFileRead() {
        try {
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public String readFromFile() {
        String text = null;
        try {
            text = in.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return text;
    }
    
    public static void openFileWrite() {
        try {
        	out = new BufferedWriter(new FileWriter(source));
        } catch (IOException e) {
            System.out.println("Error - Read");
        }
    }
       
    public static void closeFileWrite() {
        try {
        	out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void writeInFile(String line) {
        try {
            out.write(line+" ");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void writeLn() {
        try {
            out.write("\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void toList(List<String> feladvanyok) {
    	String readed = null;
    	feladvanyok.clear();
    	
    	openFileRead();
    	
    	while ((readed = readFromFile()) != null)
        	feladvanyok.add(readed);
    	
    	closeFileRead();
    }
    public void delete(String nev){
    	 File logFile=new File(nev);

    	    BufferedWriter writer;
			try {
			
				writer = new BufferedWriter(new FileWriter(nev));
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	    
    }
}