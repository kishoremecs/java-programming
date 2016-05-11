package com.practice.memento;

import java.util.Map;
import java.util.HashMap;

public class CareTaker {

	private Memento _memento;
	private Map<String, Memento> _mementoMap = new HashMap<String, Memento> ();

	public void SaveMemento(Memento m) {
		this._memento = m;
	}

	public void SaveMemento(Memento m, String key, int version) {
		this._memento = m;
		_mementoMap.put(key+"-"+version, m);
	}

	public Memento RetrieveMemento() {
		return this._memento;
	}

	public Memento RetrieveMemento(String key, int version) {
		return this._mementoMap.get(key+"-"+version);
	}


}