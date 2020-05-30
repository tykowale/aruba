import { Component, Input, OnInit } from "@angular/core";
import { Problem } from "../../shared/Problem";
import { ProblemService } from "../../core/service/problem.service";

@Component({
  selector: "app-problem-solver",
  templateUrl: "./problem-solver.component.html",
  styleUrls: ["./problem-solver.component.sass"],
})
export class ProblemSolverComponent implements OnInit {

  problem: Problem;

  @Input()
  answer: number;

  constructor(private problemService: ProblemService) {
  }

  ngOnInit(): void {
    this.fetchProblem();
  }

  fetchProblem(): void {
    this.problemService.genAdditionProblem()
      .subscribe(problem => this.problem = problem);
  }

  check(): void {
    console.log(this.answer);
    this.fetchProblem();
  }

}
