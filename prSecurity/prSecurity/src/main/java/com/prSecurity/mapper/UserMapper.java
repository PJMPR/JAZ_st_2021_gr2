package com.prSecurity.mapper;

import org.springframework.jdbc.core.RowMapper;
import com.prSecurity.model.User;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("ID"));
        user.setName(rs.getString("Name"));
        user.setLogin(rs.getString("Login"));
        user.setPassword(rs.getString("Password"));
        return user;
    }
}