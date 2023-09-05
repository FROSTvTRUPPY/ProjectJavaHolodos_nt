package com.myProject.config;

import com.myProject.model.H_USERS;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class H_USERS_Conf implements CrudRepository<H_USERS, Integer>{

    @Autowired
    DataSource dataSource;
    @Autowired
    NamedParameterJdbcTemplate namedParameter;
    @Autowired
    PlatformTransactionManager transactionManager;

    @SneakyThrows

    @Override
    public <S extends H_USERS> S save(S entity) {
        return null;
    }

    @Override
    public <S extends H_USERS> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<H_USERS> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @SneakyThrows
    @Override
    public List<H_USERS> findAll() {

        List<H_USERS> h_users = new ArrayList<>();

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT H_USERS.ID AS ID, H_USERS.LOGG AS LOGG, H_USERS.PASS AS PASS, H_USERS.ID_POST AS ID_POST, H_USERS.NAME_FIRST AS NAME_FIRST, H_USERS.NAME_LAST AS NAME_LAST, H_USERS.PHONENUM AS PHONENUM, H_USERS.STAT AS STAT FROM H_USERS");
        ResultSet rs =  statement.executeQuery();
        while (rs.next()){
            H_USERS user = new H_USERS();
            user.setID(rs.getInt(1));
            user.setLOGG(rs.getString(2));
            user.setPASS(rs.getString(3));
            user.setID_POST(rs.getInt(4));
            user.setNAME_FIRST(rs.getString(5));
            user.setNAME_LAST(rs.getString(6));
            user.setPHONENUM(rs.getString(7));
            user.setSTAT(rs.getBoolean(8));
            h_users.add(user);

        }
        connection.close();
        return h_users;
    }

    @Override
    public Iterable<H_USERS> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(H_USERS entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends H_USERS> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
