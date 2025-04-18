import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { BalanceComponent } from "./balance/balance.component";
import { DepositComponent } from "./deposit/deposit.component";
import { WithdrawComponent } from "./withdraw/withdraw.component";
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule ,FormsModule,BalanceComponent, DepositComponent,WithdrawComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'bankingTutorial';
  balance: number = 5000;
  updateBalance(amount: number) {
    this.balance += amount;
  }
}
