package br.com.fiap.bo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CambioBO extends Remote{

	double converterBitCoinParaReal (double bitcoin)
	throws RemoteException;
}
