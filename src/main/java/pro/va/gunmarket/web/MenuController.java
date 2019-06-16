package pro.va.gunmarket.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.va.gunmarket.service.MenuService;

@RestController
public class MenuController {

	private final MenuService menuService;

	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@RequestMapping("/gunmarket")
	public String menu() {
		return menuService.getMenu();
	}
}
