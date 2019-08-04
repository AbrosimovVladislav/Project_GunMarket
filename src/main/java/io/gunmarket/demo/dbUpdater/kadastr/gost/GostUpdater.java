package io.gunmarket.demo.dbUpdater.kadastr.gost;

import io.gunmarket.demo.dbUpdater.mapper.BrandMapper;
import io.gunmarket.demo.dbUpdater.mapper.ProductMapper;
import io.gunmarket.demo.marketApp.domain.Brand;
import io.gunmarket.demo.marketApp.domain.product.Product;
import io.gunmarket.demo.marketApp.repo.BrandRepo;
import io.gunmarket.demo.marketApp.repo.product.ProductRepo;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class GostUpdater {

	private final GostParser gostParser;
	private final ProductRepo productRepo;
	private final ProductMapper productMapper;
	private final BrandMapper brandMapper;
	private final BrandRepo brandRepo;

	public GostUpdater(GostParser gostParser,
	                   ProductRepo productRepo,
	                   ProductMapper productMapper,
	                   BrandMapper brandMapper,
	                   BrandRepo brandRepo) {
		this.gostParser = gostParser;
		this.productRepo = productRepo;
		this.productMapper = productMapper;
		this.brandMapper = brandMapper;
		this.brandRepo = brandRepo;
	}

	public List<Product> updateGostContent(){
		List<GostProduct> gostProducts = gostParser.getGostProducts();
		Set<Brand> brands = brandMapper.fromGostProduct(gostProducts);
		brandRepo.saveAll(brands);
		List<Product> products = productMapper.fromGost(gostProducts);
		return productRepo.saveAll(products);
	}

}
