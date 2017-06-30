import {Component, OnInit} from "@angular/core";
import {Title} from "@angular/platform-browser";
import {AppInfoService} from "../services/appinfo-service";

@Component({
    selector: 'app',
    templateUrl: 'app.html',
})
export class AppComponent implements OnInit {
    constructor(private titleService: Title, private appInfoService: AppInfoService) {
        this.appInfoService.getAppInfo().subscribe(
            appInfo => this.titleService.setTitle(appInfo.simulatorName),
            error => console.log(error));
    }

    ngOnInit(): void {
        this.appInfoService.getAppInfo();
    }
}