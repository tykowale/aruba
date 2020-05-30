import { Injectable } from "@angular/core";
import { Observable, of } from "rxjs";
import { Problem } from "../../shared/Problem";
import { HttpClient, HttpHeaders } from "@angular/common/http";

@Injectable({
  providedIn: "root",
})
export class ProblemService {

  private addUrl = "http://localhost:8080/api/v1/addition";
  private httpOptions = {headers: new HttpHeaders({"Content-Type": "application/json"})};

  constructor(private http: HttpClient) {
  }

  genAdditionProblem(): Observable<Problem> {
    return this.http.get<Problem>(this.addUrl);
    // return of(
    //   {x: this.randomNumber(), y: this.randomNumber(), op: "ADD"},
    // );
  }

  randomNumber(): number {
    return Math.floor((Math.random() * 100) + 1);
  }
}
