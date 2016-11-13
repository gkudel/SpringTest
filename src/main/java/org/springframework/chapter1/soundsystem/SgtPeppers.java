package org.springframework.chapter1.soundsystem;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SgtPeppers implements CompactDisc {
	private String title = "Sgt. Pepper's Lonely Hearts Club Band";
	private String artist = "The Beatles";
	@Value("#{tracks}")
	private List<String> tracks;
	private int id;
	
	public SgtPeppers() {
		id = new Random().nextInt();
	}
	
	public void play() {
		System.out.println("I'm playing " + title + " artist " + artist);
		for (String track : tracks) {
			System.out.println("Track:["+track+"]");
		}
	}

	public int getId() {
		return id;
	}
	
	public List<String> getTracks() {
		return tracks;
	}

	public void setTracks(List<String> tracks) {
		this.tracks = tracks;
	}
}
