package com.spring.content.negotiation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.content.negotiation.model.Item;
import com.spring.content.negotiation.service.ItemServices;

@RestController
public class ContentDisplayController {
	@Autowired
	private ItemServices service;

	@RequestMapping(value = "/getItems", method = RequestMethod.GET, produces = {
			"application/json", "application/xml" })
	public List<Item> viewItemsContent(Model model) {
		List<Item> items = service.getItems();
		return items;
	}
}
