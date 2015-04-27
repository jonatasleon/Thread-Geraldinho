import java.util.ArrayList;

public class TesteCorrida {
	public static void main(String[] args) {
		Corrida corrida = Corrida.getInstance();
		
		Corrida.getInstance().addCorredor(new Corredor("Jonatas", 7, corrida));
		Corrida.getInstance().addCorredor(new Corredor("Eduardo", 8, corrida));
		Corrida.getInstance().addCorredor(new Corredor("Geronimo", 59, corrida));
		Corrida.getInstance().addCorredor(new Corredor("Power Ranger Azul", 9, corrida));
		
		Corrida.getInstance().addCorredor(new Corredor("Jonatas", 1, corrida));
		Corrida.getInstance().addCorredor(new Corredor("Eduardo", 28, corrida));
		Corrida.getInstance().addCorredor(new Corredor("Geronimo", 39, corrida));
		Corrida.getInstance().addCorredor(new Corredor("Power Ranger Azul", 59, corrida));
		
		Corrida.getInstance().addCorredor(new Corredor("Jonatas", 76, corrida));
		Corrida.getInstance().addCorredor(new Corredor("Eduardo", 87, corrida));
		Corrida.getInstance().addCorredor(new Corredor("Geronimo", 98, corrida));
		Corrida.getInstance().addCorredor(new Corredor("Power Ranger Azul", 90, corrida));
		
		Corrida.getInstance().addFim(new Fim() {
			
			@Override
			public void acabou(Corredor[] colocacao) {
				for(int i = 0; i < colocacao.length; i++) {
					System.out.printf("%s\n", colocacao[i].toString());
				}
				System.gc();
			}
			
		}); 
		
		Corrida.getInstance().comecarCorrida();
	}
}
