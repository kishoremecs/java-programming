package com.practice.memento;

public class CareTaker {

	private Memento _memento;

	public void SaveMemento(Memento m) {
		this._memento = m;
	}

	public Memento RetrieveMemento() {
		return this._memento;
	}


}