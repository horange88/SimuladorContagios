package com.ingSoft.simulador;


import java.util.ArrayList;


public class Poblacion implements Subject {
	private ArrayList<Persona> sanas;
	private ArrayList<Persona> enfermas;
	private ArrayList<Persona> recuperadas;
	private ArrayList<Persona> muertas;
	private Area area;
	
	private ArrayList<Object> observers;
	
	public Poblacion(Area area, int cantPersonas, int cantEnfermas) {
		this.area = area;
		
		sanas = new ArrayList<Persona>();
		enfermas = new ArrayList<Persona>();
		recuperadas = new ArrayList<Persona>();
		muertas = new ArrayList<Persona>();
		
		iniciarSanos(cantPersonas-cantEnfermas);
		iniciarEnfermos(cantEnfermas);
	}
	
	public ArrayList<Persona> getSanas() {
		return sanas;
	}
	public ArrayList<Persona> getEnfermas() {
		return enfermas;
	}
	public ArrayList<Persona> getRecuperadas() {
		return recuperadas;
	}
	public ArrayList<Persona> getMuertas() {
		return muertas;
	}
	public Area getArea() {
		return area;
	}
	public ArrayList<Object> getObservers() {
		return observers;
	}
	public int getCantSanos() {
		return sanas.size();
	}
	public int getCantEnfermos() {
		return enfermas.size();
	}
	public int getCantMuertos() {
		return muertas.size();
	}
	public int getCantRecuperados() {
		return recuperadas.size();
	}
	public int getCantPersonas() {
		return getCantSanos()+getCantEnfermos()+getCantMuertos()+getCantRecuperados();
	}
	
	public void iniciarSanos(int n)
	{
		for(int i=0;i<n;i++)
		{
			sanas.add(new Persona(area));
		}
	}
	
	public void iniciarEnfermos(int n)
	{
		for(int i=0;i<n;i++)
		{
			enfermas.add(new Persona(area));
		}
	}
	
	
	public void enfermarPersona(Persona p)
	{
		enfermas.add(p);
		sanas.remove(p);
		p.enfermar();
	}
	public void morirPersona(Persona p)
	{
		enfermas.remove(p);
		muertas.add(p);
		p.morir();
	}
	public void sanarPersona(Persona p)
	{
		enfermas.remove(p);
		recuperadas.add(p);
		p.recuperar();
	}
	
	public void animar()
	{
		for(Persona p:sanas) {
			p.mover();
		}
		for(Persona p:enfermas) {
			p.mover();
		}
		for(Persona p:recuperadas) {
			p.mover();
		}
	}
	
	@Override
	public void atachObserver(Observer o) {
		// TODO Auto-generated method stub
		observers.add(o);
		
	}
	@Override
	public void detachObserver(Observer o) {
		int i = observers.lastIndexOf(o);
		if (i>=0) {
			
			observers.remove(i);
		}
		
	}
	@Override
	public void notifyObserver() {
		for(int i =0;i<observers.size();i++)
		{
			Observer observer = (Observer)observers.get(i);
			observer.update();
		}
	}

}
