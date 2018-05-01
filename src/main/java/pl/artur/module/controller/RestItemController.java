package pl.artur.module.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import pl.artur.module.db.entity.Item;
import pl.artur.module.service.ItemService;

@RestController
@RequestMapping("/items")
public class RestItemController {
	
	@Autowired
	ItemService itemSerivce;
	
	@RequestMapping(value="/add", method=RequestMethod.POST,  produces = "application/json")
	@ResponseBody
	public Item addItem(@RequestBody Item item) {
		itemSerivce.insertItem(item);
		return item;
	}

}
