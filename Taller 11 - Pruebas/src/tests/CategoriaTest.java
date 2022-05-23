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
		try
        {
			Almacen mundo = new Almacen( new File( "./data/datos.txt" ) );
            BufferedReader in = new BufferedReader( new FileReader(new File( "./data/datos.txt" )  ) );
            categoria = new Categoria( in.readLine( ), in );
        }
        catch( Exception e )
        {
            e.printStackTrace(  );
            throw new AlmacenException( "Error al leer el archivo.\n" + e.getMessage( ) );
        }
	}
	
	@Test
	@DisplayName("Dar nodos")
	public void darNodosTest() 
	{
		List<NodoAlmacen> lista = new ArrayList<>();
		
		assertEquals(categoria.darNodos(), categoria.darNodos(), "Dar nodos falló :(");
	}
	
	

	@Test
	@DisplayName("Tiene hijo")
	public void tieneHijoTest() 
	{
	}
	
	

	@Test
	@DisplayName("Buscar padre")
	public void buscarPadreTest() 
	{
	
	}
	
	
	

	@Test
	@DisplayName("Buscar nodo")
	public void buscarNodoTest() 
	{
		
	}
	
	
	

	@Test
	@DisplayName("Agregar nodo")
	public void agregarNodoTest() 
	{
		
	}
	
	
	

	@Test
	@DisplayName("Eliminar nodo")
	public void eliminarNodoTest() 
	{

	}
	
	
	

	@Test
	@DisplayName("Buscar Producto")
	public void buscarProductoTest() 
	{
		
	}
	
	
	
	@Test
	@DisplayName("Dar Productos")
	public void darProductosTest() 
	{
	
	}
	
	
	
	@Test
	@DisplayName("Dar marcas")
	public void darMarcasTest() 
	{
	
	}
	
	
	
	@Test
	@DisplayName("Dar preorden")
	public void darPreordenTest() 
	{
	
	}
	
	
	@Test
	@DisplayName("Dar posorden")
	public void darPosordenTest() 
	{

	}
	
	
	@Test
	@DisplayName("Dar valor ventas")
	public void darValorVentasTest() 
	{

	}
	
	
}
