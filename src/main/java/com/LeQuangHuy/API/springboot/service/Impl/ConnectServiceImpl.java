//package com.LeQuangHuy.API.springboot.service.Impl;
//import com.LeQuangHuy.API.springboot.model.Connect;
//import com.LeQuangHuy.API.springboot.repository.ConnectRepository;
//import com.LeQuangHuy.API.springboot.service.ConnectService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//
//public class ConnectServiceImpl implements ConnectService {
//
//
//	private final ConnectRepository connectRepository
//
//
//	@Override
//	public Optional<Connect> getConnectById(Long id) {
//		return Optional.empty();
//	}
//
//	@Override
//	public List<Connect> findConnectByUserID(Long UserId) {
//		return List.of();
//	}
//
//	@Override
//	public List<Connect> getAllConnect() {
//		return List.of();
//	}
//
//	//	@Override
////	public List<Connect> getAllConnect() {
////
////		return ConnectRepository.findAll();
////	}
//	@Override
//	public void deleteConnectrById(Long id) {
//		connectRepository.deleteById(id);
//	}
//
//	@Override
//	public Connect saveConnect(Connect connect) {
//		return null;
//	}
//
////	@Override
////	public Connect saveConnect(Connect connect) {
////		return ConnectRepository.save(connect);
////	}
//
//
////	@Override
////	public Optional<Connect> getConnectById(Long id) {
////		return ConnectRepository.findById(id);
////	}
//
////	@Override
////	public List<Connect> findConnectByUserID(Long userId) {
////		return (List<Character>) connectRepository. findConnectByUserID(userId);
////	}
//
//
//
//}
