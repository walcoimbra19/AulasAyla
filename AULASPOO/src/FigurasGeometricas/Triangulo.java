package FigurasGeometricas;

public class Triangulo implements FiguraGeometrica {
	double base;
	double altura;
	/*public Triangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}*/
	public void setBase(double base) throws valorInvalidoException{
		if(base<=0) {
			throw new valorInvalidoException("Este valor é inválido: "+base);
		}this.base = base;
	}
	public void setAltura(double altura)throws valorInvalidoException {
		if(base<=0) {
			throw new valorInvalidoException("este valor é inválido: "+altura);
		}this.altura = altura;
	}
	@Override
	public double calculaArea() {
		return ((this.base*this.altura)/2);
	}
}
