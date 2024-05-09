package com.LeQuangHuy.API.springboot.repository;

import com.LeQuangHuy.API.springboot.model.Character;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CharacterRepository extends JpaRepository<Character, Long> {

	List<Character> findBycharacterName (String character_name);



}
