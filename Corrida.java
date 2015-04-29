/*
 * @Author: Jonatas Leon 
 *
 */
 
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class Corrida {
	private List<Corredor> corredores;
	private Corredor[] colocacao;
	private static int posicao;
	private final int voltas;
	private Set<Fim> fim;
	
	public Corrida(int voltas) {
		corredores = new ArrayList<>();
		this.fim = new HashSet<Fim>();
		this.voltas = voltas;
		Corrida.posicao = 0;
	}
	
	public synchronized void addCorredor(Corredor corredor) {
		corredores.add(corredor);
	}
	
	public synchronized void addColocacao(Corredor corredor) {
		colocacao[posicao++] = corredor;
	}
	
	public synchronized Corredor getPosicao(int index) {
		return colocacao[index];
	}
	
	public int getTotalCorredores() {
		return corredores.size();
	}
	 
    public void addFimListener(Fim fim) {
        this.fim.add(fim);
    }
 
    public void removeListener(Fim fim) {
        this.fim.remove(fim);
    }
	
	public int getVoltas() {
		return voltas;
	}
	
	public void comecarCorrida() {
		colocacao = new Corredor[getCorredoresTotal()];
		for(Corredor corredor : corredores) {
			new Thread(corredor).start();
		}
	}
	
	public int getCorredoresTotal() {
		return corredores.size();
	}
	
	public void addVoltaCompletaListenerToCorredores(Completou completou) {
		for(Corredor corredor: corredores) corredor.setOnVoltaCompletaListener(completou);
	}
	
	public void fimCorrida() {       
		Iterator<Fim> iterator = this.fim.iterator();
 
        while (iterator.hasNext()) {
            Fim fim = (Fim) iterator.next();
            fim.acabou(colocacao);
        }
	}
}
