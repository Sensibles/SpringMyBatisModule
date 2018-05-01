package pl.artur.module.db.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMapper {
	
	@Insert("INSERT INTO ITEMS (ITEMNAME, AMOUNT) values(#{itemName}, #{amount})")
	public void insertItem(@Param(value="itemName")String itemName, @Param(value="amount")int amount);

}
