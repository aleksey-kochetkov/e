package e;

public interface Repository extends AutoCloseable {
    void createFileEntity(FileEntity entity) throws Exception;
    void updateFileEntity(String old) throws Exception;
    FileEntity find() throws Exception;
}
