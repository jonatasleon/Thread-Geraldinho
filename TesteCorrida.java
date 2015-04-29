/*
 * @Author: Jonatas Leon
 *
 */

public class TesteCorrida {
	public static void main(String[] args) {
		Corrida corrida = new Corrida(100);
		
		corrida.addCorredor(new Corredor("Jonatas", 95, corrida));
		corrida.addCorredor(new Corredor("Eduardo", 93, corrida));
		corrida.addCorredor(new Corredor("Banner", 62, corrida));
		corrida.addCorredor(new Corredor("Stark", 72, corrida));
		corrida.addCorredor(new Corredor("Barton", 64, corrida));
		corrida.addCorredor(new Corredor("Rogers", 40, corrida));
		corrida.addCorredor(new Corredor("Romanoff", 52, corrida));
		
		corrida.addFimListener(new Fim() {
			
			@Override
			public synchronized void acabou(Corredor[] colocacao) {
				int p = 0;
				for(Corredor corredor: colocacao) {
					System.out.printf("\n%dº - %s\n", ++p, corredor);
				}
				System.exit(0);
			}	
		});
		
		corrida.addVoltaCompletaListenerToCorredores(new Completou() {
			
			@Override
			public synchronized void voltaCompleta(Corredor corredor, int volta) {
				System.out.printf("%s\t\t(%d)\n", corredor.toString(), volta);
			}
		});
		
		corrida.comecarCorrida();
	}
}
