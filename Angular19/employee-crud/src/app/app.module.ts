import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeListComponent } from './components/employee-list/employee-list.component';
import { EmployeeFormComponent } from './components/employee-form/employee-form.component';
import { EmployeeDetailComponent } from './components/employee-detail/employee-detail.component';

@NgModule({
  declarations: [
    AppComponent,
    // EmployeeListComponent removed from declarations
    // Removed EmployeeDetailComponent from declarations
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    EmployeeDetailComponent, // Imported EmployeeDetailComponent
    EmployeeListComponent, // Imported EmployeeListComponent
    EmployeeFormComponent // Imported EmployeeFormComponent
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
