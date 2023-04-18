package com.kometsales.applicationFlores.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kometsales.applicationFlores.model.Flor;
import com.kometsales.applicationFlores.repository.FlorRepository;

import jakarta.annotation.PostConstruct;

@Service
public class FloresServiceImpl implements FloresServices {
	
	@Autowired
    private FlorRepository florRepository;
	
	private static List<Flor> flores;
	
	@PostConstruct
    public void init() {
        flores = florRepository.findAll();
    }
	
	@PostConstruct
	public void updateFloresList() {
	    flores = florRepository.findAll();
	}

	
	@Override 
	public List<Flor> getAllFlowers() {
		updateFloresList();
	    if (flores == null) {
	        flores = florRepository.findAll();
	    }

	    List<Flor> result = new ArrayList<>();

	    Comparator<Flor> comparador = Comparator.comparing(Flor::getNombre).reversed();
	    Collections.sort(flores, comparador);

	    for (Flor flor : flores) {
	        Flor newFlor = new Flor();
	        newFlor.setId(flor.getId());
	        newFlor.setNombre(flor.getNombre().concat("-kometsales"));
	        newFlor.setPrecio(flor.getPrecio());
	        result.add(newFlor);
	    }

	    return result;
	}
	
	@Override 
	public List<Flor> getFlowersPrice() {
		if (flores == null) {
			flores = florRepository.findAll();
		}
	    List<Flor> floresPrice = new ArrayList<>();
	    for (Flor flor : flores) {
	        if (flor.getPrecio() > 20.00) {
	            flor.setNombre(flor.getNombre());
	            floresPrice.add(flor);
	        }
	    }
	    return floresPrice;
	}
	
	@Override 
	public void deleteViaId(long id){
	    florRepository.deleteById(id);
	    flores.removeIf(flor -> flor.getId() == id);
	}
	
	@Override 
	public List<Flor> getFlowersSearch(String nombre) {
		if (flores == null) {
			flores = florRepository.findAll();
		}
	    List<Flor> floresSearch = new ArrayList<>();
	    for (Flor flor : flores) {
	        if (flor.getNombre().contains(nombre)) {
	        	floresSearch.add(flor);
	        }
	    }
	    return floresSearch;
	}

}
