import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-controlflow',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './controlflow.component.html',
  styleUrls: ['./controlflow.component.css']
})
export class ControlFlowComponent {
  todos: Array<{done: boolean; text: string}> = [];

  add(text: string) {
    this.todos.push({text, done: false});
  }

  toggle(index: number) {
    this.todos[index].done = !this.todos[index].done;
  }
}