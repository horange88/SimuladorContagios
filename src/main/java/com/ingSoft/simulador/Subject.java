package com.ingSoft.simulador;

public interface Subject {
	void atachObserver(Object o);
	void detachObserver(Object o);
	void notifyObserver();
}
