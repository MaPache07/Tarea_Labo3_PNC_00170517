package com.uca.tarea3.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.uca.tarea3.domain.Product;

@Controller
public class ProductController {

	private List<Product> productos = new ArrayList<Product>();
	
	@GetMapping("/compraProducto")
	public ModelAndView compraProducto() {
		ModelAndView mav = new ModelAndView();
		
		productos.add(new Product(0, "Animal Crossing", "30"));
		productos.add(new Product(1, "Super Smash Bross Ultimate", "50"));
		productos.add(new Product(2, "Mario Kart 8 DELUXE", "6"));
		productos.add(new Product(3, "The legend of Zelda: Breath of the wild", "80"));
		productos.add(new Product(4, "Super Mario Odyssey", "45"));
		productos.add(new Product(5, "Xenoblade Chronicles 2", "20"));
		productos.add(new Product(6, "Luigui's Mansion 3", "25"));
		productos.add(new Product(7, "Splatoon 2", "15"));
		productos.add(new Product(8, "Super Mario Maker 2", "35"));
		productos.add(new Product(9, "Fire Emblem: Three Houses", "40"));
		
		
		mav.setViewName("productos");
		mav.addObject("product", new Product());
		mav.addObject("producto", productos);
		
		return mav;
	}
	
	
	@PostMapping("/validar")
	public ModelAndView validar(Product product) {
		ModelAndView mav = new ModelAndView();
		if(Integer.parseInt(productos.get(product.getId()).getCantidad()) >= Integer.parseInt(product.getCantidad())) {
			mav.setViewName("compra");
		}
		else {
			mav.setViewName("error");
		}
		mav.addObject("product", productos.get(product.getId()).getNombre());
		return mav;
	}
}
