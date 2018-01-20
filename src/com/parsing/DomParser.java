package com.parsing;

import java.util.*;
import java.io.PrintWriter;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class DomParser {
	private XPath xPath;
	private Document doc;
	private String s;
	DocumentBuilder dBuilder;
	public DomParser() throws Exception
	{
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		dBuilder = dbFactory.newDocumentBuilder();
		
	}
	String prse(String s) throws XPathExpressionException {
		String st = xPath.compile(s).evaluate(doc);
		return st;
	}
	public ArrayList<Pojo> parseString(String jspfiles) throws Exception {
		// TODO Auto-generated method stub
		//root-->ReportDefinition/ReportSection[3]/SubSection/IssueListing/Chart/GroupingSection/Issue
		
		ArrayList<Pojo> fIssueList=new ArrayList<Pojo>();
		doc = dBuilder.parse(new InputSource(new StringReader(jspfiles)));
		doc.getDocumentElement().normalize();
		xPath = XPathFactory.newInstance().newXPath();
		s="/ReportDefinition/ReportSection[@optionalSubsections=\"true\"]/SubSection/IssueListing/Chart/GroupingSection[@count=\"856\"]/Issue";		
		NodeList nList = (NodeList) xPath.compile(s).evaluate(doc, XPathConstants.NODESET);
		for (int temp = 0; temp < nList.getLength(); temp++) {
			Pojo pj=new Pojo();
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				pj.setAbstrct(eElement.getElementsByTagName("Abstract").item(0).getTextContent());
				if(eElement.getElementsByTagName("FilePath").getLength()==0)
					pj.setFilePath("not available");
				else
					pj.setFilePath(eElement.getElementsByTagName("FilePath").item(0).getTextContent());
				if(eElement.getElementsByTagName("LineStart").getLength()==0)
					pj.setLineNumber("not available");
				else
					pj.setLineNumber(eElement.getElementsByTagName("LineStart").item(0).getTextContent());
				if(eElement.getElementsByTagName("Snippet").getLength()==0)
					pj.setSnippet("not available");
				else
					pj.setSnippet(eElement.getElementsByTagName("Snippet").item(0).getTextContent());
				fIssueList.add(pj);
			}
		}
		return fIssueList;
	}

}
