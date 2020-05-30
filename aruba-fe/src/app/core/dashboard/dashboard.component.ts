import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-dashboard",
  templateUrl: "./dashboard.component.html",
  styleUrls: ["./dashboard.component.sass"],
})
export class DashboardComponent implements OnInit {

  header = "Let's Add";

  constructor() {
  }

  ngOnInit(): void {
  }

}
