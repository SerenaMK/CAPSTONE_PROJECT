import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-navbar',
    templateUrl: './navbar.component.html',
    styleUrls: ['./navbar.component.scss']
})
export class NavbarComponent implements OnInit {

    auth: boolean = this.authService.isAuthenticated()
    user: any

    constructor(private authService: AuthService, private userService: UserService) { }

    ngOnInit(): void {
        this.userService.getUserById(this.authService.localUser.id).subscribe(data => {
            this.user = data
        })
    }

    onLogout() {
        this.authService.logout()
        window.location.reload()
    }

}
