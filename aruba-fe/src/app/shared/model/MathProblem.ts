import { Problem } from "./Problem";
import { PreviousResult } from "./PreviousResult";

export interface MathProblem {
  problem: Problem;
  previousResult?: PreviousResult;
}
