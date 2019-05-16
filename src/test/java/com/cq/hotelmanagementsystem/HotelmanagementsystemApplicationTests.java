package com.cq.hotelmanagementsystem;

<<<<<<< HEAD
import org.junit.Test;
import org.junit.runner.RunWith;
=======
import com.cq.hotelmanagementsystem.mapper.TGuestroomInfoMapper;
import com.cq.hotelmanagementsystem.model.TGuestroomInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
>>>>>>> 完成
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

<<<<<<< HEAD
=======
import java.util.Date;

>>>>>>> 完成
@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelmanagementsystemApplicationTests {

<<<<<<< HEAD
	@Test
	public void contextLoads() {
		BCryptPasswordEncoder bCryptPasswordEncoder  =new BCryptPasswordEncoder();
		boolean b=bCryptPasswordEncoder.matches("123","$2a$10$THNv6t/lr.VJeWvJeQvKEeQzpTiiv5KmNl5kQgCbQiQui2g7RKEH2");
		System.out.println(b);
=======
	@Autowired
	private TGuestroomInfoMapper tGuestroomInfoMapper;
	@Test
	public void contextLoads() {
		//BCryptPasswordEncoder bCryptPasswordEncoder  =new BCryptPasswordEncoder();
		//boolean b=bCryptPasswordEncoder.matches("123","$2a$10$THNv6t/lr.VJeWvJeQvKEeQzpTiiv5KmNl5kQgCbQiQui2g7RKEH2");
		//System.out.println(b);
		/*TGuestroomInfo tGuestroomInfo = new TGuestroomInfo();
		tGuestroomInfo.setDate(new Date());
		tGuestroomInfo.setTeleNum("12321");
		tGuestroomInfo.setState(0);
		tGuestroomInfo.setRoomTypeId(1);
		tGuestroomInfo.setRoomName("2131231");
		tGuestroomInfo.setAdminName("21312");
		tGuestroomInfo.setIsEnable(true);
		tGuestroomInfo.setRoomId("006");
		tGuestroomInfo.setFloor("1");
		tGuestroomInfoMapper.insertOrUdateGuestRoom(tGuestroomInfo);
		Integer id = tGuestroomInfo.getId();
		System.out.println(tGuestroomInfo.getId());*/
>>>>>>> 完成
	}

}
