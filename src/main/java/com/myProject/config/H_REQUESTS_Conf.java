package com.myProject.config;

import com.myProject.model.H_REQUESTS;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Optional;

@Repository
public class H_REQUESTS_Conf implements CrudRepository<H_REQUESTS, Integer> {

    @Autowired
    DataSource dataSource;
    @Autowired
    NamedParameterJdbcTemplate namedParameter;
    @Autowired
    PlatformTransactionManager transactionManager;
    @SneakyThrows
    @Override
    public <S extends H_REQUESTS> S save(S entity) {

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into H_REQUESTS(IDMEH, IDMAG, IDDIS, STATUS, DESC, NAME, CHEK)values('" + entity.getIDMEH() + "', '" + entity.getIDMAG() + "', '" + entity.getIDDIS() + "', '" + entity.getSTATUS() + "', '" + entity.getDESC() + "', '" + entity.getNAME() + "', '" + entity.isCHEK() + "')");

        statement.execute();
        connection.close();

        return entity;
    }
    @SneakyThrows
    public <S extends H_REQUESTS> S update(S entity) {

        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("update H_REQUESTS set DESC = '" + entity.getDESC() + "', STATUS = '" + entity.getSTATUS() + "'WHERE H_REQUESTS.ID = '" + entity.getID() + "'");

        statement.execute();
        connection.close();

        return entity;
    }


    @Override
    public <S extends H_REQUESTS> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<H_REQUESTS> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public Iterable<H_REQUESTS> findAll() {
        return null;
    }

    @Override
    public Iterable<H_REQUESTS> findAllById(Iterable<Integer> integers) {
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
    public void delete(H_REQUESTS entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends H_REQUESTS> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
