package io.gunmarket.demo.marketApp.repo.dslbuilder;

import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.builder.GraphTypeBuilder;
import org.springframework.stereotype.Component;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.List;
import java.util.Map;


/*	var map = Map.of(
			"dtype", "gun",
			"price","5000interval10000",
			"shop.address", "address1",
			"brand.shortName", "brand-name1,brand-name2",
			"caliber.caliberValue","caliber-value1"
	);*/

/*
	dtype=Gun&
	price=5000interval10000&
	productInShop.Shop.Address.Street=address1&
	brand.shortName=brand-name1,brand-name2&
	caliber.caliberValue=caliber-value1
 */
@Component
public class DslBuilder {
	private static final Graph<String, DefaultEdge> tree = GraphTypeBuilder
			.directed()
			.allowingSelfLoops(false)
			.allowingMultipleEdges(true)
			.weighted(false)
			.vertexClass(String.class)
			.edgeClass(DefaultEdge.class)
			.buildGraph();

	{
		addChildrenToParent(tree, "product", List.of("dtype", "price", "productInShop", "brand", "caliber"));
		addChildrenToParent(tree, "productInShop", List.of("shop"));
		addChildrenToParent(tree, "brand", List.of("shortName"));
		addChildrenToParent(tree, "caliber", List.of("caliberValue"));
		addChildrenToParent(tree, "shop", List.of("address"));
		System.out.println(tree);
	}

	public String build(Map<String, String> params, Class<?> dslTreeRootClass) {
		return "dtype=gun&" +
			"price=5000interval10000&" +
			"shop.address=address1&" +
			"brand.shortName=brand-name1,brand-name2&" +
			"caliber.caliberValue=caliber-value1";
//		return params.entrySet()
//				.stream()
//				.map(e -> createDslEntry(e, dslTreeRootClass.getName()))
//				.map(this::createDslSubLine)
//				.collect(Collectors.joining("&"));
	}

	private Map.Entry<String, String> createDslEntry(Map.Entry<String, String> entry, String startPoint) {
		String finishPoint = entry.getKey();
		Graph<String, DefaultEdge> treeScheme = getTreeScheme(startPoint);
		String preparedKey = createEntityChain(finishPoint, treeScheme);
		return new AbstractMap.SimpleEntry<>(preparedKey, entry.getValue());
	}

	private String createEntityChain(String finishPoint, Graph<String, DefaultEdge> treeScheme) {
		return "not implemented yet";
	}

	private String createDslSubLine(Map.Entry<String, String> entry) {
		return entry.getKey() + "=" + entry.getValue();
	}

	private Graph<String, DefaultEdge> getTreeScheme(String startPoint){
		return tree;
	}

	private void addChildrenToParent(Graph<String, DefaultEdge> tree, String parent, Collection<String> children) {
		tree.addVertex(parent);
		children.forEach(child -> {
			tree.addVertex(child);
			tree.addEdge(parent, child);
		});
	}

}



