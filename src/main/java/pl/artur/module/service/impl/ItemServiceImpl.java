package pl.artur.module.service.impl;

import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import oracle.net.aso.s;
import pl.artur.module.db.entity.Item;
import pl.artur.module.db.mapper.ItemMapper;
import pl.artur.module.service.ItemService;

@Component
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemMapper itemMapper;
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	private ItemMapper transactionalItemMapper;
	
	
	
	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItemForId(long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void insertItem(Item item) {
			itemMapper.insertItem(item.getItemName(), item.getAmount());
	}

	@Override
	public void insertItemTransactional(Item item) {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		try {
			transactionalItemMapper = sqlSession.getMapper(ItemMapper.class);
			transactionalItemMapper.insertItem("Przed: " + item.getItemName(), item.getAmount());
			transactionalItemMapper.insertItem(item.getItemName(), item.getAmount());	
			if(item.getAmount() == 666)
				throw new RuntimeException("test");
			sqlSession.commit();
		}catch (Exception e) {
			sqlSession.rollback();
		} finally {
			sqlSession.close();
		}
		
	}

}
