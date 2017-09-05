package FigurasGeometricas;

public class Retangulo implements FiguraGeometrica {
	double base;
	double altura;
	/*public Retangulo(double b, double a) {
		this.base = b;
		this.altura = a;
		
	}
	*/public void setBase(double b) throws valorInvalidoException{
		if(b<=0) {
			throw new valorInvalidoException("Este valor é inválido: "+b);
		}this.base =b;
	}
	public void setAltura(double a) throws valorInvalidoException{
		if(a<=0) {
			throw new valorInvalidoException("Este valor é inválido: "+a);
		}this.altura =a;
	}
	@Override
	public double calculaArea() {
		return (this.base*this.altura);
	}
}
