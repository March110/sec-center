package cn.xdf.security.dao;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;

@Transactional
public class BaseDao <T,ID extends Serializable>{
    private Class<T> entityClass;
    
    protected EntityManager entityManager;

    protected  BaseDao(){
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
		entityClass = (Class) params[0];
	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	 public void save(T entity){
	        this.entityManager.persist(entity);
	        this.entityManager.flush();
	    }
	 
	    public void  update(ID id){
	        T entity = findByID(id);
	        this.entityManager.merge(entity);
	        this.entityManager.flush();
	    }
	 
	    public void delete(ID id){
	        T entity = findByID(id);
	        this.entityManager.remove(entity);
	    }
	 
	    public T findByID(ID id){
	        T pojo = (T) this.entityManager.find(entityClass,id);
	        return pojo;
	    }
	 
	    public List<T> findAll(String qlString){
	        Query query = this.entityManager.createQuery(qlString);
	        return query.getResultList();
	    }

}
