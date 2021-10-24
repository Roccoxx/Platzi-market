package com.platzi.market.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.platzi.market.persistence.entity.Producto;

																// tabla y tipo de dato de su clave primaria
public interface ProductoCrudRepository extends CrudRepository<Producto, Integer>{
	//@Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
	// se podria agregar lo de arriba para hacerlo de manera nativa y modificarlo a gusto
	// https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	/*
    NATIVE QUERY METHOD
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ?", nativeQuery = true)
    List<Producto> getCategoriaByNombreAsc(int idCategoria);
    */
	List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);
}
