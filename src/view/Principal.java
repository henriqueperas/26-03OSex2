package view;

import java.util.concurrent.Semaphore;

import controler.Threads;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idCarro = 0; idCarro < 4; idCarro++) {
			Thread tCarro = new Threads(idCarro, semaforo);
			tCarro.start();
		}

	}

}
