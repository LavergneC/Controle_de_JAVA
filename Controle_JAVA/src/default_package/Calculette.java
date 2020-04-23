package default_package;

import java.util.Scanner;

public class Calculette {

	public static void main(String[] args) {
		String choix = "";
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\t1. Somme de deux entiers\n"
					+ "\t2. Soustraction de deux entiers\n"
					+ "\t3. Multiplication de deux entiers\n"
					+ "\t4. Divison de deux entiers\n"
					+ "\t5. Sortie du programme\n\n"
					+ "Veuillez entrer votre choix :");

			choix = sc.nextLine();
			if(choix.equals("5"))
				break; // Exit the while, close the app
			
			System.out.println("Entrez les deux entiers séparés d'un espace : ");
			
			// Use the whitespace regex
			String[] nombresString = sc.nextLine().split("\\s+");
			
			// Parse entered number in two int
			int[] nombresInt = {0,0};
			nombresInt[0] = Integer.parseInt(nombresString[0]);
			nombresInt[1] = Integer.parseInt(nombresString[1]);
			
			if(choix.equals("1"))
				System.out.println("Résultat : " + (nombresInt[0] + nombresInt[1]));
			else if(choix.equals("2"))
				System.out.println("Résultat : " + (nombresInt[0] - nombresInt[1]));
			else if(choix.equals("3"))
				System.out.println("Résultat : " + (nombresInt[0] * nombresInt[1]));
			else if(choix.equals("4"))
				// For the division, int are casted for precise result
				System.out.println("Résultat : " + ((double)nombresInt[0] / (double)nombresInt[1]));
		}
		System.out.println("Fin du programme...");
		sc.close();
	}

}
