package e;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class JdbcStorage {
    private final JdbcTemplate template;

    public JdbcStorage(JdbcTemplate template) {
        this.template = template;
    }

    public User add(User user) {
        this.template.update(
          new PreparedStatementCreator() {
              @Override
              public PreparedStatement createPreparedStatement(
                             Connection connection) throws SQLException {
                  PreparedStatement prepared =
                                             connection.prepareStatement(
                                       "INSERT INTO uzer VALUES (?, ?)");
                  prepared.setString(1, user.getLogin());
                  prepared.setString(2, user.getName());
                  return prepared;
              }
          }
        );
        return user;
    }

    public List<User> findAll() {
        return this.template.query("SELECT * FROM uzer",
                                  new BeanPropertyRowMapper(User.class));
    }

    public void clean() {
        this.template.update(
          new PreparedStatementCreator() {
              @Override
              public PreparedStatement createPreparedStatement(
                             Connection connection) throws SQLException {
                  PreparedStatement prepared =
                         connection.prepareStatement("DELETE FROM uzer");
                  return prepared;
              }
          }
        );
    }
}
