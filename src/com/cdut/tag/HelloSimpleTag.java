package com.cdut.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

public class HelloSimpleTag implements SimpleTag {

	@Override
	public void doTag() throws JspException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doTag");
	}

	@Override
	public JspTag getParent() {
		// TODO Auto-generated method stub
		System.out.println("getParent");
		return null;
	}

	@Override
	public void setJspBody(JspFragment arg0) {
		// TODO Auto-generated method stub
		System.out.println("setJspBody");
	}

	@Override
	public void setJspContext(JspContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("setJspContext");
	}

	@Override
	public void setParent(JspTag arg0) {
		// TODO Auto-generated method stub
		System.out.println("setParent");
	}

}
