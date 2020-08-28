package com.app.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.zaxxer.hikari.pool.HikariProxyResultSet;

@Service
public class QueryService {
	
	 @Autowired
	  private JdbcTemplate jdbcTemplate;
	 
	

	    public JSONArray executeQuery(String query) {
		
	        JSONArray jsonArray = new JSONArray();

	        jdbcTemplate.query(query, (rs, rowNum) -> {
	            jsonArray.put(getJSONObjectFromResultSet(rs));
	           
	            
	            return true;
	        });

	        return jsonArray;
	    }
	    
	    public Page<JSONObject> executeQuery(String query, Pageable pageable) {

			JSONArray jsonArray = new JSONArray();

			jdbcTemplate.query(query, (rs, rowNum) -> {
				jsonArray.put(getJSONObjectFromResultSet(rs));

				return true;
			});

			ArrayList<JSONObject> arrayList = new ArrayList(jsonArray.length());
			for (int i = 0; i < jsonArray.length(); i++) {
				arrayList.add(jsonArray.getJSONObject(i));
			}
			int start = (int) pageable.getOffset();

			int end = (int) ((start + pageable.getPageSize()) > arrayList.size() ? arrayList.size()
					: (start + pageable.getPageSize()));

			return new PageImpl<>(arrayList.subList(start, end), pageable, arrayList.size());
		}
	    private JSONObject getJSONObjectFromResultSet(ResultSet rs) throws SQLException {
	        JSONObject jsonObject    = new JSONObject();
	        int        total_columns = rs.getMetaData().getColumnCount();


	        for (int i = 1; i <= total_columns; i++) { // Columns index starts with 1
	            jsonObject.put(rs.getMetaData().getColumnLabel(i), rs.getObject(i));
	        }

	        return jsonObject;
	    }

}
