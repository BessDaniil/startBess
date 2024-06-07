//package org.example.demodanya.try2.repository;
//
//import org.example.demodanya.try2.models.Authors;
//import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
//import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class AuthorsRepositoryImpl implements AuthorsRepository {
//    private static final String SQL_GET_AUTHORS_BY_ID = "SELECT name, biography, birth_date FROM authors WHERE name = :name";
//    private static final String SQL_INSERT_AUTHORS = "insert into authors (name, biography, birth_date) values (:name, :biography, :birth_date)";
//    private static final String SQL_UPDATE_AUTHORS = "update authors biography = :biography, birth_date = :birth_date where name = :name";
//    private static final String SQL_DELETE_AUTHORS = "delete from authors where name like :name";
//
//
//    private final AuthorsMapper authorsMapper;
//    private final NamedParameterJdbcTemplate jdbcTemplate;
//
//    public AuthorsRepositoryImpl(AuthorsMapper authorsMapper, NamedParameterJdbcTemplate jdbcTemplate) {
//        this.authorsMapper = authorsMapper;
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    @Override
//    public Optional<Authors> getAuthorsById(String name) {
//        var params = new MapSqlParameterSource();
//        params.addValue("name", name);
//        return jdbcTemplate.query(SQL_GET_AUTHORS_BY_ID, params, authorsMapper).stream().findFirst();
//    }
//
//    @Override
//    public void insertAuthors(String name, String biography, Date birthDate) {
//        var params = new MapSqlParameterSource();
//        params.addValue("name", name);
//        params.addValue("biography", biography);
//        params.addValue("birth_date", birthDate);
//        jdbcTemplate.update(SQL_INSERT_AUTHORS, params);
//    }
//
//    @Override
//    public void updateAuthors(String biography, Date birthDate, String name) {
//        var params = new MapSqlParameterSource();
//        params.addValue("name", name);
//        params.addValue("biography", biography);
//        params.addValue("birth_date", birthDate);
//        jdbcTemplate.update(SQL_UPDATE_AUTHORS, params);
//    }
//
//    @Override
//    public void deleteAuthorsById(String name) {
//        var params = new MapSqlParameterSource();
//        params.addValue("name", name);
//        jdbcTemplate.update(SQL_DELETE_AUTHORS, params);
//    }
//
//}
