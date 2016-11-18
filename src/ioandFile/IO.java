package ioandFile;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class IO {
	public static void main(String[] args) throws IOException {
		
		/* // 字符流不会乱码
		Reader in=new FileReader("hello.txt");
		BufferedReader reader=new BufferedReader(in);
		char[] buffer=new char[10];
		String str=null;
		while((str=reader.readLine())!=null){
			System.out.println(str);
		}*/
		
		
		/*FileInputStream in=new FileInputStream("hello.txt");
		BufferedInputStream reader=new BufferedInputStream(in);
		byte[] buffer=new byte[1024];
		int len=0;
		while((len=reader.read(buffer))!=-1){
			for(int i=0;i<len;i++){
				System.out.print((char)buffer[i]);
			}
		}*/
		/*
		FileOutputStream out=new FileOutputStream("hellotest.txt");
		OutputStreamWriter writer=new OutputStreamWriter(out,charset);
		try {
			writer.write("中我让你");
		} finally {
			writer.close();
		}*/
		String charset="utf-8";
		FileInputStream in=new FileInputStream("hello.txt");
		InputStreamReader reader=new InputStreamReader(in,charset);
		StringBuffer buffer=new StringBuffer();
		char[] buff=new char[10];
		int cout=0;
		while((cout=reader.read(buff))!=-1){
			for(int i=0;i<cout;i++){
				System.out.print(buff[i]);
			}
		}
		
	}
	
	
}
