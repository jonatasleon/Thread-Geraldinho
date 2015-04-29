/*
 * @Author: Jonatas Leon 
 *
 */

 import java.util.Iterator;
 
 public class Corredor implements Runnable{
	private String nome;
	private int numero;
	private int voltaAtual;
	private static int voltasTotal;
	private Corrida corrida;
	private Completou completou;
	
	public Corredor(String nome, int numero, Corrida corrida) {
		this.nome = nome;
		this.numero = numero;
		voltaAtual = 0;
		this.corrida = corrida;
		this.completou = null;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getNumero() {
		return numero;
	}
	
	public int getVoltaAtual() {
		return voltaAtual;
	}
	
	private synchronized void addVoltasTotal() {
		Corredor.voltasTotal = Corredor.voltasTotal+1;
	}
	
	private synchronized void addVolta() {
		voltaAtual++;
	}
	
	@Override
	public String toString() {
		return numero+" - "+nome;
	}
	
	public void setOnVoltaCompletaListener(Completou completou) {
		this.completou = completou;
	}
	
	public void run() {
		for(int i = 0; i < corrida.getVoltas();) {
			try {
				Thread.sleep(15);
				addVolta();
				addVoltasTotal();
				i++;
			}catch (InterruptedException e) { return; }
			
			completou.voltaCompleta(this, i);
		}
		corrida.addColocacao(this);
		if(corrida.getPosicao(corrida.getTotalCorredores()-1) != null) corrida.fimCorrida();
	}
}
