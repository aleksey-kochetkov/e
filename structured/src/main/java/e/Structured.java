package e;

import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Structured {
    public static void main(String[] args) {
        new Structured().run(args);
    }

    public void run(String[] args) {
        XML xml = new XML();
        xml.read();
        xml.print(args.length == 0 ? null : args[0], args.length > 1);
    }
}
