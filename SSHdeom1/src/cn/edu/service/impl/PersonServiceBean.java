package cn.edu.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.edu.bean.Person;
import cn.edu.service.PersonService;

@Transactional
public class PersonServiceBean implements PersonService {
	@Resource 
	private SessionFactory sessionFactory;
	
	public void save(Person person){
		
		try {
			sessionFactory.getCurrentSession().persist(person);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Person person){
		sessionFactory.getCurrentSession().merge(person);
	}
	
	public void delete(int id){
		sessionFactory.getCurrentSession().delete(sessionFactory.getCurrentSession().load(Person.class,id));
	}
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public Person getPerson(int id){
		return (Person)sessionFactory.getCurrentSession().get(Person.class,id);
		
	}
	@SuppressWarnings("unchecked")
	@Transactional(propagation=Propagation.NOT_SUPPORTED,readOnly=true)
	public List<Person> getPersons(){
		Criteria criteria =sessionFactory.getCurrentSession().createCriteria(Person.class);
		return (List<Person>)criteria.list();
	}
}
