import { Component, Input, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-user-card',
    templateUrl: './user-card.component.html',
    styleUrls: ['./user-card.component.scss']
})
export class UserCardComponent implements OnInit {

    @Input() user: any;

    constructor(private userService: UserService) { }

    ngOnInit(): void {
        console.log(this.user)
        console.log(this.user.roles.length)
    }

    onClickUpdateToUser() {
        this.user.roles = [
            {
                "id": 2,
                "roleName": "ROLE_USER"
            }
        ]

        this.userService.updateUser(this.user.id, this.user).subscribe(data => console.log(data))
    }

    onClickUpdateToMod() {
        this.user.roles = [
            {
                "id": 3,
                "roleName": "ROLE_MODERATOR"
            },
            {
                "id": 2,
                "roleName": "ROLE_USER"
            }
        ]

        this.userService.updateUser(this.user.id, this.user).subscribe(data => console.log(data))
    }

    onClickUpdateToAdmin() {
        this.user.roles = [
            {
                "id": 1,
                "roleName": "ROLE_ADMIN"
            },
            {
                "id": 3,
                "roleName": "ROLE_MODERATOR"
            },
            {
                "id": 2,
                "roleName": "ROLE_USER"
            }
        ]

        this.userService.updateUser(this.user.id, this.user).subscribe(data => console.log(data))
    }

}
