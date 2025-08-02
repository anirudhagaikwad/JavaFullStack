// 🔶 INTERFACE: Defines structure for any account
interface Account {
    deposit(amount: number): void;
    withdraw(amount: number): void;
    getBalance(): number;
}

// 🔶 ABSTRACT CLASS: Common functionality
abstract class BankAccount implements Account {
    private balance: number;

    constructor(protected accountHolder: string, initialAmount: number) {
        this.balance = initialAmount;
    }

    deposit(amount: number): void {
        this.balance += amount;
        console.log(`${amount} deposited. New balance: ₹${this.balance}`);
    }

    withdraw(amount: number): void {
        if (amount <= this.balance) {
            this.balance -= amount;
            console.log(`${amount} withdrawn. New balance: ₹${this.balance}`);
        } else {
            console.log("Insufficient balance");
        }
    }

    getBalance(): number {
        return this.balance;
    }

    abstract displayAccountType(): void; // ABSTRACT METHOD
}

// 🔶 CLASS: SavingAccount inherits BankAccount (INHERITANCE)
class SavingAccount extends BankAccount {
    private interestRate: number = 0.05;

    calculateInterest(): number {
        return this.getBalance() * this.interestRate;
    }

    displayAccountType(): void {
        console.log("Account Type: Saving Account");
    }
}

// 🔶 CLASS: CurrentAccount inherits BankAccount (POLYMORPHISM)
class CurrentAccount extends BankAccount {
    private overdraftLimit: number = 1000;

    withdraw(amount: number): void {
        if (amount <= this.getBalance() + this.overdraftLimit) {
            // calls base method
            console.log("Overdraft used if required.");
            super.withdraw(amount);
        } else {
            console.log("Exceeded overdraft limit");
        }
    }

    displayAccountType(): void {
        console.log("Account Type: Current Account");
    }
}

// ✅ Create objects (OBJECTS)
const acc1 = new SavingAccount("Anirudha", 10000);
acc1.displayAccountType();               // Polymorphic behavior
acc1.deposit(2000);
acc1.withdraw(3000);
console.log("Interest: ₹", acc1.calculateInterest());

console.log("\n--------------------\n");

const acc2 = new CurrentAccount("Ravi", 5000);
acc2.displayAccountType();              // Polymorphic behavior
acc2.withdraw(5500);                    // Overdraft
acc2.deposit(1000);
