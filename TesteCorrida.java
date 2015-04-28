/*
 * @Author: Jonatas Leon 
 *
 */

import java.util.ArrayList;

public class TesteCorrida {
	public static void main(String[] args) {
		Corrida corrida = Corrida.getInstance();
		
		corrida.addCorredor(new Corredor("Jonatas", 95, corrida));
		corrida.addCorredor(new Corredor("Eduardo", 93, corrida));
		corrida.addCorredor(new Corredor("Banner", 62, corrida));
		corrida.addCorredor(new Corredor("Stark", 72, corrida));
		corrida.addCorredor(new Corredor("Barton", 64, corrida));
		corrida.addCorredor(new Corredor("Rogers", 40, corrida));
		
		corrida.addFimListener(new Fim() {
			
			@Override
			public synchronized void acabou(Corredor[] colocacao) {
				for(Corredor corredor: colocacao) {
					System.out.printf("%s\n", corredor);
				}
				System.exit(0);
			}
			
		}); 
		
		corrida.comecarCorrida();
	}
}
