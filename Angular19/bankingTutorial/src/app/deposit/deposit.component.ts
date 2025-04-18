import { CommonModule } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-deposit',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './deposit.component.html',
  styleUrl: './deposit.component.css'
})
export class DepositComponent {
@Output() depositAmount=new EventEmitter<number>();
amount: number = 0; // Initialize amount to 0

  deposit() {
    if (this.amount > 0) {
      this.depositAmount.emit(this.amount); // Emit the deposit amount
      this.amount = 0; // Reset the input field after deposit
    } else {
      alert("Please enter a valid amount to deposit.");
    }
  }
}
