import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/employee';
import { Router, RouterModule } from '@angular/router';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  imports: [RouterModule,BrowserModule]
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = [];

  constructor(private service: EmployeeService, private router: Router) {}

  ngOnInit() {
    this.service.getAll().subscribe(data => this.employees = data);
  }

  deleteEmployee(id: number) {
    if (confirm('Are you sure to delete?')) {
      this.service.delete(id).subscribe(() => this.ngOnInit());
    }
  }
}
