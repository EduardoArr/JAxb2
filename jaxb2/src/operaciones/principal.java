package operaciones;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import clasesdatos.Ventas.Venta;
import clasesdatos.*;

public class principal {

	public static void main(String[] args) {

		visualizarxml();
		
		insertarventa(75, "Cliente 6", 10, "16-12-2015");
		// visualizarxml();
                
                borrado(62);
                
                modificar(2);
                
                Intercambiar(60, 10, "15-11-2012");
	}

	////////////////////////////////////////
	public static void visualizarxml() {

		System.out.println("------------------------------ ");
		System.out.println("-------VISUALIZAR XML--------- ");
		System.out.println("------------------------------ ");
		try {
			// JAXBContext jaxbContext = JAXBContext.newInstance("datosclases");
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);

			// Crear un objeto de tipo Unmarshaller para convertir datos XML en
			// un arbol de objetos Java
			Unmarshaller u = jaxbContext.createUnmarshaller();

			// La clase JAXBElement representa a un elemento de un documento XML
			// en este caso a un elemento del documento ventasarticulos.xml
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("/home/alumno/Escritorio/Bases/Bases de datos/General/RecursosUnidad1/EjemplosLibro/EjemplosJAXB/Ejemplo2_JAXB_XSD/ventasarticulos.xml"));

			// Visualizo el documento
			Marshaller m = jaxbContext.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

			m.marshal(jaxbElement, System.out);

			// Si queremos operar con el documento obtenemos los
			// objetos del jaxbElement
			// El metodo getValue() retorna el modelo de contenido (content
			// model) y el valor de los atributos del elemento

			VentasType miventa = (VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();

			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			System.out.println("---------------------------- ");
			System.out.println("---VISUALIZAR LOS OBJETOS--- ");
			System.out.println("---------------------------- ");
			// Datos del articulo
			DatosArtic miartic = (DatosArtic) miventa.getArticulo();

			System.out.println("Nombre art: " + miartic.getDenominacion());
			System.out.println("Codigo art: " + miartic.getCodigo());
			System.out.println("Stock art: " + miartic.getCodigo());
			System.out.println("Ventas  del articulo , hay: " + listaVentas.size());

			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Venta) listaVentas.get(i);
				System.out.println("Numero de venta: " + ve.getNumventa() + ". Nombre cliente: " + ve.getNombrecliente()
						+ ", unidades: " + ve.getUnidades() + ", fecha: " + ve.getFecha());
			}

		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}
        
        
       

	/////////////////////////////////////////////////
	private static void insertarventa(int numeventa, String nomcli, int uni, String fecha) {

		System.out.println("---------------------------- ");
		System.out.println("-------AÑADIR VENTA--------- ");
		System.out.println("---------------------------- ");
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("/home/alumno/Escritorio/Bases/Bases de datos/General/RecursosUnidad1/EjemplosLibro/EjemplosJAXB/Ejemplo2_JAXB_XSD/ventasarticulos.xml"));

			VentasType miventa = (VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();
			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			// comprobar si existe el numero de venta, reccorriendo el arraylist
			int existe = 0; // si no existe, 1 si existe
			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Venta) listaVentas.get(i);
				if (ve.getNumventa().intValue() == numeventa) {
					existe = 1;
					break;
				}
			}
                        
                        Ventas.Venta ve = new Ventas.Venta();
                        
                       if(existe == 1){
                           System.out.println("YA ESTÁ CREADO");
                       }

			if (existe == 0) {
				// Crear el objeto Ventas.Venta, y si no existe se añade a la
				// lista

				ve.setNombrecliente(nomcli);
				ve.setFecha(fecha);
				ve.setUnidades(uni);
				BigInteger nume = BigInteger.valueOf(numeventa);
				ve.setNumventa(nume);

				// añadimos la venta a la lista

				listaVentas.add(ve);
                                
				// crear el Marshaller, volcar la lista al fichero XML
				Marshaller m = jaxbContext.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.marshal(jaxbElement, new FileOutputStream("/home/alumno/Escritorio/Bases/Bases de datos/General/RecursosUnidad1/EjemplosLibro/EjemplosJAXB/Ejemplo2_JAXB_XSD/ventasarticulos.xml"));

				System.out.println("Venta añadida: " + numeventa);
                          

			} 
                        
                        
                               
				

		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}
        
     private static void borrado(int numeventa) {
         
                
		System.out.println("---------------------------- ");
		System.out.println("-------BORRAR VENTA--------- ");
		System.out.println("---------------------------- ");
                
		try {
                    boolean resul = false;
                    
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("/home/alumno/Escritorio/Bases/Bases de datos/General/RecursosUnidad1/EjemplosLibro/EjemplosJAXB/Ejemplo2_JAXB_XSD/ventasarticulos.xml"));

			VentasType miventa = (VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();
			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			// comprobar si existe el numero de venta, reccorriendo el arraylist
			int existe = 0; // si no existe, 1 si existe
			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Venta) listaVentas.get(i);
				if (ve.getNumventa().intValue() == numeventa) {
					existe = 1;
                                        listaVentas.remove(ve);
                                        resul = true;
                                        break;
					
				}
			}
                        
                        Ventas.Venta ve = new Ventas.Venta();
                        
                       if(existe == 0){
                           resul = false;
                           System.out.println("No existe esta ID");
                           System.out.println(resul);
                       }
                       
                       if(existe == 1){
                            
              
                            
                            Marshaller m = jaxbContext.createMarshaller();
                            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                            m.marshal(jaxbElement, new FileOutputStream("/home/alumno/Escritorio/Bases/Bases de datos/General/RecursosUnidad1/EjemplosLibro/EjemplosJAXB/Ejemplo2_JAXB_XSD/ventasarticulos.xml"));
                            System.out.println("ID Borrada");
                            System.out.println(resul);
                            
                        }
                               
				

		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
            
	}
        
         private static void modificar(int stock) {
         
                
		System.out.println("---------------------------- ");
		System.out.println("-------MODIFICAR STOCK--------- ");
		System.out.println("---------------------------- ");
                
		try {
                    boolean resul = false;
                    
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("/home/alumno/Escritorio/Bases/Bases de datos/General/RecursosUnidad1/EjemplosLibro/EjemplosJAXB/Ejemplo2_JAXB_XSD/ventasarticulos.xml"));

			VentasType miventa = (VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();
			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();
                        
			DatosArtic miartic = (DatosArtic) miventa.getArticulo();
                        
                      if(stock > 0){
                        BigInteger valorIntroducido = BigInteger.valueOf(stock);
                        BigInteger valorPorDefecto = miartic.getStock();
                        BigInteger suma = valorIntroducido.add(valorPorDefecto);
                        miartic.setStock(suma);
                        resul = true;
                        
                        Marshaller m = jaxbContext.createMarshaller();
                        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                        m.marshal(jaxbElement, new FileOutputStream("/home/alumno/Escritorio/Bases/Bases de datos/General/RecursosUnidad1/EjemplosLibro/EjemplosJAXB/Ejemplo2_JAXB_XSD/ventasarticulos.xml"));
                        
                        
                        
                        System.out.println(resul);
                      }else{
                          resul = false;
                          System.out.println(resul);
                      }
                        
		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}
            
	}
         private static void Intercambiar(int numeventa, int uni, String fecha) {

		System.out.println("---------------------------- ");
		System.out.println("-------INTERCAMBIAR VENTA--------- ");
		System.out.println("---------------------------- ");
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);
			Unmarshaller u = jaxbContext.createUnmarshaller();
			JAXBElement jaxbElement = (JAXBElement) u.unmarshal(new FileInputStream("/home/alumno/Escritorio/Bases/Bases de datos/General/RecursosUnidad1/EjemplosLibro/EjemplosJAXB/Ejemplo2_JAXB_XSD/ventasarticulos.xml"));

			VentasType miventa = (VentasType) jaxbElement.getValue();

			// Obtenemos una instancia para obtener todas las ventas
			Ventas vent = miventa.getVentas();
			// Guardamos las ventas en la lista
			List listaVentas = new ArrayList();
			listaVentas = vent.getVenta();

			// comprobar si existe el numero de venta, reccorriendo el arraylist
			int existe = 0; // si no existe, 1 si existe
			for (int i = 0; i < listaVentas.size(); i++) {
				Ventas.Venta ve = (Venta) listaVentas.get(i);
				if (ve.getNumventa().intValue() == numeventa) {
					existe = 1;
					break;
				}
			}
                        
                        Ventas.Venta ve = new Ventas.Venta();
                        
                       if(existe == 1){
                           
                          
				ve.setFecha(fecha);
				ve.setUnidades(uni);
				BigInteger nume = BigInteger.valueOf(numeventa);
				ve.setNumventa(nume);

				// añadimos la venta a la lista

				listaVentas.add(ve);
                                
				// crear el Marshaller, volcar la lista al fichero XML
				Marshaller m = jaxbContext.createMarshaller();
				m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
				m.marshal(jaxbElement, new FileOutputStream("/home/alumno/Escritorio/Bases/Bases de datos/General/RecursosUnidad1/EjemplosLibro/EjemplosJAXB/Ejemplo2_JAXB_XSD/ventasarticulos.xml"));

				System.out.println("Venta añadida: " + numeventa);
                       }

			if (existe == 0) {
                            System.out.println("ESTE USUARIO NO EXISTE");

			} 
                        
                        
                               
				

		} catch (JAXBException je) {
			System.out.println(je.getCause());
		} catch (IOException ioe) {
			System.out.println(ioe.getMessage());
		}

	}
         
	/////////////////////////////

}
