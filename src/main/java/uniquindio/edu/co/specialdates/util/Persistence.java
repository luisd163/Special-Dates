package uniquindio.edu.co.specialdates.util;

import java.io.*;

public class Persistence {

    public static void serializeObject(String path, Object object) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(object);
        oos.close();
    }

    public static Object deserializeObject(String path) throws Exception{


        if(!new File(path).exists()){
            return null;
        }


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Object object = ois.readObject();
        ois.close();


        return object;
    }
}
