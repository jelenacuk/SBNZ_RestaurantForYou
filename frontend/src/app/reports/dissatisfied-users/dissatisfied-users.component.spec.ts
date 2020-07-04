import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DissatisfiedUsersComponent } from './dissatisfied-users.component';

describe('DissatisfiedUsersComponent', () => {
  let component: DissatisfiedUsersComponent;
  let fixture: ComponentFixture<DissatisfiedUsersComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DissatisfiedUsersComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DissatisfiedUsersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
