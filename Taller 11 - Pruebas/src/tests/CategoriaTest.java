package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

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
import uniandes.cupi2.almacen.mundo.Marca;
import uniandes.cupi2.almacen.mundo.NodoAlmacen;

public class CategoriaTest 
{

	private Categoria categoria;
	
	@BeforeEach
	public void setUp() throws Exception, AlmacenException
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
		NodoAlmacen nuevo1 = "Categoria".equals( Categoria.TIPO ) ? new Categoria( "11", "Tecnolog�a") : new Marca( "11", "Tecnolog�a");
		NodoAlmacen nuevo2 = "Categoria".equals( Categoria.TIPO ) ? new Categoria( "113", "Hogar") : new Marca( "11", "Hogar");
	    

		assertEquals(nuevo1.darNombre(), categoria.darNodos().get(0).darNombre(), "Dar nodos fall� :(");
		assertEquals(nuevo1.darTipo(), categoria.darNodos().get(0).darTipo(), "Dar nodos fall� :(");
		assertEquals(nuevo1.darIdentificador(), categoria.darNodos().get(0).darIdentificador(), "Dar nodos fall� :(");
		assertEquals(nuevo2.darNombre(), categoria.darNodos().get(1).darNombre(), "Dar nodos fall� :(");
		assertEquals(nuevo2.darTipo(), categoria.darNodos().get(1).darTipo(), "Dar nodos fall� :(");
		assertEquals(nuevo2.darIdentificador(), categoria.darNodos().get(1).darIdentificador(), "Dar nodos fall� :(");
		
	}
	
	

	

	@Test
	@DisplayName("Buscar padre")
	public void buscarPadreTest() 
	{
		NodoAlmacen nuevo1 = "Categoria".equals( Categoria.TIPO ) ? new Categoria( "12", "Cupi2") : new Marca( "12", "Cupi2");
		
		assertEquals(nuevo1.darNombre(), categoria.buscarPadre("11").darNombre(), "Buscar Padre fall� :(");
		assertEquals(null, categoria.buscarPadre("1"), "Buscar Padre fall� :(");
		
	}
	
	
	

	@Test
	@DisplayName("Buscar nodo")
	public void buscarNodoTest() 
	{
		NodoAlmacen nuevo1 = "Categoria".equals( Categoria.TIPO ) ? new Categoria( "11", "Tecnolog�a") : new Marca( "11", "Tecnolog�a");
		
		assertEquals(nuevo1.darNombre(), categoria.buscarNodo("11").darNombre(), "Buscar nodo fall� :(");

		assertNotEquals(nuevo1.darNombre(), categoria.buscarNodo("113").darNombre(), "Buscar nodo fall� :(");
	}
	
	
	

	@Test
	@DisplayName("Agregar nodo")
	public void agregarNodoTest() throws AlmacenException 
	{
		
		NodoAlmacen nuevo1 = "Categoria".equals( Categoria.TIPO ) ? new Categoria( "12", "NuevoNodo") : new Marca( "12", "NuevoNodo");
		NodoAlmacen nuevo2 = "Categoria".equals( Categoria.TIPO ) ? new Categoria( "114", "NuevoNodo") : new Marca( "114", "NuevoNodo");
		categoria.agregarNodo("1",nuevo1);
		categoria.agregarNodo("11",nuevo2);
		categoria.agregarNodo("11","Categoria","1344","NuevoNodo");
		
		
	}
	

	@Test
	@DisplayName("Eliminar nodo")
	public void eliminarNodoTest() throws AlmacenException 
	{
		NodoAlmacen nuevo1 = "Categoria".equals( Categoria.TIPO ) ? new Categoria( "11", "Tecnolog�a") : new Marca( "11", "Tecnolog�a");
		
		assertEquals(nuevo1.darNombre(), categoria.eliminarNodo("11").darNombre(), "Eliminar nodo fall� :(");
		
		NodoAlmacen nuevo2 = "Categoria".equals( Categoria.TIPO ) ? new Categoria( "114", "NuevoNodo") : new Marca( "114", "NuevoNodo");
		
		categoria.agregarNodo("11",nuevo2);
		categoria.eliminarNodo("114");
		
	}
	
	
	

	@Test
	@DisplayName("Buscar Producto")
	public void buscarProductoTest() 
	{

		assertEquals("LED 55\" Full HD Smart TV", categoria.buscarProducto("24881271").darNombre(), "Buscar Producto fall� :(");
		assertEquals("LED 49\" Smart TV Full HD", categoria.buscarProducto("31759941").darNombre(), "Buscar Producto fall� :(");
		assertNotEquals("LED 49\" Smart TV Full HD", categoria.buscarProducto("30557851").darNombre(), "Buscar Producto fall� :(");
	}
	
	
	
	@Test
	@DisplayName("Dar Productos")
	public void darProductosTest() 
	{
		assertEquals("LED 55\" Full HD Smart TV", categoria.darProductos().get(0).darNombre(), "Dar Producto fall� :(");
		assertNotEquals("LED 55\" Full HD Smart TV", categoria.darProductos().get(1).darNombre(), "Dar Producto fall� :(");
	}
	
	
	
	@Test
	@DisplayName("Dar marcas")
	public void darMarcasTest() 
	{

		assertEquals("SAMSUNG", categoria.darMarcas().get(0).darNombre(), "Dar Marcas fall� :(");
		assertEquals("LG", categoria.darMarcas().get(1).darNombre(), "Dar Marcas fall� :(");
		assertEquals("ASUS", categoria.darMarcas().get(2).darNombre(), "Dar Marcas fall� :(");
		assertEquals("Apple", categoria.darMarcas().get(3).darNombre(), "Dar Marcas fall� :(");
		assertNotEquals("HP", categoria.darMarcas().get(1).darNombre(), "Dar Marcas fall� :(");
	}
	
	
	
	@Test
	@DisplayName("Dar preorden")
	public void darPreordenTest() 
	{

		assertEquals(categoria.buscarPadre("11").darNombre(), categoria.darPreorden().get(0).darNombre(), "Dar Preorden fall� :(");
		assertEquals("Cupi2", categoria.darPreorden().get(0).darNombre(), "Dar Preorden fall� :(");
		assertEquals("1112", categoria.darPreorden().get(4).darIdentificador(), "Dar Preorden fall� :(");
		assertNotEquals("1112", categoria.darPreorden().get(2).darIdentificador(), "Dar Preorden fall� :(");
	}
	
	
	@Test
	@DisplayName("Dar posorden")
	public void darPosordenTest() 
	{
		assertEquals("Televisores", categoria.darPreorden().get(2).darNombre(), "Dar Posorden fall� :(");
		assertEquals("Cupi2", categoria.darPosorden().get(20).darNombre(), "Dar Posorden fall� :(");
		assertEquals("1122", categoria.darPosorden().get(4).darIdentificador(), "Dar Posorden fall� :(");
		assertNotEquals("1122", categoria.darPosorden().get(2).darIdentificador(), "Dar Posorden fall� :(");
	}
	
	
	@Test
	@DisplayName("Dar valor ventas")
	public void darValorVentasTest() 
	{	
		assertEquals(0, categoria.darValorVentas(), "Dar valor ventas fall� :(");
		assertNotEquals(10000, categoria.darValorVentas(), "Dar valor ventas fall� :(");
	}
	
	
}
