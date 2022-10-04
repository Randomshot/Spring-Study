package org.example;

import static org.example.ModelSqls.*;
import org.example.Model;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.EmptySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

@Repository
public class ModelDao {
    private NamedParameterJdbcTemplate jdbc;
    private SimpleJdbcInsert insertAction;
    private RowMapper<Model> rowMapper = BeanPropertyRowMapper.newInstance(Model.class);

    public ModelDao(DataSource dataSource){
        this.jdbc = new NamedParameterJdbcTemplate(dataSource);
        this.insertAction = new SimpleJdbcInsert(dataSource)
                .withTableName("model");
    }

    public List<Model> selectAll(){
        return jdbc.query(SELECT_ALL,rowMapper);
    }

    public int insert(Model model){
        SqlParameterSource params = new BeanPropertySqlParameterSource(model);
        return insertAction.execute(params);
    }

    public int deleteByModelName(String modelname){
        Map<String, ?> params = Collections.singletonMap("modelname",modelname);
        return jdbc.update(DELETE_BY_MODEL_NAME,params);
    }

    public Model selectByModelName(String modelname){
        try{
            Map<String, ?> params = Collections.singletonMap("modelname",modelname);
            return jdbc.queryForObject(SELECT_BY_MODEL_NAME,params,rowMapper);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

}
