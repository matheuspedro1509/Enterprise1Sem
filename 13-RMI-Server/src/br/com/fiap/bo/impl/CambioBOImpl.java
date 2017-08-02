package br.com.fiap.bo.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.com.fiap.bo.CambioBO;

public class CambioBOImpl
				extends UnicastRemoteObject 
						implements CambioBO {

	public CambioBOImpl() throws RemoteException {
		super();
	}

	@Override
	public double converterBitCoinParaReal(double bitcoin) throws RemoteException {
		return bitcoin*5503;
	}

	
}
