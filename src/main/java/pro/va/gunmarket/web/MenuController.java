package pro.va.gunmarket.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pro.va.gunmarket.service.MenuService;

@RestController
public class MenuController {

	private final MenuService menuService;

	public MenuController(MenuService menuService) {
		this.menuService = menuService;
	}

	@RequestMapping(value = "/gunmarket", method = RequestMethod.GET, produces = "application/json")
	public String menu() {
		return menuService.getMenu();
	}
}
