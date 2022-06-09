package File;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class InitializeData {
    public void writeListToFile(String file, List list) throws IOException {
        FileWriter writer = new FileWriter(file, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        try {
            for (Object obj: list
                 ) {
                bufferedWriter.write(obj + System.lineSeparator());
            }
        }
        catch (IOException e){
            System.out.println(e);
        }finally {
            bufferedWriter.close();
        }
    }

    public void readListFromFile(String file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try{
            List<Object> objects = (ArrayList<Object>) ois.readObject();
        }catch (IOException e){
            System.out.println(e);
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        finally {
            fis.close();
            ois.close();

        }


    }
}
