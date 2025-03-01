import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DocloginComponent } from './doclogin.component';

describe('DocloginComponent', () => {
  let component: DocloginComponent;
  let fixture: ComponentFixture<DocloginComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DocloginComponent]
    });
    fixture = TestBed.createComponent(DocloginComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
