import { Problem } from "./Problem";
import { Solution } from "./Solution";

export interface MathAnswer {
  previousProblem?: Problem;
  solution?: Solution;
}
