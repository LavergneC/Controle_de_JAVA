package exercice_5;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class GUI extends JFrame{
	public GUI() {
		Panel mainPanel = new Panel();
		mainPanel.setLayout(new BorderLayout());
		this.setSize(600, 270);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Changer un mot de passe");

		this.add(mainPanel);

		JButton launch = new JButton("Lancer la modification");
		mainPanel.add(launch, BorderLayout.SOUTH);


		JPanel gridPanel = new JPanel();
		gridPanel.setLayout(new GridLayout(0,2));
		mainPanel.add(gridPanel);

		gridPanel.add(new JLabel("Nom:"));
		JTextField name_field = new JTextField();
		gridPanel.add(name_field);
		gridPanel.add(new JLabel("Mot de passe:"));
		JPasswordField old_pass_field = new JPasswordField();
		gridPanel.add(old_pass_field);
		gridPanel.add(new JLabel("Nouveau mot de passe:"));
		JPasswordField new_pass_field = new JPasswordField();
		gridPanel.add(new_pass_field);
		gridPanel.add(new JLabel("Retapez le mot de passe:"));
		JPasswordField new_pass_field_2 = new JPasswordField();
		gridPanel.add(new_pass_field_2);
		this.setVisible(true);
	}

	public boolean veriFier(String nom, String pass) {

		try(BufferedReader br = new BufferedReader(new FileReader("passwd.txt"))) {
			String line = br.readLine();

			while (line != null) {
				if(line.split(":")[0].equals(nom)) 
					return line.split(":")[1].equals(pass);

				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	

		return false;
	}

	public boolean estIdentique(String str, String str1) {
		return str.equals(str1);
	}

	public void remPlace(File f, String ligne1, String ligne2) {
		String allFile = "";
		File myObj = new File("filename.txt");
		Scanner myReader;
		try {
			myReader = new Scanner(myObj);
		
		while (myReader.hasNextLine()) {
			// Put all the file into allFile String
			allFile += myReader.nextLine();
		}
		myReader.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		// Save the file Path for later
		String fPath = f.getPath();
		
		// Create a new empty file
		f.delete();
		f = new File(fPath);
		try {
			f.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Read the file String line by line
		String[] lines = allFile.split(System.getProperty("\n"));
		
		// output variable will be write into the new file
		String output = "";
		
		for(String line : lines) {
			if(line.equals(ligne1))
				output += ligne2;
			else
				output += line;
		}
		
		// Write into the new file
		try {
			FileWriter myWriter = new FileWriter(fPath);
			 myWriter.write(output);
		     myWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

		public static void main(String[] args) {
			@SuppressWarnings("unused")
			GUI trajFrame = new GUI();
		}
	}
