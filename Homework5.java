import java.util.Scanner;

//Elizabeth Davis

/*
 *(a) (20 points) The shift cipher, encryption only: given input x, s and m, output (x + s) rem m. 
 *Your result should be non-negative and strictly smaller than m.
(b) (20 points) The gcd: given input x and y, output gcd(x,y). 
Write your own code for this using the euclidean algorithm, you may not use code written by anyone else.
 Note: you are not required to find modular inverses, only the gcd.
(c) (20 points) The multiplicative cipher encryption only:
 given input a, b, m, output (a × b) rem m if the gcd of a and m is 1, else output an error message.
  Use the code written in part (b). Your output should be non-negative and strictly smaller than m.
It is easy to test your code. Run it for small values of a, b, and m, and see if you get the expected results. 
That is how the TA will grade it, by testing it on small examples. 
Make sure you have a README file which describes how each program can be called, and also what it does.
 Make sure your code is well documented, there are points set aside for this.
 *
 */
public class Homework5 {
	
	public static void main(String[] argv) {
		int num = 0;
		Scanner scanner = new Scanner(System.in);
		while(num != 4) {
			System.out.println("What would you like to compute?");
			System.out.println("Press 1 for shift cipher, 2 for gcd, 3 for multiplicative cipher, 4 to exit");
			num = scanner.nextInt();
			if(num == 1) {
				System.out.println("Enter an integer x: ");
				int x = scanner.nextInt();
				System.out.println("Enter an integer s: ");
				int s = scanner.nextInt();
				System.out.println("Enter an integer m: ");
				int m = scanner.nextInt();
				System.out.println("The shifted value of x is: ");
				System.out.println(shiftCipher(x, s, m));
			}
			
			if(num == 2) {
				System.out.println("Enter an integer x: ");
				int x = scanner.nextInt();
				System.out.println("Enter an integer y: ");
				int y = scanner.nextInt();
				System.out.println("The gcd of x and y is: ");
				System.out.println(gcd(x, y));
			}
			
			if(num ==3) {
				System.out.println("Enter an integer a: ");
				int x = scanner.nextInt();
				System.out.println("Enter an integer b: ");
				int s = scanner.nextInt();
				System.out.println("Enter an integer m: ");
				int m = scanner.nextInt();
				System.out.println("The multiplicative cipher of a is: ");
				System.out.println(mcipher(x, s, m)); 
			}
			
			if(num == 4) {
				break;
			}
		}
		
		
	}

	//calculate the (x+s) rem m - aka find the remainder of (x + s) / m
	public static int shiftCipher(int x, int s, int m) {
		int mod = 0;
		mod = (x+s) % (m); 				//calculate it 
		
		//check to see if it's negative 
		if (mod < 0) {
			mod = mod + m;
		}
		
		return mod;
	}
	
	public static int gcd(int a, int b) {
		//Make sure a is greater than b:
		//System.out.println("a = " + a + " b = " + b);
		if(a < b) {			//swap 
			//System.out.println("Swapping");
			int temp = a;;
			a = b;			//Make a greater 
			b = temp;
		}
		
		while(b != 0) {
			int t = b;
			b = a % b;
			a = t;
			//System.out.println("a = " + a + " b = " + b);
		}
		
		return a;
	}
	
	public static int mcipher(int a, int b, int m) {
		int mcipher = 0;
		if(gcd(a, m) != 1) {
			System.out.println("ERROR: please enter different numbers");
			return 0;
		}
		
		mcipher = (a*b) % (m); 				//calculate it 
		
		//check to see if it's negative 
		if (mcipher < 0) {
			mcipher = mcipher + m;
		}
		return mcipher;
	}
}
