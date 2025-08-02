class BankAccount {
  private balance: number;

  constructor(initialBalance: number = 0) {
    this.balance = initialBalance;
  }

  deposit(amount: number): void {
    this.balance += amount;
  }

  withdraw(amount: number): void {
    if (amount <= this.balance) {
      this.balance -= amount;
    } else {
      alert("Insufficient balance!");
    }
  }

  getBalance(): number {
    return this.balance;
  }
}

const account = new BankAccount(1000);

function updateBalance() {
  document.getElementById("balance")!.innerText = `Balance: ₹${account.getBalance()}`;
}

function deposit() {
  const amount = parseFloat((document.getElementById("amount") as HTMLInputElement).value);
  account.deposit(amount);
  updateBalance();
}

function withdraw() {
  const amount = parseFloat((document.getElementById("amount") as HTMLInputElement).value);
  account.withdraw(amount);
  updateBalance();
}

updateBalance(); // Initial balance display
