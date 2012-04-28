package com.gsi.telecom.dao;

import com.gsi.telecom.data.BasicData;

public interface BasicDao<T extends BasicData> {

	public T update(T basic);

	public void add(T basic);

	public void delete(T basic);

	public T select(Integer id);
}
	