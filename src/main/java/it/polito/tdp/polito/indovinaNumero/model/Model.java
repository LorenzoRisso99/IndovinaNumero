package it.polito.tdp.polito.indovinaNumero.model;

import java.security.InvalidParameterException;

public class Model {

	private int segreto;
	private final int TMAX = 8;
	private final int NMAX = 100;
	private int tentativiFatti;
	private boolean inGioco = false;
	
	public void nuovaPartita() {
		//gestione di una nuova partita
    	this.segreto = (int)((Math.random() * NMAX) +1);
    	this.tentativiFatti = 0;
    	this.inGioco = true;
	}
	
	public int tentativo(int tentativo) {
		
		if(!inGioco) {
			throw new IllegalStateException("Hai perso, partita terminata");
		}
		
		if(!tentativoValido(tentativo)) {
			throw new InvalidParameterException("Devi inserire un numero tra 1 e " + NMAX);
		}
		
		this.tentativiFatti++;
		
		if(this.tentativiFatti == (TMAX)) {
			this.inGioco = false;
		}
		
		if(tentativo == segreto) {
			this.inGioco = false;
			return 0;
		} else if(tentativo<segreto) {
			return -1;
		} else {
			return 1;
		}
	
	}

	private boolean tentativoValido(int tentativo) {
		if(tentativo < 1 || tentativo > NMAX) {
			return false;
		} else {
			return true;
		}
	}

	public int getSegreto() {
		return segreto;
	}

	public int getTMAX() {
		return TMAX;
	}

	public int getNMAX() {
		return NMAX;
	}

	public int getTentativiFatti() {
		return tentativiFatti;
	}
	
	
	
}
