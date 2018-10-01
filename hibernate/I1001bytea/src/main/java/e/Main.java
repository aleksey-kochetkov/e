package e;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;

/**
 * I. Прочитать файл image.png, сохранить в БД. Из БД сохранить в файл
 * jdbc.png.
 * II. То же самое с помощью hibernate, hb.png.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length == 0 || !args[1].equals("h")) {
            try (JdbcRepository repository = new JdbcRepository().init()) {
                repository.deleteAllFileEntities();
                new Main(repository).run();
            }
        }
        if (args.length == 0 || args[1].equals("h")) {
            try (Repository repository = new HbRepository()) {
                new Main(repository).run();
            }
        }
    }

    private Repository repository;

    Main(Repository repository) {
        this.repository = repository;
    }

    void run() throws Exception {
        String name = "image.png";
        FileEntity entity = new FileEntity(name,
                            Files.readAllBytes(new File(name).toPath()));
        this.repository.createFileEntity(entity);
        this.repository.updateFileEntity(name);
        entity = this.repository.find();
        try (FileOutputStream out = new FileOutputStream(
                                           new File(entity.getName()))) {
            out.write(entity.getBytes());
        }
    }
}
