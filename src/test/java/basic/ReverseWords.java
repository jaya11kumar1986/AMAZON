package basic;

public class ReverseWords {

	public static void main(String[] args) {
		
		String name="tamil";
		String rev="";
		for(int i=name.length()-1;i>=0;i--) {
			
			rev=rev+name.charAt(i);
		}
		
		System.out.println(rev);

	}

}
