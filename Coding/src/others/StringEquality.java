package others;

public class StringEquality {

	public static void main(String[] args) {
		
		//Below questions were asked in interviews I gave
		
		String s1 = "Shankha";
		String s2 = "Shankha";
		String s3 = new String("Shankha");
		String s4 = new String ("Shankha");

		System.out.println("s1 == s2 : " + (s1 == s2));
		System.out.println("s3 == s4 : " + (s3 == s4));
		System.out.println("s1 == s4 : " + (s1 == s4));
		
		System.out.println("s1.equals(s2) : " + s1.equals(s2));
		System.out.println("s3.equals(s4) : " + s3.equals(s4));
		System.out.println("s1.equals(s4) : " + s1.equals(s4));
		
		System.out.println("s1 : " + s1.hashCode() + " s2 : " + s2.hashCode() + " s3 : " + s3.hashCode()
		+ " s4 : " + s4.hashCode());
		
		
		StringBuilder sb1 = new StringBuilder("Shankha");
		StringBuilder sb2 = new StringBuilder("Shankha");
		
		System.out.println("sb1 == sb2 : " + (sb1 == sb2));
		
		
		//THE BELOW IS BIT UNEXPECTED HERE. StringBuilder doesn't override equals 
		System.out.println("sb1.equals(sb2) : " + sb1.equals(sb2)); 
		
		
		
		System.out.println("s1.equals(sb1) : " + s1.equals(sb1));
		
		//NOTICE EVEN THE HASHCODE VALUES ARE DIFFERENT HERE
		System.out.println("sb1 : " + sb1.hashCode() + " sb2 : " + sb2.hashCode());

	}

}
