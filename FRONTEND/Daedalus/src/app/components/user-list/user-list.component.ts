import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-user-list',
    templateUrl: './user-list.component.html',
    styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

    userSearch!: FormGroup
    username: any

    users: any = []

    constructor(private userService: UserService) { }

    ngOnInit(): void {
        this.userService.getAllUsers().subscribe(data => { this.users = data })

        this.userSearch = new FormGroup({
            search: new FormControl(null, Validators.required)
        })
    }

    onSubmit() {
        this.username = this.userSearch.value.search

        if(this.username) {
            this.userService.getUserByUsername(this.username).subscribe(data => {
                if(data) {
                    this.users = []
                    this.users = data
                    // this.users.push(data)
                } else {
                    this.users = []
                }
            })
        } else {
            this.userService.getAllUsers().subscribe(data => { this.users = data })
        }

    }

}
