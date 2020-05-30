import { async, ComponentFixture, TestBed } from "@angular/core/testing";

import { ProblemSolverComponent } from "./problem-solver.component";

describe("ProblemSolverComponent", () => {
  let component: ProblemSolverComponent;
  let fixture: ComponentFixture<ProblemSolverComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ProblemSolverComponent ],
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ProblemSolverComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it("should create", () => {
    expect(component).toBeTruthy();
  });
});
