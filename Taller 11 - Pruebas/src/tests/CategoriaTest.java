package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import uniandes.cupi2.almacen.mundo.Almacen;
import uniandes.cupi2.almacen.mundo.AlmacenException;
import uniandes.cupi2.almacen.mundo.Categoria;
import uniandes.cupi2.almacen.mundo.NodoAlmacen;

public class CategoriaTest 
{

	private Categoria categoria;
	
	@BeforeEach
	public void setUp() throws Exception 
	{
		
		Almacen mundo = new Almacen( new File( "./data/datos.txt" ) );
        BufferedReader in = new BufferedReader( new FileReader(new File( "./data/datos.txt" )  ) );
        categoria = new Categoria( in.readLine( ), in );
        
        
	}
	
	@Test
	@DisplayName("Dar nodos")
	public void darNodosTest() 
	{
		List<NodoAlmacen> lista = new ArrayList<>();
		
		assertEquals(categoria.darNodos(), categoria.darNodos(), "Dar nodos falló :(");
	}
	
	

	

	@Test
	@DisplayName("Buscar padre")
	public void buscarPadreTest() 
	{

		assertEquals(categoria.buscarPadre(""), categoria.buscarPadre(""), "Dar nodos falló :(");
	}
	
	
	

	@Test
	@DisplayName("Buscar nodo")
	public void buscarNodoTest() 
	{
		assertEquals(categoria.buscarNodo(""), categoria.buscarNodo(""), "Dar nodos falló :(");
	}
	
	
	

	@Test
	@DisplayName("Agregar nodo")
	public void agregarNodoTest() 
	{
		try {
			categoria.agregarNodo("","","","");
		} catch (AlmacenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	

	@Test
	@DisplayName("Eliminar nodo")
	public void eliminarNodoTest() 
	{
		assertEquals(categoria.eliminarNodo(""), categoria.eliminarNodo(""), "Dar nodos falló :(");
	
	}
	
	
	

	@Test
	@DisplayName("Buscar Producto")
	public void buscarProductoTest() 
	{

		assertEquals(categoria.buscarProducto(""), categoria.buscarProducto(""), "Dar nodos falló :(");
	}
	
	
	
	@Test
	@DisplayName("Dar Productos")
	public void darProductosTest() 
	{
		categoria.darProductos();
	}
	
	
	
	@Test
	@DisplayName("Dar marcas")
	public void darMarcasTest() 
	{

		assertEquals(categoria.darMarcas(), categoria.darMarcas(), "Dar nodos falló :(");
	}
	
	
	
	@Test
	@DisplayName("Dar preorden")
	public void darPreordenTest() 
	{

		assertEquals(categoria.darPreorden(), categoria.darPreorden(), "Dar nodos falló :(");
	}
	
	
	@Test
	@DisplayName("Dar posorden")
	public void darPosordenTest() 
	{
		assertEquals(categoria.darPosorden(), categoria.darPosorden(), "Dar nodos falló :(");

	}
	
	
	@Test
	@DisplayName("Dar valor ventas")
	public void darValorVentasTest() 
	{

		assertEquals(categoria.darValorVentas(), categoria.darValorVentas(), "Dar nodos falló :(");
	}
	
	
}
