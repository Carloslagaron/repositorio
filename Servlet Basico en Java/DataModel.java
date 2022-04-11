package p2;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;
import java.io.File;

import java.net.URL;
import java.net.MalformedURLException;
import java.net.URLConnection;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.nio.file.Paths;
import java.nio.file.Path;

import javax.xml.xpath.XPathFactory;
import javax.xml.validation.SchemaFactory;
import javax.xml.xpath.XPathConstants;
import javax.servlet.ServletConfig;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.xpath.XPath;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.xml.validation.SchemaFactory;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.servlet.http.HttpServletRequest;
import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.servlet.ServletContext;


import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class DataModel {

  public static Map<String,Document> docs = new HashMap<String,Document>();
  public static String direccion = "http://alberto.gil.webs.uvigo.es/SINT/21-22/mml2001.xml";

public static void parseador(String ruta) {

   String servidor = direccion.substring(0,direccion.lastIndexOf("/") + 1);
   String mmlinicial = direccion.substring(direccion.lastIndexOf("/") + 1);

   String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
   String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";
   String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

   DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
   XPath xpath = XPathFactory.newInstance().newXPath();

   ArrayList<String> lista = new ArrayList<String>();
   lista.add(mmlinicial);
   int x = 1;

   dbf.setValidating(true);
   dbf.setNamespaceAware(true);
   dbf.setAttribute(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
   File schema = new File (ruta);
   dbf.setAttribute(JAXP_SCHEMA_SOURCE, schema);

   for(int i = 0; i<x ; i++){
       try {

         DocumentBuilder db = dbf.newDocumentBuilder();
         String pipsa = lista.get(i);

         db.setErrorHandler(new XML_Schema_ErrorHandler());
         Document doc = db.parse(servidor+""+pipsa+" ");
         String anio = doc.getElementsByTagName("Year").item(0).getTextContent();
         docs.put(anio,doc);

         NodeList mmls = (NodeList) xpath.evaluate("/Movies/Movie/Cast/MML",doc, XPathConstants.NODESET);
         for(int j = 0; j<mmls.getLength();j++){
           String mml = (String) xpath.evaluate("text()",mmls.item(j), XPathConstants.STRING);
           if(!lista.contains(mml)) {
             lista.add(mml);
             x++;
           }
         }
       } catch(ParserConfigurationException e) {

       } catch(SAXException e) {

       } catch(IOException e) {

       } catch(Exception e) {}
   }
 }

public static ArrayList<String>getQ1Years() {
    ArrayList<String> retorno = new ArrayList<String>();
    for (String key : docs.keySet()) {
      retorno.add(key);
    }
    return retorno;
  }

  public static ArrayList<Movie>getQ1Movies(String year) {
    ArrayList<Movie> retorno = new ArrayList<Movie>();
    XPath xpath = XPathFactory.newInstance().newXPath();
    NodeList movies = null;
    try {
      movies = (NodeList) xpath.evaluate("/Movies/Movie",docs.get(year), XPathConstants.NODESET);
    } catch(Exception e) {
      return retorno;
    }

    for(int i = 0; i<movies.getLength();i++){
      try {
      Movie peli = new Movie();

      peli.setTitle((String) xpath.evaluate("Title/text()",movies.item(i), XPathConstants.STRING));
      peli.setDuration((String) xpath.evaluate("Duration/text()",movies.item(i), XPathConstants.STRING));
      peli.setLangs((String) xpath.evaluate("@langs",movies.item(i), XPathConstants.STRING));
      peli.setSinopsis((String) xpath.evaluate("text()[normalize-space()]",movies.item(i), XPathConstants.STRING));

      NodeList genres = (NodeList) xpath.evaluate("Genre",movies.item(i), XPathConstants.NODESET);
      int longi = genres.getLength();
      String[] gen = new String[longi];
      for(int j = 0; j<genres.getLength();j++){
        String genre = (String) xpath.evaluate("text()",genres.item(j), XPathConstants.STRING);
        gen[j]= genre;
      }
      peli.setGenre(gen);
      retorno.add(peli);
    } catch (Exception e) {}
  }
    Collections.sort(retorno,Movie.ComparaGeneros);
    return retorno;
}

public static ArrayList<Cast>getQ1Cast(String year, String movie) {
  ArrayList<Cast> retorno = new ArrayList<Cast>();
  XPath xpath = XPathFactory.newInstance().newXPath();
  NodeList actores = null;
  String phone = null;
  try {
    actores = (NodeList) xpath.evaluate("/Movies/Movie[Title='"+movie+"']/Cast",docs.get(year), XPathConstants.NODESET);
    for(int i = 0;i<actores.getLength(); i++) {
      Cast actor = new Cast();
      actor.setName((String) xpath.evaluate("Name/text()",actores.item(i), XPathConstants.STRING));
      actor.setId((String) xpath.evaluate("@id",actores.item(i), XPathConstants.STRING));
      actor.setRol((String) xpath.evaluate("Role/text()",actores.item(i), XPathConstants.STRING));
      if(((String) xpath.evaluate("Phone/text()",actores.item(i), XPathConstants.STRING)) == "") {
        actor.setContacto((String) xpath.evaluate("Email/text()",actores.item(i), XPathConstants.STRING));
      } else {
        actor.setContacto((String) xpath.evaluate("Phone/text()",actores.item(i), XPathConstants.STRING));
      }
      retorno.add(actor);
    }
  } catch(Exception e) {
  }
  Collections.sort(retorno,Cast.ComparaRoles);
  return retorno;
}
}
