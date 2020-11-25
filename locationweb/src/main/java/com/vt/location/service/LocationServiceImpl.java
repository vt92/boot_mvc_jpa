package com.vt.location.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vt.location.entities.Location;
import com.vt.location.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepository locationRepository;
	
	

	public LocationRepository getLocationRepository() {
		return locationRepository;
	}

	public void setLocationRepository(LocationRepository locationRepository) {
		this.locationRepository = locationRepository;
	}

	public Location saveLocation(Location location) {
		return locationRepository.save(location);
	}

	public Location updateLocation(Location location) {
		return locationRepository.save(location);
	}

	public void deleteLocation(Location location) {
		locationRepository.delete(location);
	}

	public Location getLocationById(int id) {
		Optional<Location> location = locationRepository.findById(id);
		return location.get();
	}

	public List<Location> getAllLocations() {
		return locationRepository.findAll();
	}

}
