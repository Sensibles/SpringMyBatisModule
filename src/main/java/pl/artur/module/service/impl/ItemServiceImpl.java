package pl.artur.module.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.artur.module.db.entity.Item;
import pl.artur.module.db.mapper.ItemMapper;
import pl.artur.module.service.ItemService;

@Component
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemMapper itemMapper;
	
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
		itemMapper.insertItem(item.getId(), item.getItemName(), item.getAmount());
		
	}

}
