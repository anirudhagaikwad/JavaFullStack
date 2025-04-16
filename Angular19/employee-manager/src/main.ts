import { bootstrapApplication } from '@angular/platform-browser';
import { EmployeeComponent } from './app/employee/employee.component';

bootstrapApplication(EmployeeComponent)
  .catch(err => console.error(err));
