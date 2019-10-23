package creators;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriter<T> {

    private final File FILE;
    private List<T> elements;

    public ReadWriter(String filePath) {
        this.FILE = new File(filePath);
        this.elements = new ArrayList<>();

        try {
            deserialize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void serialize(T element) throws IOException {
        try (ObjectOutputStream showsStreamOut = new ObjectOutputStream(new FileOutputStream(FILE))) {
            this.elements.add(element);
            showsStreamOut.writeObject(this.elements);
        }
    }

    public void update() throws IOException {
        try (ObjectOutputStream showsStreamOut = new ObjectOutputStream(new FileOutputStream(FILE))) {
            showsStreamOut.writeObject(this.elements);
        }
    }



    public void serialize(List<T> elementList) throws IOException {
        try (ObjectOutputStream showsStreamOut = new ObjectOutputStream(new FileOutputStream(FILE))) {
            this.elements.addAll(elementList);
            showsStreamOut.writeObject(this.elements);
        }
    }


    public void deserialize() throws IOException {
        if(FILE.exists()) {
            try (ObjectInputStream showsStreamIn = new ObjectInputStream(new FileInputStream(FILE))) {
                this.elements.addAll((List<T>) showsStreamIn.readObject());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public List<T> getList() {
        return elements;
    }

}
