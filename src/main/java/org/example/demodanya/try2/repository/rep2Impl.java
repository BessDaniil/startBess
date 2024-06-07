//package org.example.demodanya.try2.repository;
//
//import jakarta.websocket.Session;
//import org.example.demodanya.try2.models.Authors;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//
//import java.util.List;
//
//public class rep2Impl implements rep2 {
//    private static final String SQL_GET_AUTHORS_BY_NAME = "SELECT name, biography, birth_date FROM authors WHERE name = :name";
//
//    private final AuthorsMapper authorsMapper;
//    private final NamedParameterJdbcTemplate jdbcTemplate;
//
//    public rep2Impl(AuthorsMapper authorsMapper, NamedParameterJdbcTemplate jdbcTemplate) {
//        this.authorsMapper = authorsMapper;
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//public List<Authors>getAuthorsByName(String name) {
//var params = new MapSqlParameterSource();
//params.addValue("name", name);
//return jdbcTemplate.query(SQL_GET_AUTHORS_BY_NAME, params, authorsMapper);
//}
//}
