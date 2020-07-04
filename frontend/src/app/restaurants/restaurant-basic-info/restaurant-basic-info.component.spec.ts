import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantBasicInfoComponent } from './restaurant-basic-info.component';

describe('RestaurantBasicInfoComponent', () => {
  let component: RestaurantBasicInfoComponent;
  let fixture: ComponentFixture<RestaurantBasicInfoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestaurantBasicInfoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantBasicInfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
