package com.example.demo.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.demo.entity.NhanVien;
import com.example.demo.demo.repository.NhanVienRepository;

@RestController
@RequestMapping("/api/nhanVien")
public class NhanVienController {

	@Autowired
	NhanVienRepository nhanVienRepository;
	
	@GetMapping("/nvLuong10")
	public List<NhanVien> getNVLuong10(){
		return nhanVienRepository.getNVLuong10();
	}
	@GetMapping("/getTongLuong")
	public double getTongLuong(){
		return nhanVienRepository.getTongLuong();
	}
	@GetMapping("/getNvLaiBoeing")
	public List<String> getNvLaiBoeing(){
		return nhanVienRepository.getNvLaiBoeing();
	}
	@GetMapping("/getNVLai747")
	public List<String> getNVLai747(){
		return nhanVienRepository.getNVLai747();
	}
	@GetMapping("/getNVBeingNAirbus")
	public List<String> getNVBeingNAirbus(){
		return nhanVienRepository.getNVBeingNAirbus();
	}
	@GetMapping("/getTenNvLaiBoeing")
	public List<String> getTenNvLaiBoeing(){
		return nhanVienRepository.getTenNvLaiBoeing();
	}
	@GetMapping("/getMaNV3CN")
	public List<String> getMaNV3CN(){
		return nhanVienRepository.getMaNV3CN();
	}
	@GetMapping("/cau23")
	public List<Object> cau23(){
		return nhanVienRepository.cau23();
	}
	@GetMapping("/cau24")
	public List<Object> cau24(){
		return nhanVienRepository.cau24();
	}
	@GetMapping("/getNVKoPhiCong")
	public List<NhanVien> getNVKoPhiCong(){
		return nhanVienRepository.getNVKoPhiCong();
	}
	@GetMapping("/getMaNVLuongCaoNhat")
	public List<String> getMaNVLuongCaoNhat(){
		return nhanVienRepository.getMaNVLuongCaoNhat();
	}
	@GetMapping("/getLuongTraPhiCong")
	public List<Double> getLuongTraPhiCong(){
		return nhanVienRepository.getLuongTraPhiCong();
	}
}
