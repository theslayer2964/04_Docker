package com.example.demo.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "maybay")
public class MayBay {

	@Id
	@Column(name = "MaMB")
	private int maMB;
	@Column(name = "Loai")
	private String loai;
	@Column(name = "TamBay")
	private int tamBay;
	@ManyToMany()
	@JoinTable(
			name = "ChungNhan",joinColumns = @JoinColumn(name = "MaMB",referencedColumnName = "MaMB")
			,
			inverseJoinColumns = @JoinColumn(name = "MaNV",referencedColumnName = "MaNV") )
	private List<NhanVien> listNV;
	
//	public MayBay() {
//		// TODO Auto-generated constructor stub
//	}
	public int getMaMB() {
		return maMB;
	}
	public void setMaMB(int maMB) {
		this.maMB = maMB;
	}
	public String getLoai() {
		return loai;
	}
	public void setLoai(String loai) {
		this.loai = loai;
	}
	public int getTamBay() {
		return tamBay;
	}
	public void setTamBay(int tamBay) {
		this.tamBay = tamBay;
	}
	
	
	
}
