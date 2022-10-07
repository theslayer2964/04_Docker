package com.example.demo.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.demo.entity.MayBay;

@Repository
public interface MayBayRepository extends CrudRepository<MayBay	, String> {
	
	@Query(value = "select * from maybay where Loai like '%Airbus%' ", nativeQuery = true)
	List<MayBay> findMayBayAirbus();
	
	@Query(value = "select Loai from maybay where TamBay > 10000 ", nativeQuery = true)
	List<String> findLoaiMBTam10KM();
	
	@Query(value = "select count(Loai) from maybay where Loai like '%boeing%' ", nativeQuery = true)
	List<String> getLoaiBoeing();
	
	@Query(value = "select m.MaMB from maybay m join chungnhan vn on vn.MaMB = m.MaMB  join nhanVien nv on nv.MaNV = vn.MaNV where Ten like '%Nguyen%'", nativeQuery = true)
	List<Integer> getMaMBNguyenLai();
	
	
	@Query(value = "select loai from MayBay where tambay >= (select dodai from chuyenbay where MaCB like 'VN280') ", nativeQuery = true)
	List<String> getLoaiVN280();
	
	@Query(value = "select m.MaMB,Loai, count(MaNV) as 'TongPhiCong' from maybay m left join chungnhan c on m.MaMB = c.MaMB where c.MaNV is not null \r\n"
			+ "	group by m.MaMB,Loai ", nativeQuery = true)
	List<Object> cau16();
	
}
