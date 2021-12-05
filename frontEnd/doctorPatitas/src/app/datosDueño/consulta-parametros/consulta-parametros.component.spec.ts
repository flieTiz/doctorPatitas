import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ConsultaParametrosComponent } from './consulta-parametros.component';

describe('ConsultaParametrosComponent', () => {
  let component: ConsultaParametrosComponent;
  let fixture: ComponentFixture<ConsultaParametrosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ConsultaParametrosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ConsultaParametrosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
