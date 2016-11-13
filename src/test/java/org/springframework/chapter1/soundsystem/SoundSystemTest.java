package org.springframework.chapter1.soundsystem;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.StandardOutputStreamLog;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.chapter1.soundsystem.CdPlayer;
import org.springframework.chapter1.soundsystem.CompactDisc;
import org.springframework.chapter1.soundsystem.SoundSystemConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=SoundSystemConfig.class)
public class SoundSystemTest {
	
	@Rule
	public final StandardOutputStreamLog log = new StandardOutputStreamLog();
	
	@Autowired
	private CompactDisc disc;
	
	@Autowired
	private CdPlayer player;

	@Test
	public void discShouldBeNotNull() {
		assertNotNull(disc);
	}
	
	@Test
	public void playTest() {
		player.play();
		String output = "I'm playing Sgt. Pepper's Lonely Hearts Club Band artist The Beatles\r\n"; 
		assertEquals(output, log.getLog());
	}
}
