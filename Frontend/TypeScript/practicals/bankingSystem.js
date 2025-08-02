var __extends = (this && this.__extends) || (function () {
    var extendStatics = function (d, b) {
        extendStatics = Object.setPrototypeOf ||
            ({ __proto__: [] } instanceof Array && function (d, b) { d.__proto__ = b; }) ||
            function (d, b) { for (var p in b) if (Object.prototype.hasOwnProperty.call(b, p)) d[p] = b[p]; };
        return extendStatics(d, b);
    };
    return function (d, b) {
        if (typeof b !== "function" && b !== null)
            throw new TypeError("Class extends value " + String(b) + " is not a constructor or null");
        extendStatics(d, b);
        function __() { this.constructor = d; }
        d.prototype = b === null ? Object.create(b) : (__.prototype = b.prototype, new __());
    };
})();
// 🔶 ABSTRACT CLASS: Common functionality
var BankAccount = /** @class */ (function () {
    function BankAccount(accountHolder, initialAmount) {
        this.accountHolder = accountHolder;
        this.balance = initialAmount;
    }
    BankAccount.prototype.deposit = function (amount) {
        this.balance += amount;
        console.log("".concat(amount, " deposited. New balance: \u20B9").concat(this.balance));
    };
    BankAccount.prototype.withdraw = function (amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            console.log("".concat(amount, " withdrawn. New balance: \u20B9").concat(this.balance));
        }
        else {
            console.log("Insufficient balance");
        }
    };
    BankAccount.prototype.getBalance = function () {
        return this.balance;
    };
    return BankAccount;
}());
// 🔶 CLASS: SavingAccount inherits BankAccount (INHERITANCE)
var SavingAccount = /** @class */ (function (_super) {
    __extends(SavingAccount, _super);
    function SavingAccount() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.interestRate = 0.05;
        return _this;
    }
    SavingAccount.prototype.calculateInterest = function () {
        return this.getBalance() * this.interestRate;
    };
    SavingAccount.prototype.displayAccountType = function () {
        console.log("Account Type: Saving Account");
    };
    return SavingAccount;
}(BankAccount));
// 🔶 CLASS: CurrentAccount inherits BankAccount (POLYMORPHISM)
var CurrentAccount = /** @class */ (function (_super) {
    __extends(CurrentAccount, _super);
    function CurrentAccount() {
        var _this = _super !== null && _super.apply(this, arguments) || this;
        _this.overdraftLimit = 1000;
        return _this;
    }
    CurrentAccount.prototype.withdraw = function (amount) {
        if (amount <= this.getBalance() + this.overdraftLimit) {
            // calls base method
            console.log("Overdraft used if required.");
            _super.prototype.withdraw.call(this, amount);
        }
        else {
            console.log("Exceeded overdraft limit");
        }
    };
    CurrentAccount.prototype.displayAccountType = function () {
        console.log("Account Type: Current Account");
    };
    return CurrentAccount;
}(BankAccount));
// ✅ Create objects (OBJECTS)
var acc1 = new SavingAccount("Anirudha", 10000);
acc1.displayAccountType(); // Polymorphic behavior
acc1.deposit(2000);
acc1.withdraw(3000);
console.log("Interest: ₹", acc1.calculateInterest());
console.log("\n--------------------\n");
var acc2 = new CurrentAccount("Ravi", 5000);
acc2.displayAccountType(); // Polymorphic behavior
acc2.withdraw(5500); // Overdraft
acc2.deposit(1000);
