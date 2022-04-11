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

public class FrontEnd {




public static void mostrarfase01(String pass, Boolean esAuto,PrintWriter out){
  if(!esAuto) {
  out.println("<html>");
  out.println("<body>");
  out.println("<form>");
  out.println("<h2>Servicio de consulta de películas</h2>");
  out.println("<h3><a href='?p="+pass+"&pphase=01'>Bienvenido a este servicio</a></h3>");
  out.println("<h4>Selecciona una consulta:</h4>");
  out.println("<h5><a href='?p="+pass+"&pphase=11'>+Consulta 1: reparto de una película de un año</a></h5>");
  out.println("<hr>");
  out.println("<h6>&#9400 Carlos Lagarón Real (2021-2022)</h6>");
  out.println("</form>");
  out.println("</body>");
  out.println("</html>");
} else {
  out.println("<?xml version='1.0' encoding='utf-8'?>");
  out.println("<service>");
  out.println("<status>OK</status>");
  out.println("</service>");
}
}

public static void mostrarfase11(String pass, Boolean esAuto,PrintWriter out){
  int w = 1;
  ArrayList<String> ListaYears = DataModel.getQ1Years();
  if(!esAuto){
  out.println("<h2>Servicio de consulta de películas</h2>");
  out.println("<h3>Consulta 1: Fase 1</h3>");
  out.println("<h3>Selecciona un año:</h3>");
  for(int i=0;i<ListaYears.size();i++){
    out.println("<h5>"+w+".<a href='?p="+pass+"&pphase=12&pyear="+ListaYears.get(i)+"'>"+ListaYears.get(i)+"</a></h5>");
    w++;
  }
  out.println("<form method= 'GET'>");
  out.println("<a href='?p="+pass+"&pphase=01'><input type='button' value='Inicio'/></a>");
  out.println("<hr>");
  out.println("<h6>&#9400 Carlos Lagarón Real (2021-2022)");
  out.println("</form>");
  out.println("</body>");
  out.println("</html>");
}  else {
  out.println("<?xml version='1.0' encoding='utf-8'?>");
  out.println("<years>");
  for(int i=0;i<ListaYears.size();i++){
  out.println("<year>"+ListaYears.get(i)+"</year>");
  }
  out.println("</years>");
  }
}

public static void mostrarfase12(String pass,String year, Boolean esAuto,PrintWriter out){
int w = 1;
String titulo;
String langs;
String sinopsis;
String[] generos;
StringBuffer sb;
String str;

ArrayList<Movie> ListaMovies = DataModel.getQ1Movies(year);
if (!esAuto) {
  out.println("<h2>Servicio de consulta de películas</h2>");
  out.println("<h3>Consulta 1: Fase 2 (Año = "+year+")</h3>");
  out.println("<h3>Selecciona una película: </h3>");

  for(int i=0; i<ListaMovies.size();i++) {
  titulo = ListaMovies.get(i).getTitle();
  langs = ListaMovies.get(i).getLangs();
  sinopsis = ListaMovies.get(i).getSinopsis();
  String sinopsisbien = sinopsis.trim();
  generos = ListaMovies.get(i).getGenre();
  String generosbien = generos.toString();
  out.println("<h5>"+w+".<a href='?p="+pass+"&pphase=13&pyear="+year+"&pmovie="+ListaMovies.get(i).getTitle()+"'>Película='"+titulo+"'</a> --- Idioma='"+langs+"' --- Generos='"+generosbien+"' --- Sinopsis='"+sinopsisbien+"'</h5>");
  w++;
}
out.println("<a href='?p="+pass+"&pphase=01'><input type='button' value='Inicio'/></a>");
out.println("<a href='?p="+pass+"&pphase=11'><input type='button' value='Atrás'/></a>");
out.println("<hr>");
out.println("<h6>&#9400 Carlos Lagarón Real (2021-2022)");
out.println("</form>");
out.println("</body>");
out.println("</html>");
} else {
  out.println("<?xml version='1.0' encoding='utf-8'?>");
  out.println("<movies>");
  for(int i=0; i<ListaMovies.size();i++) {
  titulo = ListaMovies.get(i).getTitle();
  langs = ListaMovies.get(i).getLangs();
  sinopsis = ListaMovies.get(i).getSinopsis();
  generos = ListaMovies.get(i).getGenre();
  sb = new StringBuffer();
  for(int j = 0; j<generos.length; j++) {
    sb.append(generos[j]);
    sb.append(",");
  }
  str = sb.toString();
  out.println("<movie langs='"+langs+"' genres='"+str+"' synopsis='"+sinopsis+"'>"+titulo+"</movie>");

}
  out.println("</movies>");
}
}

public static void mostrarfase13(String pass, String year, String movie, Boolean esAuto,PrintWriter out){
int w = 1;
String name;
String id;
String rol;
String contacto;
ArrayList<Cast> ListaActores = DataModel.getQ1Cast(year,movie);
if(!esAuto) {
out.println("<h2>Servicio de consulta de películas</h2>");
out.println("<h3>Consulta 1: Fase 3 (Año = "+year+",Película = "+movie+")</h3>");
out.println("<h3>Este es el resultado de la consulta: </h3>");
for(int i=0; i<ListaActores.size();i++) {
  name = ListaActores.get(i).getName();
  id = ListaActores.get(i).getId();
  rol = ListaActores.get(i).getRol();
  contacto = ListaActores.get(i).getContacto();
  out.println("<h5>"+w+".Nombre = '"+name+"' --- ID ='"+id+"' --- Papel='"+rol+"' --- Contacto='"+contacto+"'</h5>");
  w++;
}
out.println("<form method= 'GET'>");
out.println("<a href='?p="+pass+"&pphase=01'><input type='button' value='Inicio'/></a>");
out.println("<a href='?p="+pass+"&pphase=12&pyear="+year+"'><input type='button' value='Atrás'/></a>");
out.println("<hr>");
out.println("<h6>&#9400 Carlos Lagarón Real (2021-2022)");
out.println("</form>");
out.println("</body>");
out.println("</html>");
} else {
out.println("<?xml version='1.0' encoding='utf-8'?>");
out.println("<thecast>");
for(int i=0; i<ListaActores.size();i++) {
  name = ListaActores.get(i).getName();
  id = ListaActores.get(i).getId();
  rol = ListaActores.get(i).getRol();
  contacto = ListaActores.get(i).getContacto();
  out.println("<cast id='"+id+"' role='"+rol+"' contact='"+contacto+"'>"+name+"</cast>");
out.println("</thecast>");
}
}
}

public static void autonoYear(PrintWriter out) {
  out.println("<?xml version='1.0' encoding='utf-8'?>");
  out.println("<wrongRequest>no param:pyear</wrongRequest>");
}

public static void autonoMovie(PrintWriter out) {
  out.println("<?xml version='1.0' encoding='utf-8'?>");
  out.println("<wrongRequest>no param:pmovie</wrongRequest>");
}

public static void autoSinP (PrintWriter out) {
  out.println("<?xml version='1.0' encoding='utf-8'?>");
  out.println("<wrongRequest>no passwd</wrongRequest>");
  return;
}
public static void autoMalaP (PrintWriter out) {
  out.println("<?xml version='1.0' encoding='utf-8'?>");
  out.println("<wrongRequest>bad passwd</wrongRequest>");
  return;
}

public static void noYear(PrintWriter out) {
  out.println("<html>");
  out.println("<body>");
  out.println("<h3>no param:pyear</h3>");
  out.println("</body>");
  out.println("</html>");
}

public static void noMovie(PrintWriter out) {
  out.println("<html>");
  out.println("<body>");
  out.println("<h3>no param:pmovie</h3>");
  out.println("</body>");
  out.println("</html>");
}

public static void SinP (PrintWriter out) {
  out.println("<html>");
  out.println("<body>");
  out.println("<h3>no passwd</h3>");
  out.println("</body>");
  out.println("</html>");
}
public static void MalaP (PrintWriter out) {
  out.println("<html>");
  out.println("<body>");
  out.println("<h3>bad passwd</h3>");
  out.println("</body>");
  out.println("</html>");
}


}
