package domain;

import java.util.Comparator;

public class VeterinarioComparatorPorDni implements Comparator<Veterinario> {

	@Override
	public int compare(Veterinario vet1, Veterinario vet2) {
		// TODO Auto-generated method stub
		return vet1.getDni().compareTo(vet2.getDni());
		/*
		 * Para hacerlo en orden descendente en caso de que lo quisiera, me creo otro comparator y cambio el orden.
		 * Es decir, hago vet2.getDni().compareTo(vet1.getDni());
		 */
	}

}
