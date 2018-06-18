package pl.artur.module.service;
import java.util.List;

import pl.artur.module.db.entity.*;

public interface ItemService {

	List<Item> getAllItems();
	
	Item getItemForId(long id);
	
	void insertItem(Item item);
	
	void insertItemTransactional(Item item);
}
