package Ejercicio01;

import java.util.Objects;

public class Person implements Comparable<Person>{
	private String nombre;
	private String apellidos;
	private int edad;
	
	public Person(String nombre, String apellidos, int edad) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	@Override
	public String toString() {
		return this.nombre + " " + this.apellidos + " " + this.edad;
	}
	
	@Override
	public int compareTo(Person o) {
		if(this.edad > o.getEdad()) {
			return 1;
		}
		if(this.edad == o.getEdad()){
			return 0;
		}
		return -1;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person perComp = (Person) obj;
			return this.edad == perComp.getEdad();
		}
		return false;
	}
	
}
