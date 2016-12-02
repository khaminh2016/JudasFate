/**
 * 
 */
package SocketBuffer_01_12_2016;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * @author KhaMinh
 *
 */
public class SeverBuff {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		ServerSocket sSever = new ServerSocket(8888);
		Socket s = sSever.accept();
		try {
			
		Scanner meo = new Scanner(System.in);
		BufferedReader osiSever = new BufferedReader(new InputStreamReader(s.getInputStream()));
		BufferedWriter ossSever = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		System.out.println("Dang ket noi CLient...");
		//1 Sever gui lien ket dau tien CHao Client
		ossSever.write("Chao Client");
		//1.1 het 1 dong cua sever
		ossSever.newLine();
		//1.2 day qa client ne
		ossSever.flush();
		//7 doc goi tin tu client vua gui qa
		String sFirstLine=osiSever.readLine();
		//8 in ra man hinh client vua gui
		System.out.println(sFirstLine);
		while (true) {
			//9 viet goi tin gui lai cho client
			ossSever.write(meo.nextLine());
			//10 het 1 dong
			ossSever.newLine();
			//11 gui qa client ne
			ossSever.flush();
			//13 nhan goi tin tu client ne
			String sLine=osiSever.readLine();
			//14 in ra man hinh cho may thim coi ne
			System.out.println(sLine);
			
		}
		} catch (IOException e) {
			JOptionPane.showConfirmDialog(null, "Full roi fen");
		}
	}
                                                                           
}
