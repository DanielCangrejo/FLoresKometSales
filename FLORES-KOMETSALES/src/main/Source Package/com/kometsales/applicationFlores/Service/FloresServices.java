package com.kometsales.applicationFlores.Service;

import java.util.List;

import com.kometsales.applicationFlores.model.Flor;

public interface FloresServices {
	List<Flor> getAllFlowers();
	List<Flor> getFlowersPrice();
	void deleteViaId(long id);
	List<Flor> getFlowersSearch(String nombre);
}
