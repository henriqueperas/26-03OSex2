package controler;

import java.util.concurrent.Semaphore;

public class Threads extends Thread {

	private int idCarro;
	private int sentidoN;
	private Semaphore semaforo;
	
	public Threads(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	public void run() {
		
		try {
			semaforo.acquire();
			carroPassando();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			semaforo.release();
			// fim seção critica
		}
		
	}

	private void carroPassando() {
		// TODO Auto-generated method stub
		sentidoN = idCarro;
		int tempo = 1000;
		if(sentidoN == 0) {
			System.out.println("#" + idCarro + " esta passando pela esquerda");
		}else if(sentidoN == 1) {
			System.out.println("#" + idCarro + " esta passando pela direita");
		}else if(sentidoN == 2) {
			System.out.println("#" + idCarro + " esta passando por baixo");
		}else {
			System.out.println("#" + idCarro + " esta passando por cima");
		}
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("#" + idCarro + " passou");
		
	}
	
}
