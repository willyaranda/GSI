package com.gsi.telecom.dao;

import java.sql.SQLException;

import com.gsi.telecom.data.BasicData;

public interface BasicDao<T extends BasicData> {

	public void add(T basic) throws SQLException;

	public void delete(T basic) throws SQLException;

	public T select(Integer id) throws SQLException;

	public T update(T basic) throws SQLException;
}
