package aug_20;

public class VowelsConsonants {
	    public static void main(String[] args) {
	        String str = "HelloWorld";
	        str = str.toLowerCase();
	        int vowels = 0, consonants = 0;

	        for (char c : str.toCharArray()) {
	            if ("aeiou".indexOf(c) != -1) vowels++;
	            else if (Character.isLetter(c)) consonants++;
	        }

	        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
	    }
	}



	