package com.myproject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.model.TravelPackages;

@Repository
public interface PackageRepository extends JpaRepository <TravelPackages, Long> {

	public Optional<TravelPackages> findByName(String imageName);

	
}
