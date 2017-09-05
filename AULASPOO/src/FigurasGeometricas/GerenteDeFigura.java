package FigurasGeometricas;
import java.util.ArrayList;
import java.util.List;
public class GerenteDeFigura {
	
	private List<FiguraGeometrica> figuras;
	
	public GerenteDeFigura() {
		this.figuras = new ArrayList<FiguraGeometrica>();
	}
	public double calculaAreaTotalDasFiguras() {
		double area = 0;
		double areaTotal = 0;
		for(FiguraGeometrica f: this.figuras) {
			area = f.calculaArea();
			areaTotal+=area;
		}return areaTotal;
	}public void adicionaFigura(FiguraGeometrica fig) {
		this.figuras.add(fig);
	}public List<FiguraGeometrica> getFiguras(){
		return this.figuras;
	}
}
