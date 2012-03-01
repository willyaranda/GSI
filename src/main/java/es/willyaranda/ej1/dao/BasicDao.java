package es.willyaranda.ej1.dao;

import es.willyaranda.ej1.data.BasicData;

public interface BasicDao <T extends BasicData>{
	public T find(Integer id);
	public void update(T basic);
	public void insert(T basic);
	public void delete(T basic);
	public T select(Integer id);
}
