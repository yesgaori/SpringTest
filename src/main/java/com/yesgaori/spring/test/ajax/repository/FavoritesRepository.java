package com.yesgaori.spring.test.ajax.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yesgaori.spring.test.ajax.domain.Favorites;

@Repository
public interface FavoritesRepository {
	
	public List<Favorites> loadListRepository();
	
	public int insertFavorite(
						@Param("name") String name
						, @Param("url") String url);
	
	public int isDuplicateEmail(@Param("url") String url);
}
