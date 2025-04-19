package com.myproject.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.model.TravelPackages;
import com.myproject.repository.PackageRepository;

@Service
public class Packageserive {
	
	private final PackageRepository packagerepository;

    @Autowired
    public Packageserive(PackageRepository packagerepository) {
        this.packagerepository = packagerepository;
    }

    public TravelPackages save(TravelPackages image) {
        return packagerepository.save(image);
    }

    public TravelPackages findById(Long id) {
        return packagerepository.findById(id).orElse(null);
    }

}