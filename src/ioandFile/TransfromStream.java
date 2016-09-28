package ioandFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.junit.Test;

public class TransfromStream {

	@Test
	public void testInputStreamReader() throws IOException {
		
		//指向文档的字节流
		InputStream in=new FileInputStream("hello.txt");	
		//把字符流转换为缓冲的字符流
		Reader reader=new InputStreamReader(in);
		//把字符流转换为带缓冲的字符流
		BufferedReader bufferedReader=new BufferedReader(reader);
		String str=null;
		while((str=bufferedReader.readLine())!=null){
			System.out.println(str);
		}
		//关闭
		in.close();
		reader.close();
		bufferedReader.close();
	}

}
