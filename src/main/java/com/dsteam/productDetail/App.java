package com.dsteam.productDetail;

import java.util.*;
import java.util.stream.Collectors;

import com.anto.dao.DBProduct;
import com.anto.dao.Sessionfactory;

public class App {
	public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    	
    		Product dynprogen = new Product();

    		String Categories[] = new String[] { "LEDTV", "CarAudio", "Laptop", "Camera", "GPS", "HDD",
    				"Mobile", "CCTV", "Printer", "Router", "EarPhone" };
    		
    		Double cat_price[]=new Double[] {11000.0,1500.0,10000.0,500.0,1200.0,700.0,300.0,950.0,1250.0,450.0,100.0};
    		
    		List<Double> cat_price_list = Arrays.asList(cat_price);
    		
    		List<String> list1 = Arrays.asList(Categories);
    		dynprogen.setCategories(list1);

    		String prices[] = new String[] { "99", "67", "48", "69", "53", "98", "89", "28", "19", "24", "37", "97", "23",
    				"36", "29", "19", "25", "21", "38", "96", "33", "88" };

    		List priceList = new ArrayList<String>(Arrays.asList(prices));

    		Map<String, String> contrymap = new HashMap<String, String>();
    		contrymap.put("1", "US");
    		contrymap.put("2", "Japan");
    		contrymap.put("3", "China");
    		contrymap.put("4", "India");
    		contrymap.put("5", "Germany");
    		dynprogen.setContrymade(contrymap);

    		Map<String, List<String>> brand = new HashMap<String, List<String>>();

    		List<String> valSetOne = new ArrayList<String>();
    		valSetOne.add("Apple");
    		valSetOne.add(" JBL");
    		valSetOne.add("Garmin");
    		valSetOne.add(" HP");
    		valSetOne.add("Dell");

    		List<String> valSetTwo = new ArrayList<String>();
    		valSetTwo.add("Sony");
    		valSetTwo.add("Canon");
    		valSetTwo.add("Panasonic");

    		List<String> valSetThree = new ArrayList<String>();

    		valSetThree.add("Gionee");
    		valSetThree.add("Huawei");
    		valSetThree.add("Lenovo");
    		valSetThree.add("OnePlus");

    		List<String> valSetFour = new ArrayList<String>();

    		valSetFour.add("Micromax");
    		valSetFour.add("Karbonn");
    		valSetFour.add("IBALL");
    		valSetFour.add(" HCL");
    		valSetFour.add(" BPL");
    		valSetFour.add("Celkon");
    		valSetFour.add("Godrej");

    		List<String> valSetFive = new ArrayList<String>();

    		valSetFive.add("Bose");
    		valSetFive.add("BenQ");
    		valSetFive.add("Siemens");

    		brand.put("1", valSetOne);
    		brand.put("2", valSetTwo);
    		brand.put("3", valSetThree);
    		brand.put("4", valSetFour);
    		brand.put("5", valSetFive);
    		dynprogen.setBrand(brand);

    		List<String> allbrandnames = new ArrayList<String>();
    		allbrandnames.addAll(valSetOne);
    		allbrandnames.addAll(valSetTwo);
    		allbrandnames.addAll(valSetThree);
    		allbrandnames.addAll(valSetFour);
    		allbrandnames.addAll(valSetFive);

    		Map<String, Double> pricemap = new HashMap<String, Double>();
    		
    		int no_price = priceList.size();
    		int no_brand = allbrandnames.size();
    		
    		if(no_brand==no_price)
    		{
    			
    			for (int i=0;i<no_brand;i++)
    				pricemap.put(allbrandnames.get(i), Double.parseDouble((String) priceList.get(i)));
    		}
    		
    		dynprogen.setPrice(pricemap);
    		genProducts(dynprogen,allbrandnames,cat_price_list, pricemap);
    		
    		//dynprogen.genProCalc(cat_price, brand_morgin);

    }

	private static void genProducts(Product dynprogen, List<String> allbrandnames, List cat_price_list,
			Map<String, Double> pricemap) {
		
		
		Sessionfactory sf = new Sessionfactory();

		List<Product> genproductList = new ArrayList<>();
		int i = 0;
		for (String categorie : dynprogen.getCategories()) {
			{
				for (String brand : allbrandnames) {
					Product genproduct = new Product();
					genproduct.setPro_id(genproduct.genProdid());
					genproduct.setProd_name(brand + "_" + categorie);
					genproduct.setPro_net_price(
							genproduct.genProCalc((double) cat_price_list.get(i), pricemap.get(brand)));
					genproduct.setProd_brand(brand);
					genproduct.setProd_categorie(categorie);
					// genproduct.setProd_made(dynprogen.getContrymade().);

					// dbpro.setProd_id(genproduct.genProdid());

					DBProduct dbpro = new DBProduct();
					dbpro.setProd_name(brand + "_" + categorie);
					dbpro.setPro_net_price(genproduct.genProCalc((double) cat_price_list.get(i), pricemap.get(brand)));
					dbpro.setProd_brand(brand);
					dbpro.setProd_categorie(categorie);

					sf.productInsert(dbpro);

					genproductList.add(genproduct);
				}
				i++;
			}

		}
		int j = 1;
		String newline = System.lineSeparator();
		System.out.println(newline);
		System.out.println("Index" + "\t\t" + "Product ID" + "\t\t" + "Product Name" + "\t\t\t" + "Product Brand"
				+ "\t\t\t\t" + "Product Categorie" + "\t\t" + "Product Price");
		System.out.println(
				"---------------------------------------------------------------------------------------------------------------------------------");
		for (Product product : genproductList) {
			System.out.println(j + "," + "\t\t" + product.getPro_id() + "\t\t" + product.getProd_name() + "\t\t\t"
					+ product.getProd_brand() + "\t\t\t\t\t" + product.getProd_categorie() + "\t\t\t\t"
					+ product.getPro_net_price());
			j++;
		}

		List<String> pronameList = genproductList.stream().map(name -> name.getProd_name())
				.collect(Collectors.toList());

		System.out.println(newline);
		System.out.println("Product Name List:" + newline + pronameList);

		List<List> listmerge = new ArrayList<>();
		listmerge.add(Arrays.asList("croma", "LG"));
		listmerge.add(Arrays.asList("bose", "IFB"));
		listmerge.add(Arrays.asList("Micromax", "Intex"));
		System.out.println(newline);
		System.out.println("List After Mergered: " + newline + listmerge);
		System.out.println(newline);

		List flatmapmerge = (List) listmerge.stream().flatMap(mapper -> mapper.stream()).collect(Collectors.toList());
		System.out.println(newline);
		System.out.println("multiple List into single list using Flat Map :: " + newline + flatmapmerge);

		List<String> protypeList = genproductList.stream().filter(picked -> picked.getProd_name().contains("Phone"))
				.map(picked -> picked.prod_name).collect(Collectors.toList());

		System.out.println(newline);
		System.out.println("Filtered product using stream" + newline + protypeList);

		Map<String, List<Product>> ProductPerType = genproductList.stream()
				.collect(Collectors.groupingBy(Product::getProd_categorie));

		System.out.println(newline);
		System.out.println("Product grouped by Type in streem: " + newline + ProductPerType);
		
	}
}
