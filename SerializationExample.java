import java.io.*;

class Dog implements Serializable {
    private static final long serialVersionUID = 1L;
    int i = 10;
    int j = 20;
}

public class SerializationExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Serialization (Sender part)
        Dog d = new Dog();
        FileOutputStream fos = new FileOutputStream("abc.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(d);
        oos.close();
        fos.close();
        System.out.println("Serialization done.");

        // Deserialization (ReceiverApp part)
        FileInputStream fis = new FileInputStream("abc.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Dog d2 = (Dog) ois.readObject();
        ois.close();
        fis.close();

        // Output the deserialized object’s data
        System.out.println(d2.i + "=====>" + d2.j);
    }
}
