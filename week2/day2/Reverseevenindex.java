package week2.day2;

public class Reverseevenindex {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String test = "I am a software tester";
		String words[] = test.split(" ");
		char[] text;
		for (int i = 0; i < words.length; i++) {
			if (i % 2 != 0) {
				text = words[i].toCharArray();
				for (int j = text.length - 1; j >= 0; j--) {
					System.out.print(text[j]);

				}
			}
			else
			{
				System.out.print(words[i]);
			}
             System.out.print(" ");
		}
	}

}
