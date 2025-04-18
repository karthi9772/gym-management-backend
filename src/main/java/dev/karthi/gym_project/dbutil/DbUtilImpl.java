package dev.karthi.gym_project.dbutil;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional
public class DBUtilImpl<T> implements DBUtil<T> {

    private static final Logger LOGGER = LoggerFactory.getLogger(DBUtilImpl.class);

    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    public DBUtilImpl(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public <T> List<T> fetchDatas(String query, Class<T> clazz, Map<String, Object> params) {
        LOGGER.info("Executing fetchDatas with query: {}", query);
        try {
            return namedParameterJdbcTemplate.query(query, params, BeanPropertyRowMapper.newInstance(clazz));
        } catch (Exception e) {
            LOGGER.error("Error fetching data", e);
            return new ArrayList<>();
        }
    }

    @Override
    public void CUDOperation(Object entity, String query) {
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object value = field.get(entity);
                if (value != null) {
                    parameters.addValue(field.getName(), value);
                }
            } catch (IllegalAccessException e) {
                LOGGER.error("Failed to extract field value from entity: {}", field.getName(), e);
                throw new RuntimeException("Error accessing field: " + field.getName(), e);
            }
        }

        try {
            namedParameterJdbcTemplate.update(query, parameters);
        } catch (Exception e) {
            LOGGER.error("Error during CUD operation", e);
            throw new RuntimeException("CUD operation failed", e);
        }
    }

    @Override
    public Long fetchCount(String countQuery) {
        LOGGER.info("Executing fetchCount with query: {}", countQuery);
        try {
            return namedParameterJdbcTemplate.queryForObject(countQuery, new MapSqlParameterSource(), Long.class);
        } catch (Exception e) {
            LOGGER.error("Error fetching count", e);
            return 0L;
        }
    }
}