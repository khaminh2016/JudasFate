/**
 * 
 */
package SocketBuffer_01_12_2016;

import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * @author KhaMinh
 *
 */
public class ClientBuff extends JFrame {
	
	/**
	 * @param args
	 * @throws IOException
	 * @throws UnknownHostException
	 * @throws InterruptedException 
	 */
	public static void main(String[] a) throws UnknownHostException, IOException, InterruptedException {
		Socket s = new Socket("192.168.186.1", 8888);
		try {
			
		Scanner meo = new Scanner(System.in);
		BufferedWriter oos = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		BufferedReader osi = new BufferedReader(new InputStreamReader(s.getInputStream()));
		//2 Client bat dc socket chao tu sever 
		String sFristLine=osi.readLine();
		//3 in ra man hinh
		System.out.println(sFristLine);
		for (int i = 1; i >0 ; i++) {
			//4 client gui lai sever loi chao
			oos.write(meo.nextLine());
			//5 xuong dong het 1 dong
			oos.newLine();
			//6 gui qa sever ne
			oos.flush();
			//12 nhan goi tin sever va doc ne
			String sLine=osi.readLine();
			//13 in ra man hinh cho may thim coi
			System.out.println(sLine);
			
			Thread.sleep(100);
		}
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(null, "Full roi fen");
		}
	}

}
