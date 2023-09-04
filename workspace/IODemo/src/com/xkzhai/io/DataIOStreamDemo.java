package com.xkzhai.io;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.junit.Test;

/**
 * DataInput + DataOutput
 * @author Administrator
 *
 */
public class DataIOStreamDemo {
	/**
	 * 写入
	 * @throws Exception 
	 */
	@Test
	public void write() throws Exception{
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(baos);
		dos.writeByte(-1); // 1
		dos.writeShort(-1); // 2
		dos.writeInt(10); // 4
		dos.writeLong(12L);// 8
		dos.writeFloat(0.5f);// 4
		dos.writeDouble(0.6);// 8
		dos.writeChar('a');  // 2
		dos.writeBoolean(false); // 1
		dos.close();
		baos.close();
		
		byte[] bytes = baos.toByteArray();
		System.out.println(bytes.length);
		
		// 反序列化：怎么写就怎么读
		DataInputStream dis = new  DataInputStream(new ByteArrayInputStream(bytes));
//		System.out.println(dis.readByte());
//		//System.out.println(dis.readInt());
//		System.out.println(dis.readShort());
		
		System.out.println(dis.readUnsignedByte());
		System.out.println(dis.readUnsignedShort());
		dis.close();
	}
}
