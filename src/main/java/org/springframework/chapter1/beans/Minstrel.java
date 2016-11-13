package org.springframework.chapter1.beans;

import java.io.PrintStream;

public class Minstrel {
	private PrintStream stream;
	
	public Minstrel(PrintStream stream) {
		this.stream = stream;
	}
	
	public void singBeforeQuest() {
		stream.println("Before Quest");
	}
	
	public void singAfterQuest() {
		stream.println("After Quest");
	}
}
