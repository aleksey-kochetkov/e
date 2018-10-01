package e;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcRepository implements Repository {
    static private final String NW = "jdbc.png";
    private Connection connection;

    @Override
    public void close() throws SQLException {
        this.connection.close();
    }

    @Override
    public void createFileEntity(FileEntity entity) throws SQLException {
        try (PreparedStatement prepared = this.connection
            .prepareStatement("INSERT INTO file_entity VALUES (?, ?)")) {
            prepared.setString(1, entity.getName());
            prepared.setBytes(2, entity.getBytes());
            prepared.executeUpdate();
        }
    }

    @Override
    public void updateFileEntity(String old) throws SQLException {
        try (PreparedStatement prepared =
                                        this.connection.prepareStatement(
                     "UPDATE file_entity SET name = ? WHERE name = ?")) {
            prepared.setString(1, NW);
            prepared.setString(2, old);
            prepared.executeUpdate();
        }
    }

    @Override
    public FileEntity find() throws SQLException {
        FileEntity result = null;
        try (PreparedStatement prepared =
                                        this.connection.prepareStatement(
                           "SELECT * FROM file_entity WHERE name = ?")) {
            prepared.setString(1, NW);
            ResultSet rs = prepared.executeQuery();
            while (rs.next()) {
                result = new FileEntity(rs.getString("name"),
                                                   rs.getBytes("bytes"));
            }
        }
        return result;
    }

    public JdbcRepository init() throws SQLException {
        this.connection = DriverManager.getConnection(
                   "jdbc:postgresql:I1001bytea", "postgres", "password");
        return this;
    }

    public void deleteAllFileEntities() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("DELETE FROM file_entity");
        }
    }
}
