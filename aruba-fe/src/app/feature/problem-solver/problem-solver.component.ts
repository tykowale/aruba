import { Component, Input, OnInit } from "@angular/core";
import { Problem } from "../../shared/model/Problem";
import { ProblemService } from "../../core/service/problem.service";
import { MathAnswer } from "../../shared/model/MathAnswer";
import { PreviousResult } from "../../shared/model/PreviousResult";
import { MathProblem } from "../../shared/model/MathProblem";

@Component({
  selector: "app-problem-solver",
  templateUrl: "./problem-solver.component.html",
  styleUrls: ["./problem-solver.component.sass"],
})
export class ProblemSolverComponent implements OnInit {

  problem: Problem;
  previousResult: PreviousResult;

  @Input()
  answer: number;

  constructor(private problemService: ProblemService) {
  }

  ngOnInit(): void {
    this.fetchProblem();
  }

  fetchProblem(mathAnswer: MathAnswer = {}): void {
    this.problemService.genAdditionProblem(mathAnswer)
      .subscribe(data => this.readResponse(data));
  }

  check(): void {
    const mathAnswer = {
      previousProblem: this.problem,
      solution: {answer: this.answer},
    } as MathAnswer;
    console.log(mathAnswer);
    this.fetchProblem(mathAnswer);
  }

  readResponse(data: MathProblem): void {
    this.problem = data.problem;
    this.previousResult = data.previousResult;
    delete this.answer;
  }
}
