package com.example.demo.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.demo.entity.ChuyenBay;

@Repository
public interface ChuyenBayRepository extends CrudRepository<ChuyenBay, String>{
	
	@Query(value = "select * from chuyenbay where GaDi like 'DAD'", nativeQuery = true)
	List<ChuyenBay> getChuyenBayDiDAD();
	
	@Query(value = "select * from chuyenbay where DoDai between 8000 and 10000 ", nativeQuery = true)
	List<ChuyenBay> getChuyenBayTheoDoDai();
	
	@Query(value = "select * from chuyenbay where GaDi like 'SGN' and GaDen like 'BMV' ", nativeQuery = true)
	List<ChuyenBay> getChuyenBayHCMDiBMT();
	
	@Query(value = "SELECT COUNT(*) from chuyenbay where GaDi like 'SGN' ", nativeQuery = true)
	int getSoChuyenBayHCM();
	
	@Query(value = " select * from chuyenbay where dodai < (select tambay from maybay where Loai like '%Airbus A320%') ", nativeQuery = true)
	List<ChuyenBay> getCBBoiMBA320();
	@Query(value = " select * from chuyenbay where GaDi in ( select GaDen from chuyenbay) and GaDen in (select GaDi from chuyenbay)", nativeQuery = true)
	List<ChuyenBay> cau17() ;
	@Query(value = "select GaDi, count(MaCB) as 'SoChuyen' from  chuyenbay group by GaDi ", nativeQuery = true)
	List<Object> chuyenBayMoiGa() ;
	@Query(value = " select GaDi, sum(ChiPhi) as 'ChiPhi' from  chuyenbay group by GaDi ", nativeQuery = true)
	List<Object> chuyenBayMoiGaChiPhi() ;
	@Query(value = "  select * from chuyenbay where Hour(gioDi) < 12", nativeQuery = true)
	List<ChuyenBay> chuyenBayTrc12() ;
	@Query(value = "select GaDi, count(MaCB) as 'SoChuyen' from  chuyenbay where Hour(gioDi) < 12 group by GaDi ", nativeQuery = true)
	List<Object> chuyenBayGaDiTrc12h() ;
	@Query(value = "select * from chuyenbay where dodai < all (select tambay from maybay where loai like '%boeing%')", nativeQuery = true)
	List<ChuyenBay> chuyenBayAllBoeing() ;
	
}
