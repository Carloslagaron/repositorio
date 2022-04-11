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

public class XML_Schema_ErrorHandler implements ErrorHandler {

    public void warning(SAXParseException e) throws SAXException {
      handleMessage("Warning",e);
    }
    public void fatalError(SAXParseException e) throws SAXException {
      handleMessage("Fatal",e);
    }
    public void error(SAXParseException e) throws SAXException {
      handleMessage("Error",e);
    }
    private String handleMessage(String level, SAXParseException e) throws SAXException {
      int lineNumber = e.getLineNumber();
      int columnNumber = e.getColumnNumber();
      String message = e.getMessage();
      throw new SAXException("["+ level + "]line nr: " + lineNumber + " column nr:"+ columnNumber + "message: "+message);
    }
  }
