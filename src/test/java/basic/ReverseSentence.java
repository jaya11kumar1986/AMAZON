package basic;

public class ReverseSentence {

	public static void main(String[] args) {
		
		String name="i am jayakumar";
		
		String output="";
		
		String a[]=name.split("\\s");
		
		for(int i=a.length-1;i>=0;i--) {
			
			output=output+a[i]+" ";
		}
		
		System.out.println(output);

	}

}
