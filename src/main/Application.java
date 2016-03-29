package main;

import java.io.IOException;

import javax.swing.UIManager;

import database.MySQLAccess;
import gui.MainFrame;

public class Application {
	
	public static void main(String[] args) throws IOException{
		
		try{
			Application.init();
			Application.execute();
			
		}catch(Exception e){
			System.out.println("A critical error has occured. "
					+ "Please contact a system administrator.");
			Application.shutdown();
		}
	}
	

	private static void init() throws Exception {
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	}

	static void execute(){
		//create GUI
		new MainFrame();	
		MySQLAccess.init();
	}
	
	public static void shutdown() throws IOException{
		MySQLAccess.shutdown();
	}
	
	
}