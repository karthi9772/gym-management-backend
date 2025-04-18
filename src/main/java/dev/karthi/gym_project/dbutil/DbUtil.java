package dev.karthi.gym_project.dbutil;


import java.util.List;
import java.util.Map;

public interface DBUtil<T> {
	
	
    <T> List<T> fetchDatas(String query, Class<T> clazz, Map<String, Object> params);
    
    
    void CUDOperation(Object entity, String query);
    
    
    Long fetchCount(String countQuery);
}