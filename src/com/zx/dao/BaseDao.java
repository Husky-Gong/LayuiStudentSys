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
		
		rs = prep.executeQuery();
		// get query information
		ResultSetMetaData metaData = rs.getMetaData();
		// get column number
		int columnCount = metaData.getColumnCount();
		while(rs.next()) {
			T t = cls.getConstructor().newInstance();
			for(int i=1; i <= columnCount; i++) {
				String columnLabel = metaData.getColumnLabel(i);
				System.out.println(columnLabel);
				
				Object object = rs.getObject(columnLabel);
				
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
			//获取指令对象，且支持获取数据库生成主键值
			prep = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			//设置参数
			//设置参数 根据循环设置参数
			for (int i = 0; i < param.length; i++) {
				//PreparedStatement 设置参数是 第一个? 下标为  1 第二个是2
				prep.setObject(i+1, param[i]);
			}
			prep.executeUpdate();
			//获取生成主键值
			rs = prep.getGeneratedKeys();
			//偏移结果集的指针
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
