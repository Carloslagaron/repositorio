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

    public class Cast  implements Comparator<Cast>{
      String nombre;
      String id;
      String contacto;
      String rol;


      public Cast(){}
          @Override
          public int compare (Cast c1, Cast c2) {
            int principal = 0;
            int secundario = 0;
            if(c1.getRol().equals("Supporting")) {
              principal = 3;
            } else if(c1.getRol().equals("Main")) {
              principal = 2;
            } else {
              principal = 1;
            }

            if(c2.getRol().equals("Supporting")) {
              secundario = 3;
            } else if(c2.getRol().equals("Main")) {
              secundario = 2;
            } else {
              secundario = 1;
            }
            if(principal > secundario) {
                return(-1);
            } else if(principal < secundario) {
                return(1);
            } else {
              return c1.getId().compareTo(c2.getId());
            }
          }

        public static Comparator<Cast> ComparaRoles = new Comparator<Cast>() {
          public int compare (Cast c1, Cast c2) {
            int principal = 0;
            int secundario = 0;
            if(c1.getRol().equals("Supporting")) {
              principal = 3;
            } else if(c1.getRol().equals("Main")) {
              principal = 2;
            } else {
              principal = 1;
            }

            if(c2.getRol().equals("Supporting")) {
              secundario = 3;
            } else if(c2.getRol().equals("Main")) {
              secundario = 2;
            } else {
              secundario = 1;
            }
            if(principal > secundario) {
                return(-1);
            } else if(principal < secundario) {
                return(1);
            } else {
              return c1.getId().compareTo(c2.getId());
            }
          }
        };


      public void setName(String nombre){
        this.nombre = nombre;
      }

      public void setId(String id) {
        this.id = id;
      }

      public void setContacto(String contacto){
        this.contacto = contacto;
      }

      public void setRol(String rol){
        this.rol = rol;
      }

      public String getName(){
        return nombre;
      }

      public String getId(){
        return id;
      }


      public String getContacto(){
        return contacto;
      }

      public String getRol(){
        return rol;
      }
    }
