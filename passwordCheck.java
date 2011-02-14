
public class passwordCheck {
	 public static void main (String[] args){ //The code expects 2 arguments: a string (password) and an integer (number of rules to pass)
		 String password = "";
		 int numRulesToPass = 0;
		 if (args.length > 1) {
			  password = args[0];
			    try {
			         numRulesToPass = Integer.parseInt(args[1]);
			    } catch (NumberFormatException e) {
			        System.err.println("Second Argument must be an integer");
			        System.exit(1);
			    }
			}
		 else{
			 System.err.println("You must enter a password and the number of rules the password needs to pass");
		 		System.exit(1);
		 }
		 System.out.println(checkPassword(password, numRulesToPass));
	 }
	 
	 private static String checkPassword(String password, int rules){
		 int pwComplexity = 0;
		 String message ="";
		 boolean numbers = false;
		 boolean upper = false;
		 boolean lower = false;
		 boolean special = false;
		
		 for (int i = 0; i < password.length(); i++){
			 String digit = password.substring(i, i+1); // split the password into characters
			 if (numbers == false && digit.matches("[0-9]")){ // check to see if the character is a number
				 pwComplexity++;
				 numbers = true;
			 }
			 
			 if (upper == false && digit.matches("[A-Z]")){ // check to see if the character is upper case
				 pwComplexity++;
				 upper = true;
			}
			 	
			 if (lower == false && digit.matches("[a-z]")){ // check to see if the character is lower case
				 pwComplexity++;
				 lower = true;
		 	}
			 if (special == false && digit.matches("[^a-z^A-Z^0-9]" )){ // check to see if the character is a special character
				 pwComplexity++;
				 special = true;
			}
			 
		 }
		 if(pwComplexity >= rules)
			 message = "Your Password is complex.";
		 else{
			 message += "To make your password more complex, it should contain " + (rules - pwComplexity) + " of the following rules:\n"; 
			 if(numbers == false)
				 message += "A number\n";
			 if(upper == false)
				 message += "An upper case letter\n";
			 if(lower == false)
				 message += "A lower case letter\n";
			 if(special == false)
				 message += "A special character\n";
		 }
		 return message;
	}

}
