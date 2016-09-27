package ioandFile;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

public class FileTest {

	/**
	 * file 代表物理意义的文件和目录
	 * @throws IOException 
	 */
	@Test
	public void testFile() throws IOException {
		//1 创建File对象 文件必须放在根目录下
		File file=new File("hello.txt");
		
		//测试文件对象方法
		
		//1 文件名
		String fileName=file.getName();
		System.out.println(fileName);
		
		// 访问绝对路径
		String path=file.getAbsolutePath();
		System.out.println(path);
		
		// 文件重命名
		//TODO
//		file.renameTo(new File("D:\\hello.txt"));
		
		System.out.println(file.exists());
		
		
		//创建文件
		File file2=new File("abc.txt");
		file2.createNewFile();
	}

}
