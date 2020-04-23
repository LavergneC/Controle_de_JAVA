package default_package;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class NBOcc {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		if(args.length != 2) {
			System.out.println("Usage: NBOcc <fileName> <word>");
			return;
		}
		int wordCounter = 0;

		try(BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
			String line = br.readLine();

			while (line != null) {
				for(String word : line.split(" ")) {
					if(word.equals(args[1]))
						wordCounter++;
				}
				line = br.readLine();
			}
		}

		System.out.println("Le mot <<" + args[1] + ">> figure " + wordCounter + " dans le fichier <<" + args[0] + ">>");
	}
}
