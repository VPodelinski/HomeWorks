import com.sun.org.apache.xml.internal.security.utils.UnsyncBufferedOutputStream;

import java.io.*;
import java.util.Random;

/**
 * Created by viivpo2010 on 23.7.17.
 */
public class EX32 {
    public static void main(String[] args) {
        Random random = new Random(20);
        try (DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("/home/viivpo2010/ex32.dat")));
             DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("/home/viivpo2010/ex32.dat")))){
            for(int i = 0; i < 20; i++){
                dataOutputStream.writeInt(random.nextInt(20));
                dataOutputStream.flush();
                //System.out.println("Write ok");
            }
            while (dataInputStream.available()>0){
                int data = dataInputStream.readInt();
                System.out.println("Read "  + data);
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        catch (IOException e){
            System.out.println("Another exeption");
        }
    }
}
