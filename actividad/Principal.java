package actividad;
import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		try {

			Scanner sc = new Scanner(System.in);
			System.out.println("Ingrese una esquina del 1er rectangulo:");
			System.out.print("x: ");
			double posXR1 =sc.nextDouble();
			System.out.println(posXR1);
			System.out.print("y: ");
			double posYR1 =sc.nextDouble();
			System.out.println(posYR1);
			Coordenada cor1R1 = new Coordenada(posXR1,posYR1);
			
			System.out.println("Ingrese la esquina opuesta del 1er rectangulo:");
			System.out.print("x: ");
			double posXR1O =sc.nextDouble();
			System.out.println(posXR1O);
			System.out.print("y: ");
			double posYR1O =sc.nextDouble();
			System.out.println(posYR1O);
			Coordenada cor2R1 = new Coordenada(posXR1O,posYR1O);
			
			Rectangulo r1 = new Rectangulo(cor1R1,cor2R1);
			
			System.out.println("Ingrese una esquina del 2do rectangulo:");
			System.out.print("x: ");
			double posXR2 =sc.nextDouble();
			System.out.print("y: ");
			double posYR2 =sc.nextDouble();
			Coordenada cor1R2 = new Coordenada(posXR2,posYR2);
			
			System.out.println("Ingrese la esquina opuesta del 2do rectangulo:");
			System.out.print("x: ");
			double posXR2O =sc.nextDouble();
			System.out.print("y: ");
			double posYR2O =sc.nextDouble();
			Coordenada cor2R2 = new Coordenada(posXR2O,posYR2O);
			
			Rectangulo r2 = new Rectangulo(cor1R2,cor2R2);
			
			System.out.println(r1);
			System.out.println(r2);
			if(Verificador.esSobrePos(r1, r2)) {
				System.out.println("Los rectangulos A y B se sobreponen");
				Rectangulo r3 = rectanguloSobre(r1,r2);
				System.out.println("Area de sobreposicion " + r3.getArea());
			}
			if(Verificador.esJunto(r1, r2)) {
				System.out.println("Los rectangulos A y B estan juntos");
			}
			if(Verificador.esDisjunto(r1, r2)) {
				System.out.println("Los rectangulos A y B son disjuntos");
			}

			ContainerRect contenedor = new ContainerRect(2);
			contenedor.addRectangulo(r1);
			contenedor.addRectangulo(r2);
			System.out.println(contenedor);

		} catch (NoDiagonal e) {
			System.out.println(e.getMessage());
		} catch (DiagonalDeCuadrado e) {
			System.out.println(e.getMessage());
		}
	}
	public static Rectangulo rectanguloSobre(Rectangulo r1, Rectangulo r2) throws NoDiagonal, DiagonalDeCuadrado {
		if (Verificador.esSobrePos(r1, r2)) {
			ArrayList<Coordenada> cordR1 = new ArrayList<Coordenada>();
			double inicioR1X,finR1X,inicioR1Y,finR1Y;
			if(r1.getEsquina1().getX()<r1.getEsquina2().getX()) {
				inicioR1X = r1.getEsquina1().getX();
				finR1X = r1.getEsquina2().getX();
			}
			else {
				inicioR1X = r1.getEsquina2().getX();
				finR1X = r1.getEsquina1().getX();
			}
			if(r1.getEsquina1().getY()<r1.getEsquina2().getY()) {
				inicioR1Y = r1.getEsquina1().getY();
				finR1Y = r1.getEsquina2().getY();
			}
			else {
				inicioR1Y = r1.getEsquina2().getY();
				finR1Y = r1.getEsquina1().getY();
			}

			for(double x = inicioR1X; x <= finR1X; x = x + 0.1) {
				for(double y = inicioR1Y; y <= finR1Y + 0.1; y = y + 0.1) {
					double n1,n2;
					n1 = Math.round(x * 100.0)/100.0;
					n2 = Math.round(y * 100.0)/100.0;
					cordR1.add(new Coordenada(n1,n2));
				}
			}
			
			ArrayList<Coordenada> cordR2 = new ArrayList<Coordenada>();
			double inicioR2X,finR2X,inicioR2Y,finR2Y;
			if(r2.getEsquina1().getX()<r2.getEsquina2().getX()) {
				inicioR2X =  r2.getEsquina1().getX();
				finR2X = r2.getEsquina2().getX();
			}
			else {
				inicioR2X =  r2.getEsquina2().getX();
				finR2X = r2.getEsquina1().getX();
			}
			if(r2.getEsquina1().getY()<r2.getEsquina2().getY()) {
				inicioR2Y =  r2.getEsquina1().getY();
				finR2Y = r2.getEsquina2().getY();
			}
			else {
				inicioR2Y = r2.getEsquina2().getY();
				finR2Y = r2.getEsquina1().getY();
			}
			for(double x = inicioR2X; x <= finR2X+0.1; x = x + 0.1) {
				for(double y = inicioR2Y; y <= finR2Y+0.1; y = y +0.1) {
					double n1,n2;
					n1 = Math.round(x * 100.0)/100.0;
					n2 = Math.round(y * 100.0)/100.0;
					cordR2.add(new Coordenada(n1,n2));
				}
			}
			
			ArrayList<Coordenada> cordIguales = new ArrayList<Coordenada>();
	
			for(int i = 0 ; i < cordR1.size();i++) {
				for(int j = 0; j < cordR2.size();j++) {
					if(cordR1.get(i).equals(cordR2.get(j))) {
						Coordenada igual = new Coordenada(cordR1.get(i));
						cordIguales.add(igual);
					}
				}
			}
			
			return new Rectangulo(new Coordenada(cordIguales.get(0)),
					new Coordenada(cordIguales.get(cordIguales.size()-1)));

		}
		return null;
	}
}
