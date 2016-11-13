package org.springframework.chapter1.soundsystem;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoundSystemConfig {
	
	@Bean
	public List<String> tracks(){
		return new ArrayList<String>(){/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
			add("track1");
			add("track2");
			add("track3");
		}};
	}
	
	@Bean
	public CompactDisc sgtPeppers() {
		return new SgtPeppers();
	}
	
	@Bean
	public CdPlayer cdPlayer(CompactDisc disc) {
		return new CdPlayer(disc);
	}
	
	@Bean
	public CdPlayer cdPlayerNew(CompactDisc disc) {
		return new CdPlayer(disc);
	}
	
	@Bean
	public CdPlayer cdPleayerDi(CompactDisc disc) {
		return new CdPlayer(disc);
	}
}
