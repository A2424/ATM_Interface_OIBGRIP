import java.util.Scanner;

class Application {
	int balAmount;
	String transac;
	String uname;
	int upin;

	public Application(String username, int pin) {
		// TODO Auto-generated constructor stub
		this.uname = username;
		this.upin = pin;
	}

	public void deposit(int amount) {
		if (amount > 0) {
			balAmount = balAmount + amount;
			transac = "\nadded: " + amount + ".\n";
		}
		System.out.println("\nYou added " + amount + " in your account\n");
		System.out.println("\nCurrent balance of your account is " + balAmount + "\n");
	}

	public void withdraw(int amount) {
		if (amount <= balAmount) {
			balAmount = balAmount - amount;
			transac += "\nYou withdraw " + amount + ".\n";
			System.out.println(amount + " withdraw Successfully\n");
		} else {
			System.out.println("\nYou have not sufficient amount to withdraw " + amount);
		}

		System.out.println("\nYour current balance is " + balAmount);
	}

	public void transacHistory() {
		if (transac != null) {
			System.out.println("\nAccount history\n");
			System.out.println(transac);
		} else {
			System.out.println("\nNo transaction occur");
		}
	}

	public void transfer(int amount, String name) {
		if (amount > 0 && name != null) {
			balAmount = balAmount - amount;
			System.out.println("\nYou have tranfered " + amount + " to " + name);
		}
		System.out.println("\nYour current balance is " + balAmount);
		transac += "\nYou have transfered " + amount + " to " + name + ".\n";
	}

	public void displayDetails() {
		int click;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nWelcome " + uname);
		System.out.println("\nYour pin is " + upin);
		System.out.println("\n");

		System.out.println("1. Balance");
		System.out.println("2. Deposit");
		System.out.println("3. Withdraw");
		System.out.println("4. Transaction History");
		System.out.println("5. Transfer");
		System.out.println("6. Quit");

		do {
			System.out.println("============================================");
			System.out.println("Enter an option");
			System.out.println("============================================");
			click = sc.nextInt();
			System.out.println("\n");

			switch (click) {

			case 1:
				System.out.println("---------------------------------------");
				System.out.println("Balance = " + balAmount);
				System.out.println("---------------------------------------");
				System.out.println("\n");
				break;

			case 2:
				System.out.println("---------------------------------------");
				System.out.println("Enter an amount to deposit: ");
				System.out.println("---------------------------------------");
				int amount = sc.nextInt();
				deposit(amount);
				System.out.println("\n");
				break;

			case 3:
				System.out.println("----------------------------------------");
				System.out.println("Enter an amount to withdraw: ");
				System.out.println("----------------------------------------");
				int amount1 = sc.nextInt();
				withdraw(amount1);
				System.out.println("\n");
				break;

			case 4:
				System.out.println("---------------------------------------");
				transacHistory();
				System.out.println("---------------------------------------");
				System.out.println("\n");
				break;

			case 5:
				System.out.println("----------------------------------------");
				System.out.println("\nEnter the details to transfer the amount: ");
				System.out.println("---------------------------------------");
				System.out.println("\nEnter the amount");
				int amount2 = sc.nextInt();
				System.out.println("\nEnter the name of receiver");
				String recname = sc.next();
				transfer(amount2, recname);
				System.out.println("---------------------------------------");
				System.out.println("\n");
				break;

			case 6:
				System.out.println("***************************************");
				break;

			default:
				System.out.println("invalid option!!..Please enter again");
				break;

			}
		} while (click != 6);

		System.out.println("Thank You for using our services");
		System.out.println("***************************************");

	}

}

public class ATM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\nEnter Your Name: \n");
			String username = sc.nextLine();

			if (username == "") {
				System.out.print("\nError! Please Try Again\n");
			} else {
				System.out.println("\nEnter Your Pin " + username + " : ");
				int pin = sc.nextInt();
				int len = (int) (Math.log10(pin) + 1);
				if (len == 4) {
					Application app = new Application(username, pin);
					app.displayDetails();
				} else {
					System.out.println("\nError!Please enter the right pin number\n");
				}

			}

		}

	}

}
