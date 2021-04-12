package com.platzi.market.web.controller;

import java.util.List;
import java.util.Optional;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping("/all")
	@ApiOperation("Get all supermarket products")
	@ApiResponse(code = 200, message = "OK")
	public ResponseEntity<List<Product>> getAll(){
		return new ResponseEntity<>(productService.getAll(), HttpStatus.OK); // primer parametro el cuerpo de la respuesta, httpstatus.ok si la peticion respondio de forma adecuada cuando fue llamada
	} // ResponseEntity Dentro ponemos lo que en realidad queremos que retorne (la lista)

	@GetMapping("/{id}")
	@ApiOperation("Search a product with an index")
	@ApiResponses({
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 404, message = "Product not found")
	})// COMO TIENE 2 RESPUESTAS (OK Y NOT_FOUND)
	public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of the product", required = true, example = "7") @PathVariable("id") int productId){
		return productService.getProduct(productId)
				.map(product -> new ResponseEntity<>(product, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND)); // orElse es para cuando no se ejecuta el map, que en este caso sería cuando no existe el producto
	}

	@GetMapping("/category/{categoryId}") // agregamos el /category porque con el pathvariable ya esta asociado a un entero y no sabria a cual responder, hay que diferenciarlo
	public ResponseEntity<List<Product>> getByCategory(@PathVariable("categoryId") int categoryId){
		return productService.getByCategory(categoryId)
				.map(products -> new ResponseEntity<>(products, HttpStatus.OK))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/save") // no vamos a obtener nada, usamos post
	public ResponseEntity<Product> save(@RequestBody Product product) {
		return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
	} // como el producto no viaja dentro del path sino forma parte del cuerpo de la peticion debemos indicar requestbody

	@DeleteMapping("/delete/{id}") // borramos el mapeo
	public ResponseEntity delete(@PathVariable("id") int productId) {
		if(productService.delete(productId)){
			return new ResponseEntity<>(HttpStatus.OK);
		}
		else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
}
