package ioandFile;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.junit.Test;

/**
 * 对象流完成对象的序列化
 * @author huchaochao
 *
 */
public class SerializableTest {

	@Test
	public void testInputObjectStream() throws ClassNotFoundException, IOException{
		InputStream in=new FileInputStream("d:\\obj.txt");
		ObjectInputStream objectInputStream=
				new ObjectInputStream(in);
		Object obj=objectInputStream.readObject();
		System.out.println(obj);//Person [Name=hcc, age=12]  不会去调用无参数构造器
		objectInputStream.close();
		in.close();
	}
	
	
	/**
	 * 序列化将对象写入硬盘
	 * 
	 * 
	 * 对象序列化的条件是里面的字段必须都实现序列化的接口
	 * 
	 * @throws IOException
	 */
	@Test
	public void testSerializable() throws IOException {
		Person person=new Person("hcc",12);
		person.setAdress(new Address("北京"));//此时的Address也要实现序列化接口
		//使用ObjectOutputStream将对象写到硬盘上
		OutputStream out=new FileOutputStream("d:\\obj.txt");
		ObjectOutputStream objectOutputStream=
				new ObjectOutputStream(out);
		objectOutputStream.writeObject(person);
		out.close();
		objectOutputStream.close();
	}

}
