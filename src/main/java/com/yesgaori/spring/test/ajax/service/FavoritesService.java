package com.yesgaori.spring.test.ajax.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yesgaori.spring.test.ajax.domain.Favorites;
import com.yesgaori.spring.test.ajax.repository.FavoritesRepository;

@Service
public class FavoritesService {
	
	@Autowired
	public FavoritesRepository favoritesRepository;
	
	
	public List<Favorites> loadList() {
		
		List<Favorites> favoritesList =  favoritesRepository.loadListRepository();
		
		return favoritesList;
		
	}
	
	public int addFavorites(String siteName, String siteAddress) {
		
		int count = favoritesRepository.insertFavorite(siteName, siteAddress);
		
		return count;
	}
	
	
	public boolean isDuplicateEmailService(String url) {
		
		int count = favoritesRepository.isDuplicateEmail(url);
		
		if(count == 0) {
			return false;
		} else {
			return true;
		}
	}
	
	
	
}
