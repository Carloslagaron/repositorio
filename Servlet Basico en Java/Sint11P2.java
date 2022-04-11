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

//@WebServlet ("/Sint11P2")
public class Sint11P2 extends HttpServlet {


    public void init(ServletConfig config) {
        String ruta = config.getServletContext().getRealPath("/p2/mml.xsd");
        DataModel.parseador(ruta);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws IOException, ServletException
    {

            PrintWriter out = res.getWriter();
            String contra = "bimbombim7";
            String fase = req.getParameter("pphase");
            String pass = req.getParameter("p");
            String year = req.getParameter("pyear");
            String movie = req.getParameter("pmovie");
            Boolean esAuto = false;

            req.setCharacterEncoding("utf-8");
            res.setCharacterEncoding("utf-8");
            res.setContentType("text/html");



            if (req.getParameter("auto") == null) {
              esAuto = false;
            } else if(req.getParameter("auto").equals("true")) {
              esAuto = true;
            } else if (req.getParameter("auto").equals("false")){
                esAuto = false;
            }
            if (pass == null) {
                if(esAuto) {
                  FrontEnd.autoSinP(out);
                } else {
                  FrontEnd.SinP(out);
                }
            } else if (!pass.equals(contra)) {
                if(esAuto) {
                  FrontEnd.autoMalaP(out);
                } else {
                  FrontEnd.MalaP(out);
                }
            } else {
              if(fase == null) {
                  fase = "01";
              }
                  switch(fase) {
                     case "01":
                        FrontEnd.mostrarfase01(pass,esAuto,out);
                     break;
                     case "11":
                        FrontEnd.mostrarfase11(pass,esAuto,out);
                    break;
                     case "12":
                        if (year==null) {
                          if(esAuto){
                            FrontEnd.autonoYear(out);
                          } else {
                            FrontEnd.noYear(out);
                          }
                        } else{
                           FrontEnd.mostrarfase12(pass,year,esAuto,out);
                          }
                     break;
                     case "13":
                        if (year == null && movie == null){
                          if(esAuto) {
                          FrontEnd.autonoYear(out);
                        } else {
                            FrontEnd.noYear(out);
                          }
                        } else if(year == null){
                          if(esAuto){
                            FrontEnd.autonoYear(out);
                          } else {
                            FrontEnd.noYear(out);
                          }
                        } else if(movie == null){
                          if(esAuto){
                            FrontEnd.autonoMovie(out);
                          } else {
                            FrontEnd.noMovie(out);
                          }
                        } else {
                          FrontEnd.mostrarfase13(pass,year,movie,esAuto,out);
                        }
                     break;
                 }
            }
    }











        }
