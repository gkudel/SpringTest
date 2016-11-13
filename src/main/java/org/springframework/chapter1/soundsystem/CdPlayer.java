package org.springframework.chapter1.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CdPlayer {

	private CompactDisc disc;
	
	public CdPlayer() {
	}
	
	@Autowired
	public CdPlayer(CompactDisc disc) {
		this.disc = disc;
	}

	@Autowired
	public CompactDisc getDisc() {
		return disc;
	}

	public void setDisc(CompactDisc disc) {
		this.disc = disc;
	}

	public void play() {
		disc.play();
	}
	
	public int getId() {
		return disc.getId();
	}
}
