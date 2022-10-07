package com.example.demo.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.demo.entity.NhanVien;

@Repository
public interface NhanVienRepository extends CrudRepository<NhanVien, String> {
	
	@Query(value = "select * from nhanVien where Luong < 10000", nativeQuery = true)
	List<NhanVien> getNVLuong10();
	
	@Query(value = "select sum(Luong) from nhanVien ", nativeQuery = true)
	double getTongLuong();
	
	@Query(value = "select nv.MaNV from nhanVien nv join chungnhan vn on nv.MaNV = vn.MaNV join MayBay m on vn.MaMB = m.MaMB where Loai like '%boeing%' ", nativeQuery = true)
	List<String> getNvLaiBoeing();
	
	@Query(value = "select nv.MaNV from nhanVien nv join chungnhan vn on nv.MaNV = vn.MaNV join MayBay m on vn.MaMB = m.MaMB where m.MaMB = 747 ", nativeQuery = true)
	List<String> getNVLai747();
	@Query(value = "select nv.MaNV from nhanVien nv join chungnhan vn on nv.MaNV = vn.MaNV \r\n"
			+ "	join MayBay m on vn.MaMB = m.MaMB where loai like '%airbus%' and nv.MaNV in \r\n"
			+ "    (select nv.MaNV from nhanVien nv join chungnhan vn on nv.MaNV = vn.MaNV \r\n"
			+ "	join MayBay m on vn.MaMB = m.MaMB where loai like '%boeing%')", nativeQuery = true)
	List<String> getNVBeingNAirbus();
	
	@Query(value = "select nv.Ten from nhanVien nv join chungnhan vn on nv.MaNV = vn.MaNV join MayBay m on vn.MaMB = m.MaMB where Loai like '%boeing%' ", nativeQuery = true)
	List<String> getTenNvLaiBoeing();
	@Query(value = "select MaNV from chungnhan group by MaNV having count(MaMB) = 3", nativeQuery = true)
	List<String> getMaNV3CN();
	
	@Query(value = "select DISTINCT MaNV, TamBay from chungnhan c join maybay m on m.MaMB = c.MaMB \r\n"
			+ "where MaNV in \r\n"
			+ "	(select MaNV from chungnhan h group by MaNV having count(h.MaMB) > 3) \r\n"
			+ "    order by MaNV, TamBay desc", nativeQuery = true)
	List<Object> cau23();
	
	@Query(value = "select MaNV, count(MaMB) from chungnhan group by MaNV", nativeQuery = true)
	List<Object> cau24();
	@Query(value = "select * from nhanvien nv left join chungnhan cn on cn.MaNV = nv.MaNV where cn.MaNV is null", nativeQuery = true)
	List<NhanVien> getNVKoPhiCong();
	@Query(value = "select manv from nhanvien order by luong desc limit 10", nativeQuery = true)
	List<String> getMaNVLuongCaoNhat();
	@Query(value = "select sum(luong) from chungnhan cn left join nhanvien nv on cn.MaNV = nv.MaNV ", nativeQuery = true)
	List<Double> getLuongTraPhiCong();
}
