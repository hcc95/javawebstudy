package randomAccessFile;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

import javafx.scene.shape.Line;

import javax.sound.sampled.LineEvent;

import org.junit.Test;

public class RandomAccessFileTest {

	
	/**
	 *随机读取类对文件进行读取
	 * @throws IOException
	 */
	@Test
	public void testRandomAcessFile() throws IOException {
		RandomAccessFile access=
				new RandomAccessFile( "hello.txt","rw");
		
		String str=null;
		
		while((str=access.readLine())!= null){
			System.out.println(str);
		}
		
		//access.writeChars("hccll"); 这种方式会有空格
		//access.seek(20);//设置指针 但会替换掉以前的内容
		access.writeBytes("hccll");//这种方式没有空格
		access.close();
	}
	
	
	/**
	 * 第二行插入
	 * 插入一行内容 原来的内容不改变  使用RandomAccessFile
	 * @throws IOException
	 */
	@Test
	public void testRandomAcessFile2() throws IOException {
		RandomAccessFile access=
				new RandomAccessFile( "hello.txt","rw");
		//先读取一行
		String line=access.readLine();
		//把第一行后面的内容先读取到byte数组中
		byte[] buffer=new byte[(int)(access.length())];		
		access.read(buffer);//将内容读取到buffer中
		//移动指针到第一行的后面
		access.seek(line.length());//从第一行开始写
		//写入内容
		access.writeBytes("\nhcc95\n");//这种方式没有空格		
		access.write(buffer);
		access.close();
	}
}
