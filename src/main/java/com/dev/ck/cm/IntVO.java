package com.dev.ck.cm;

public class IntVO {
	private int value;

	public IntVO(int value) {
		this.value = value;
	}
	
	public void add(int value) {
		this.value += value;
	}
	
	public int get() {
		return value;
	}

	public void set(int value) {
		this.value = value;
	}
	
}