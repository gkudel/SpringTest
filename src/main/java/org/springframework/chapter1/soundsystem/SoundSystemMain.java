package org.springframework.chapter1.soundsystem;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SoundSystemMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SoundSystemConfig.class);
		CdPlayer player1 = ctx.getBean("cdPlayer", CdPlayer.class);
		player1.play();
		CdPlayer player2 = ctx.getBean("cdPlayerNew", CdPlayer.class);
		player2.play();
		CdPlayer player3 = ctx.getBean("cdPleayerDi", CdPlayer.class);
		player3.play();
		
		System.out.println("player1["+player1.getId()+"], player2["+player2.getId()+"], player3["+player3.getId()+"]");
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		CdPlayer player4 = context.getBean("cdPlayer",CdPlayer.class);		
		player4.play();
		System.out.println("player4["+player4.getId()+"]");
		CdPlayer anotherCdPlayer = context.getBean("anotherCdPlayer", CdPlayer.class);
		anotherCdPlayer.play();
		System.out.println("anotherCdPlayer["+anotherCdPlayer.getId()+"]");
	}

}
