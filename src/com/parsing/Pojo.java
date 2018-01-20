package com.parsing;

public class Pojo {
	
	private String abstrct;
	@Override
	public String toString() {
		return "Pojo [abstrct=" + abstrct + ", filePath=" + filePath + ", lineNumber=" + lineNumber + ", snippet="
				+ snippet + "]";
	}
	private String filePath;
	private String lineNumber;
	private String snippet;
	public String getAbstrct() {
		return abstrct;
	}
	public void setAbstrct(String abstrct) {
		this.abstrct = abstrct;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getLineNumber() {
		return lineNumber;
	}
	public void setLineNumber(String lineNumber) {
		this.lineNumber = lineNumber;
	}
	public String getSnippet() {
		return snippet;
	}
	public void setSnippet(String snippet) {
		this.snippet = snippet;
	}

}
