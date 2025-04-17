import { CommonModule } from '@angular/common';
import {Component, signal, computed} from '@angular/core';

@Component({
  selector: 'app-signal',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './signal.component.html',
  styleUrls: ['./signal.component.css']
})
export class SignalComponent {
  count = signal(10);

  butter = computed(() => this.count() * 0.1);
  sugar = computed(() => this.count() * 0.05);
  flour = computed(() => this.count() * 0.2);

  update(event: Event) {
    const input = event.target as HTMLInputElement;
    this.count.set(parseInt(input.value));
  }
}