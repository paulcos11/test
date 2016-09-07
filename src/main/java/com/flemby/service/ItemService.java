package com.flemby.service;

import com.flemby.entity.Event;
import com.flemby.entity.Item;
import com.flemby.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;
	
	public List <Item> findAll(){
		return itemRepository.findAll();
	}

	public Item findOne(int id) {
		return itemRepository.findOne(id);	 
	}
	
	public byte[] loadImage(int id){
		return itemRepository.findOne(id).getImage();
	}

	public Item findOne(Item item) {
		int id = item.getId();
		System.out.println(id);
		return itemRepository.findOne(id);
	}

	public int findOne(Event event) {
		int id = event.getId();
		return id;
	}




}
