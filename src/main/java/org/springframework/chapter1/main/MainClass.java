package org.springframework.chapter1.main;

import org.springframework.chapter1.beans.Knight;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		Knight knight = context.getBean("knight",Knight.class);		
		knight.embarkOnQuest();
		//context.close();
	}

}
