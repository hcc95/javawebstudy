package ioandFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

import org.junit.Test;

public class IOTest {

	/**
	 * 字节输入流 读取到字节中
	 * @throws IOException
	 */
	@Test
	public void testInputStream() throws IOException {
		
		//1 创建一个字节输入流  //文件必须放在根目录下
		InputStream in=new FileInputStream("hello.txt");
		//2 读取文件内容
		//2.1 读取一个字节
		
		/*int result=in.read();
		while(result!=-1){
			System.out.print((char)result);
			result=in.read();
		}*/
		
		//2.2 一次读取一组：一组字符
		byte[] buffer=new byte[10];
		int len=0;
		 while((len=in.read(buffer))!=-1){
			 for(byte b:buffer){
				 System.out.print((char)b);
			 }
		 }
		
		//2.3 把内容读取到字节数组的部分连续元素中  不常用
		 byte[] result=new byte[1024*10];
		 in.read(result, 10, in.available());
		 //3 关闭流资源
		in.close();
		
	}
	
	/**
	 * 读取到字符中
	 * @throws IOException 
	 */
	@Test
	public void testReader() throws IOException{
		Reader reader=new FileReader("hello.txt");
		char[] buffer=new char[10];
		int len=0;
		while((len=reader.read(buffer))!=-1){
			for(int i=0;i<len;i++){
				System.out.print(buffer[i]);
			}			
		}
		reader.close();
	}
	
	
	/**
	 * 输出字节流
	 * @throws IOException 
	 */
	@Test
	public void testOutputStream() throws IOException{
		OutputStream out=new FileOutputStream("acbd.txt");
		String content="www.hcc.com\n\r122333";
		/*byte[] buffer=new byte[10];
		int len=10;
		int time=content.length()/10;
		if(content.length()%10 !=0){
			time++;
		}
		byte[] contenBytes=content.getBytes();
		for(int i=0;i<content.length()/10;i++){
			//把String拆分成多个buffer
			out.write(contenBytes,i*10,len);
		}
		//读取剩下部分
		if(content.length()%10 !=0){
			out.write(contenBytes,
					(content.length()/10)*10,content.length()-(content.length()/10)*10);
		}*/
		out.write(content.getBytes());	
		out.close();
	}
	
	/**
	 * 利用字节输入输出流 完成hello.txt文件的文件
	 * 把文件复制成hello2.txt 
	 * 
	 * 此方式可以用于复制其他文件
	 * 
	 * @throws IOException 
	 */
	@Test
	public void testCopyFile() throws IOException{
		//1 创建定位hello.txt的文件
		InputStream in=new FileInputStream("hello.txt");
		//2 创建定位到hello.txt 的文件输出流
		OutputStream out=new FileOutputStream("hello2.txt");
		//3 创建一个byte数据 用于读写文件
		byte[] buffer=new byte[1024*10];
		int len=0; 
		//4 读写文件
		//in.read(buffer); out.write(buffer,0,len);
		while ((len=in.read(buffer))!=-1) {
//			out.write(buffer,0,len);
			out.write(buffer);
		}
		//5关闭输入输出流
		out.close();
		in.close();
		
	}
	
	/**
	 * 利用字节输入输出流 完成hello.txt文件的文件
	 * 把文件复制成hello2.txt 
	 * 
	 * 此方式可以用于复制其他文件
	 * 
	 * @throws IOException 
	 */
	@Test
	public void testCopyByReaderFile() throws IOException{
		//1 创建定位hello.txt的文件
		Reader in=new FileReader("hello.txt");
		//2 创建定位到hello.txt 的文件输出流
		Writer out=new FileWriter("hello2.txt");
		//3 创建一个char数据 用于读写文件
		char[] buffer=new char[1024*10];
		int len=0;//保证文件完整读取  文件不是10的整数倍
		//4 读写文件
		//in.read(buffer); out.write(buffer,0,len);
		while ((len=in.read(buffer))!=-1) {
//			out.write(buffer,0,len);
			out.write(buffer);
		}
		//5关闭输入输出流
		out.close();
		in.close();
		
	}
}
