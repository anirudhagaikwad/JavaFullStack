import { Component, signal } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

interface Employee {
  id: number;
  name: string;
  role: string;
}

@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css']
})
export class EmployeeComponent {
  employees = signal<Employee[]>([]);
  name = '';
  role = '';
  editing = false;
  editId: number | null = null;

  addOrUpdateEmployee() {
    if (this.editing) {
      this.employees.update(list =>
        list.map(emp =>
          emp.id === this.editId ? { ...emp, name: this.name, role: this.role } : emp
        )
      );
      this.cancelEdit();
    } else {
      const newEmp: Employee = {
        id: Date.now(),
        name: this.name,
        role: this.role
      };
      this.employees.update(list => [...list, newEmp]);
      this.name = '';
      this.role = '';
    }
  }

  editEmployee(emp: Employee) {
    this.name = emp.name;
    this.role = emp.role;
    this.editing = true;
    this.editId = emp.id;
  }

  deleteEmployee(id: number) {
    this.employees.update(list => list.filter(emp => emp.id !== id));
  }

  cancelEdit() {
    this.editing = false;
    this.editId = null;
    this.name = '';
    this.role = '';
  }
}
