package pro.va.gunmarket.service;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Service
public class MenuService {

	private static final Path menuPath = Paths.get(
			"C:\\Vlad\\ProgFolder\\IdeaProjects\\GunMarketSpare\\src\\main\\resources\\menu.json"
	);

	public String getMenu() {
		try {
			return Files.lines(menuPath).collect(Collectors.joining());
		} catch (IOException e) {
			return e.toString();
		}
	}
}
