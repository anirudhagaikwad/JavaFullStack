// src/app/todo/todo.component.ts
import { Component, signal, computed } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-todo',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent {
  // Signal to store the list of to-do items
  todos = signal<string[]>([]);
  
  // Signal to store the input value
  newTodo = signal<string>('');

  // Computed signal to count total items
  totalItems = computed(() => this.todos().length);

  // Add a new to-do item
  addTodo() {
    const todo = this.newTodo().trim();
    if (todo) {
      this.todos.update(todos => [...todos, todo]);
      this.newTodo.set(''); // Clear input
    }
  }

  // Remove a to-do item by index
  removeTodo(index: number) {
    this.todos.update(todos => todos.filter((_, i) => i !== index));
  }
}

/*
Signals: The todos signal stores the list of to-do items as an array of strings. The newTodo signal tracks the input field value. The totalItems computed signal dynamically calculates the number of items.
Imports: CommonModule for directives like *ngFor, and FormsModule for two-way binding with [(ngModel)].
Methods:
addTodo: Adds a new item to the todos signal if the input isn’t empty and clears the input.
removeTodo: Removes an item by filtering the todos array based on the index.
*/