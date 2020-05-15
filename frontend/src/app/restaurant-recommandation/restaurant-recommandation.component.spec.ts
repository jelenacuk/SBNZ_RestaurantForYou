import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RestaurantRecommandationComponent } from './restaurant-recommandation.component';

describe('RestaurantRecommandationComponent', () => {
  let component: RestaurantRecommandationComponent;
  let fixture: ComponentFixture<RestaurantRecommandationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RestaurantRecommandationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RestaurantRecommandationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
