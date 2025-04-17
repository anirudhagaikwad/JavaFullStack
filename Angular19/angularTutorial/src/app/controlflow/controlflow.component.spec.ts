import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ControlflowComponent } from './controlflow.component';

describe('ControlflowComponent', () => {
  let component: ControlflowComponent;
  let fixture: ComponentFixture<ControlflowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ControlflowComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ControlflowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
