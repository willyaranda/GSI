package com.gsi.telecom.dao;

import com.gsi.telecom.data.BasicData;

public interface BasicDao <T extends BasicData>{

	public T find(Integer id);
	public void add(T data);
	public void delete(T data);
	public T update(T data);

}
