package actividad;

import java.util.Objects;

public class Coordenada {
	
	private double x;
	private double y;
	
	public Coordenada() {
		this(0,0);
	}
	
	public Coordenada(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Coordenada(Coordenada c) {
	    this(c.getX(), c.getY());
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public double getX(){
		return this.x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public double getY() {
		return y;
	}
	
	public double distancia(Coordenada c2) {
		double resX = c2.getX()- this.x;
		double resY = c2.getY()- this.y;
		return Math.sqrt(Math.pow(resX,2)+ Math.pow(resY, 2));  
	}
	
	public static double distancia(Coordenada c1 , Coordenada c2) {
		double resX = c2.getX() - c1.getX();
		double resY = c2.getY() - c1.getY();
		return Math.sqrt(Math.pow(resX, 2)+ Math.pow(resY, 2));
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Coordenada) {
			Coordenada corComp = (Coordenada) obj;
			return this.x == corComp.getX() && this.y == corComp.getY();
		}
		return false;
	}

	@Override
	public String toString() {
		return "(" + x + "," + y + ")";
	}

}