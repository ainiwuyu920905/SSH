package junit.test;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.edu.bean.Person;
import cn.edu.service.PersonService;

public class PersonServiceTest {

	private static PersonService personService;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		try {
			ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
			personService = (PersonService) context.getBean("personService");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test
	public void testSave() {
		Person person = new Person("张孝祥");
		personService.save(person);
	}

	@Test
	public void testUpdate() {
		Person person =personService.getPerson(1);
		//....... web 
		person.setName("zxx");
		personService.update(person);
	}

	@Test
	public void testDelete() {
		personService.delete(1);
	}

	@Test
	public void testGetPerson() {
		System.out.println("开始取数据");
		Person person =personService.getPerson(3);
		System.out.println(person.getName());
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("第二次去数据");
		Person person1 =personService.getPerson(3);
		System.out.println(person1.getName());
	}

	@Test
	public void testGetPersons() {
		for(Person person : personService.getPersons()){
			System.out.println(person.getName());
		}
	}

}
