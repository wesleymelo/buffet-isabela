/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.buffet.util;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Edilayne
 */
public class GenericDAO<T> implements Serializable {
    	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	private Class classe;
        private EntityManager em;

	@SuppressWarnings("rawtypes")
	public GenericDAO(EntityManager em) {
		setClasse((Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
                setEm(em);
	}

    	public void save(T object) {
            try{
                getEm().getTransaction().begin();
                getEm().persist(object);
                getEm().getTransaction().commit();
               
            }catch(Exception e){
                e.printStackTrace();
                try{ 
                    getEm().getTransaction().rollback(); 
                }catch(Exception ex){}
            }finally{
                getEm().close();
            }
            
	}
        
        public void change(T object){
            try{
                getEm().getTransaction().begin();
                getEm().merge(object);
                getEm().getTransaction().commit();
            }catch(Exception e){
                e.printStackTrace();
                try{ 
                    getEm().getTransaction().rollback(); 
                }catch(Exception ex){}
            }finally{
                getEm().close();
            }
        } 

	public void remove(T object) {
            try{
                getEm().getTransaction().begin();
                getEm().remove(getEm().merge(object));
                getEm().getTransaction().commit();
                
            }catch(Exception e){
               e.printStackTrace();
               try{ 
                    getEm().getTransaction().rollback(); 
                }catch(Exception ex){
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }finally{
                getEm().close();
            }
	}
	
	public List<T> recoveryAll() {
            
            List<T> objects = null;
            try{                
                objects = getEm().createQuery("select o from " +  getClasse().getSimpleName() + " o").getResultList();
            }catch (Exception e){
                e.printStackTrace();
            }
            return objects;
	}

	
	public T consult(Integer id) {
           T t;
           try {
                t = (T) getEm().find(getClasse(), id);
                return t;
           } catch (Exception e) {
                e.printStackTrace();
           }finally{
                getEm().close();
           }
            return null;
	}

        public Class getClasse() {
            return classe;
        }

        public void setClasse(Class classe) {
            this.classe = classe;
        }

        public void setEm(EntityManager em) {
            this.em = em;
        }

        public EntityManager getEm() {
            return em;
        }
}
