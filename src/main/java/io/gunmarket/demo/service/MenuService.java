package io.gunmarket.demo.service;

import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.IOException;
import java.nio.file.Files;

@Service
public class MenuService {
	private static final String menuLocation = "classpath:menu.json";

	public String getMenu() {
		try {
			return new String(Files.readAllBytes(ResourceUtils.getFile(menuLocation).toPath()));
		} catch (IOException e) {
			return e.toString();
		}
	}
}
