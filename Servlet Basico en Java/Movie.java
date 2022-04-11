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

public class Movie implements Comparator<Movie> {
  String titulo;
  String langs;
  String duracion;
  String sinopsis;
  String[] generos;

  public Movie() {}

  @Override
  public int compare (Movie m1, Movie m2) {
    if(m1.getGenre().length > m2.getGenre().length) {
        return(-1);
    } else if(m1.getGenre().length < m2.getGenre().length) {
        return(1);
    } else {
      return m1.getTitle().compareTo(m2.getTitle());
    }
  }

  public static Comparator<Movie> ComparaGeneros = new Comparator<Movie>() {
    public int compare (Movie m1, Movie m2) {
      if(m1.getGenre().length > m2.getGenre().length) {
          return(-1);
      } else if(m1.getGenre().length < m2.getGenre().length) {
          return(1);
      } else {
        return m1.getTitle().compareTo(m2.getTitle());
      }
    }
  };

  public void setTitle(String titulo){
    this.titulo = titulo;
  }

  public void setGenre(String[] generos) {
    this.generos = generos;
  }

  public void setLangs(String langs){
    this.langs = langs;
  }

  public void setDuration(String duracion){
    this.duracion = duracion;
  }

  public void setSinopsis(String sinopsis){
    this.sinopsis = sinopsis;
  }

  public String getTitle(){
    return titulo;
  }

  public String[] getGenre(){
    return generos;
  }


  public String getLangs(){
    return langs;
  }

  public String getSinopsis(){
    return sinopsis;
  }
}
