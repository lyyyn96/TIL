package test1.di;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

import my.model.Person;

public class Test {

	public static void main(String[] args) {
		BeanFactory factory = new XmlBeanFactory(new FileSystemResource("person.xml"));
		Person p = (Person) factory.getBean(args[0]);
		System.out.println(p);
		
		//Person p2 = (Person) factory.getBean("person2");
		//System.out.println(p2);
		
		//Person p3 = (Person) factory.getBean("person3");
		//System.out.println(p3);
		
		//PersonImpl person1 = new PersonImpl();
		//person1.setName("최혜린");
	}

}
