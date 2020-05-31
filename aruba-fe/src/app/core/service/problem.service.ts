import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { catchError } from "rxjs/operators";
import { MathProblem } from "../../shared/model/MathProblem";
import { MathAnswer } from "../../shared/model/MathAnswer";

@Injectable({
  providedIn: "root",
})
export class ProblemService {

  private addUrl = "http://localhost:8080/api/v1/addition";
  private httpOptions = {headers: new HttpHeaders({"Content-Type": "application/json"})};

  constructor(private http: HttpClient) {
  }

  genAdditionProblem(mathAnswer: MathAnswer = {}): Observable<MathProblem> {
    return this.http.post<MathProblem>(this.addUrl, mathAnswer, this.httpOptions)
      .pipe(
        catchError(this.handleError<MathProblem>()),
      );
  }

  private handleError<T>(result?: T): (error: any) => Observable<T> {
    return (error: any): Observable<T> => {
      console.error(error);

      return of(result as T);
    };
  }
}
