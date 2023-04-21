import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

    user: any = {}
    userFull: any = {}
    userAuthenticated: any = {}
    userwithid: any = {}
    loginForm!: FormGroup

    constructor(private authService: AuthService, private userService: UserService, private router: Router) { }

    ngOnInit(): void {
        this.loginForm = new FormGroup({
            username: new FormControl(null, [ Validators.required, Validators.maxLength(15) ]),
            password: new FormControl(null, Validators.required)
        })
    }

    onSubmit() {

        this.user = {
            username: this.loginForm.value.username,
            password: this.loginForm.value.password
        }

        console.log(this.user)

        this.authService.signIn("http://localhost:8080/api/auth/login", this.user).subscribe(data => {
            // console.log("RESPONSE AUTH:")
            // console.log(data)
            this.userAuthenticated = data

            this.userService.getUserByUsernamePrecise(this.userAuthenticated.username).subscribe(data => {
                this.userFull = data
                // console.log("RESPONSE USER:")
                // console.log(this.userFull)

                this.userwithid = {
                    id: this.userFull.id,
                    username: this.userAuthenticated.username,
                    accessToken: this.userAuthenticated.accessToken,
                    tokenType: this.userAuthenticated.tokenType
                }

                console.log("RESPONSE WITH ID:")
                console.log(this.userwithid)

                localStorage.setItem("user", JSON.stringify(this.userwithid))

                this.router.navigate(["/"])
            })
            // localStorage.setItem("username", JSON.stringify(this.userAuthenticated.username))
            // localStorage.setItem("accessToken", JSON.stringify(this.userAuthenticated.accessToken))
        })

    }

}
