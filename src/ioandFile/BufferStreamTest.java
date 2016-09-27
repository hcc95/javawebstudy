package ioandFile;

import static org.junit.Assert.*;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

public class BufferStreamTest {
	
	
	/**
	 * 复制文件
	 * testBufferReaderandWriter 是Reader和Writer的一种包装
	 * 提高了读写的效率；
	 * 
	 * @throws IOException 
	 */
	@Test
	public void testBufferReaderandWriter() throws IOException {
		//1 穿件buffered输入输出流
		Reader in=new FileReader("hello.txt");
		BufferedReader reader=new BufferedReader(in);
		Writer out=new FileWriter("hello4.txt");
		BufferedWriter writer=new BufferedWriter(out);
		//2 读写文件
		String str=null;
		int i=0;
		while((str=reader.readLine())!=null){
			if(i != 0){
				writer.write("\n");
			}
			writer.write(str);
			i++;
			
		}
		//3 关闭流，内部会关闭节点流
		writer.close();
		reader.close();
	}
	
	/**
	 * 复制文件
	 * testInputStreamandOutputStream
	 * 提高了读写的效率；
	 * 
	 * @throws IOException 
	 */
	@Test
	public void testInputStreamandOutputStream() throws IOException {
		//1 穿件buffered输入输出流
		InputStream in=new FileInputStream("hello.txt");
		BufferedInputStream reader=new BufferedInputStream(in);
		OutputStream out=new FileOutputStream("hello5.txt");
		BufferedOutputStream writer=new BufferedOutputStream(out);
		//2 读写文件
		byte[] buffer=new byte[10];
		int len=0;
		while((len=reader.read(buffer))!=-1){
			writer.write(len);
		}
		//3 关闭流，内部会关闭节点流
		writer.close();
		reader.close();
	}
	
	
}
