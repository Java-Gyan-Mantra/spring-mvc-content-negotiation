package com.spring.content.negotiation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.spring.content.negotiation.model.Item;

@Service
public class ItemServices {

	public List<Item> getItems() {
		List<Item> items = new ArrayList<Item>();
		items.add(new Item("item001", "item1", 2, 500));
		items.add(new Item("item002", "item2", 1, 700));
		items.add(new Item("item003", "item3", 8, 98700));
		items.add(new Item("item004", "item4", 12, 569));
		return items;
	}
}
