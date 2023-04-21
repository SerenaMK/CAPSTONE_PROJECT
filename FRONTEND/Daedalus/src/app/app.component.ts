import { Component } from '@angular/core';
import { AuthService } from './services/auth.service';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {
    title = 'Daedalus';

    constructor(private authService: AuthService) { }

    ngOnInit() {
        if(this.authService.localUser) {
            console.log("logged IN");
        } else {
            console.log("logged OUT");
        }
    }
}
