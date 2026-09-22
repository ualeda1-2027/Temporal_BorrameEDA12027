package practicas.practica01;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
	private final ArrayList<Artista> artistas = new ArrayList<>(); //¿Por qué no hacemos esto en la clase Artista o Cancion?
	private final ArrayList<Cancion> canciones = new ArrayList<>();
	private final ArrayList<Album> albumes = new ArrayList<>();

	public void loadArtistas(String fileName) {
		
		InputStream input = getClass().getResourceAsStream(fileName);
		if (input == null)	throw new RuntimeException("Archivo no encontrado");
		
		//Limpiamos estructuras
		//3 líneas
		//...
		
		Scanner scan = new Scanner(input);

		while(scan.hasNextLine()) {
			String line = scan.nextLine().trim(); //¿Para qué sirve trim()?
			//Fundamental que hagas syso(line) para saber qué estás haciendo en cada momento... 
			//Ya sabes, si line está vacía o comienza con el carácter # --> ignoramos esa línea
			//Para parsear haz uso de split(",")
			//5 líneas
			//...
			
			//Para eliminar los caracteres { y } haz uso de substring()
			//Y para separar los nombres, split(";"), ¿verdad?
			//substring() + split() en una única línea
			//3 líneas
			//...
			
		}
		scan.close();
	}
	
	public int getNumArtistas() {
		return this.artistas.size();
	}
		
	public void loadCanciones(String fileName) {
		InputStream input = getClass().getResourceAsStream(fileName);
		if (input == null)	throw new RuntimeException("Archivo no encontrado");
		
		//limpiamos estructuras
		//2 líneas
		//...
		
		Scanner scan = new Scanner(input);
		while(scan.hasNextLine()) {
			String line = scan.nextLine().trim();
			//muy similar al método de carga de archivo anterior
			//...
		}
		scan.close();
	}
	
	public int getNumCanciones() {
		return this.canciones.size();
	}
	

	public void loadAlbumes(String fileName) {
		InputStream input = getClass().getResourceAsStream(fileName);
		if (input == null)	throw new RuntimeException("Archivo no encontrado");		
		
		this.albumes.clear();
		
		Scanner scan = new Scanner(input);
		while(scan.hasNextLine()) {
			String line = scan.nextLine().trim();
			
			//Seguimos la misma lógica que los métodos de carga de archivos anteriores
			//...
		}
		scan.close();	
	}
	
	public int getNumAlbumes() {
		return this.albumes.size();
	}

	public void clear() {
		this.albumes.clear();
		this.canciones.clear();
		this.artistas.clear();
	}
	
	//Algunas consultas
	
	public ArrayList<String> getAlbumesByTituloCancion(String titulo){
		ArrayList<String> result = new ArrayList<>();
		//2 for() anidados
		//¿Es necesario el uso de break? Analiza y decide.
		//...
		return result;
	}
	
	public ArrayList<String> getGeneroByNombreArtista(String nombre){
		ArrayList<String> result = new ArrayList<>();
		//1 único for()
		//Haz uso de continue; al menos 2 continue debe haber.
		//...
		return result;
	}
	
	public Integer getDuracionByAlbum(String titulo){
		//Se exige el uso de indexOf(). Nada de iterar para buscar...¡está prohibido por norma!
		int pos = //...
		if (pos == -1) return null;
		int suma = 0;
		//1 for()
		//...
		return suma;
	}
	
	public ArrayList<String> getCancionesPropiasEnAlbumesAjenos(String nombreArtista){
		ArrayList<String> result = new ArrayList<>();
		//2 for() anidados
		//Resuelto con solo 7 líneas...¿mejoramos propuesta?
		//...
		return result;
	}
}