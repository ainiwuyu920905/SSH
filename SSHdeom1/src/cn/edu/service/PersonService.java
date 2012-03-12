package cn.edu.service;

import java.util.List;

import cn.edu.bean.Person;

public interface PersonService {

	void save(Person person);

	void update(Person person);

	void delete(int id);

	Person getPerson(int id);

	List<Person> getPersons();

}