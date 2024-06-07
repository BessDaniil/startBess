//package org.example.demodanya.try2.repository;
//
//import org.example.demodanya.try2.models.Authors;
//import org.springframework.jdbc.core.RowMapper;
//import org.springframework.stereotype.Component;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//@Component
//public class AuthorsMapper implements RowMapper<Authors> {
//    @Override
//    public Authors mapRow(ResultSet rs, int rowNum) throws SQLException {
//        return new Authors(
//                rs.getInt("id"),
//                rs.getString("name"),
//                rs.getString("biography"),
//                rs.getDate("birth_date")
//        );
//    }
//
//}
