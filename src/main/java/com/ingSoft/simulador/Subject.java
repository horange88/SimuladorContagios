package com.ingSoft.simulador;

public interface Subject {
	void atachObserver(Observer o);
	void detachObserver(Observer o);
	void notifyObserver();
}
