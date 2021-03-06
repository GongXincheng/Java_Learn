package p2_1.net.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceDemo2 {
	public static void main(String[] args) throws IOException {
		System.out.println("接收端启动...");
		/*
		 * 建立UDP接收端的思路
		 * 思路：
		 * 1.建立UDP的socket服务, 因为接收数据,所以确定一个端口号
		 * 2.创建数据包，用于存储接收到的数据，为方便数据包对象的方法解析这些数据
		 * 3.使用socket服务的receive方法将接收到的数据存储到数据包中
		 * 4.通过数据包的方法解析数据包中的数据
		 * 5.关闭资源
		 */
		
		//1.建立UDP的socket服务
		DatagramSocket ds = new DatagramSocket(10000);
		
		while(true){
			//2.创建数据包
			byte[] buf = new byte[1024];
			DatagramPacket dp = new DatagramPacket(buf, buf.length);
		
			//3. 使用socket服务的receive方法，接收到的数据存储到数据
			ds.receive(dp);//阻塞式的。
			
			//4.通过数据包对象的方法，解析数据包中的数据，比如：地址，端口，数据内容
			String ip = dp.getAddress().getHostAddress();
			int port = dp.getPort();
			String text = new String(dp.getData(),0,dp.getLength());
			
			System.out.println("ip:"+ip+"port:"+port+": "+text);
		}
		//关闭资源
		//ds.close();
	}
}
