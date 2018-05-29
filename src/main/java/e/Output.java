package e;

import java.io.Console;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class Output {
    private static final PrintStream out = getPrintStream();

    public static void println(String line) {
        out.println(line);
    }

    public static void format(String format, Object... args) {
        out.format(format, args);
    }

    public static void println() {
        out.println();
    }

    private static PrintStream getPrintStream() {
        PrintStream result = null;
        try {
            Class<Console> clazz = Console.class;
            Method method = clazz.getDeclaredMethod("encoding");
            method.setAccessible(true);
            String encoding = (String) method.invoke(null);
            if (false && "cp866".equals(encoding)) {
                result = new PrintStream(System.out, true, "cp866");
            }
        } catch (NoSuchMethodException
             | UnsupportedEncodingException | IllegalAccessException
             | InvocationTargetException exception) {
      exception.printStackTrace();
      System.exit(1);
      }
        if (result == null)
            result = System.out;
        return result;
    }
}