import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../../services/employee.service';
import { Employee } from '../../models/employee';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  imports: [FormsModule,BrowserModule]
})
export class EmployeeFormComponent implements OnInit {
  employee: Employee = {
    firstName: '',
    lastName: '',
    email: '',
    phoneNumber: '',
    hireDate: '',
    salary: 0
  };
  isEditMode = false;

  constructor(
    private service: EmployeeService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit() {
    const id = this.route.snapshot.paramMap.get('id');
    if (id) {
      this.isEditMode = true;
      this.service.getById(+id).subscribe(emp => this.employee = emp);
    }
  }

  onSubmit() {
    if (this.isEditMode) {
      this.service.update(this.employee.empId!, this.employee).subscribe(() => this.router.navigate(['/employees']));
    } else {
      this.service.add(this.employee).subscribe(() => this.router.navigate(['/employees']));
    }
  }
}
