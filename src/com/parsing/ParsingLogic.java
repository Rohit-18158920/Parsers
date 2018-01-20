package com.parsing;

import java.io.*;
import java.util.*;

public class ParsingLogic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
		CreateXml xm=new CreateXml();
		ArrayList<Pojo> fIssueList=new ArrayList<Pojo>();
		String jspfiles=xm.readFile("src/parsingFile.xml");
		//System.out.println(jspfiles);
		DomParser dp=new DomParser();
		fIssueList=dp.parseString(jspfiles);
		PrintWriter writer = new PrintWriter("src/parsedFile.txt", "UTF-8");
		for(int i=1;i<=fIssueList.size();i++)
		{
			writer.println("Issue No:- "+i);
			writer.println(fIssueList.get(i-1).getAbstrct());
			writer.println(fIssueList.get(i-1).getFilePath());
			writer.println(fIssueList.get(i-1).getLineNumber());
			writer.println(fIssueList.get(i-1).getSnippet());
			writer.println();
			writer.println();
		}
		writer.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
