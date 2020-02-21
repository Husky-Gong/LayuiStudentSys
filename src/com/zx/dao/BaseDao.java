package com.zx.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;
import com.zx.util.JdbcUtil;

public class BaseDao {
	
	
	public <T> T selectOne(String sql, Class<T> cls, Object... param) throws Exception {
		List<T> list = selectList(sql,cls,param);
		if(list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;
	}

	
	public <T> List<T> selectList(String sql, Class<T> cls, Object... param) throws Exception {
		Connection conn = JdbcUtil.getConn();
		List<T> list = new ArrayList<T>();
		PreparedStatement prep = null;
		ResultSet rs = null;
		System.out.println(sql);
		prep = conn.prepareStatement(sql);
		for(int i = 0; i<param.length; i++) {
			prep.setObject(i+1, param[i]);
		}
		// query result set
		rs = prep.executeQuery();
		// get query information
		ResultSetMetaData metaData = rs.getMetaData();
		// get column number which will be used in following loop
		int columnCount = metaData.getColumnCount();
		while(rs.next()) {
			// Generate object
			T t = cls.getConstructor().newInstance();
			// set object fields using reflection
			for(int i=1; i <= columnCount; i++) {
				// Get column name
				String columnLabel = metaData.getColumnLabel(i);
				System.out.println(columnLabel);
				// get column value
				Object object = rs.getObject(columnLabel);
				// set value  
				//find attribute by using column name
				Field field = cls.getDeclaredField(columnLabel);
				
				field.setAccessible(true);
				field.set(t, object);
				field.setAccessible(false);
			}
			list.add(t);
		}
		return list;
	}


	public int insert(String sql, Object... param) {
		Connection conn = JdbcUtil.getConn();
		PreparedStatement prep = null;
		ResultSet rs = null;
		try {
			
			prep = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			//Set parameters
			for (int i = 0; i < param.length; i++) {
				//PreparedStatement starts from index 1
				prep.setObject(i+1, param[i]);
			}
			prep.executeUpdate();
			//set primary key
			rs = prep.getGeneratedKeys();
			rs.next();
			return rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtil.close(conn, prep, rs);
		}
		return 0;
	}
}
