package user;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class User_register {
	
	private static File file = new File("user.txt");
	static {
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static boolean login(String userName,String password) {
		boolean flag = false;
		BufferedReader  br = null;
		try {
			br = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = br.readLine())!=null) {
				String []data  = line.split(" ");
				if(data[0].equals(userName)&&data[1].equals(password)) {
					flag = true;
					break;
				}
			}
		}catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				br.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		return flag;
	}
	
	public static void register(User user) {
		BufferedWriter bw = null;
		try {
			bw = new BufferedWriter(new FileWriter(file,true));
			bw.write(user.getUserName()+" "+user.getPassword());
			bw.newLine();
			bw.flush();
		}catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try {
				bw.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
}
