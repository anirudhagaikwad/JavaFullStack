import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule],
  template: `
    <div style="text-align:center; margin-top: 50px;">
      <h1>Angular 19 Counter using Signal</h1>
      <h2>Count: {{ count() }}</h2>
      <button (click)="increment()">Increment</button>
      <button (click)="decrement()">Decrement</button>
    </div>
  `
})
export class AppComponent {
  count = signal(0);

  increment() {
    this.count.update(val => val + 1);
  }

  decrement() {
    this.count.update(val => val - 1);
  }
}
