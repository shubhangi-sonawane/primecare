import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocdashComponent } from './docdash.component';

describe('DocdashComponent', () => {
  let component: DocdashComponent;
  let fixture: ComponentFixture<DocdashComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DocdashComponent]
    });
    fixture = TestBed.createComponent(DocdashComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
