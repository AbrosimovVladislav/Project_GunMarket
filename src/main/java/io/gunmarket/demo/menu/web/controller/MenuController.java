package io.gunmarket.demo.menu.web.controller;

import io.gunmarket.demo.menu.service.MenuService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MenuController {
	private final MenuService menuService;

	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@GetMapping(value = "/gunmarket", produces = MediaType.APPLICATION_JSON_UTF8_VALUE )
	public String menu() {
		return menuService.getMenu();
	}
}