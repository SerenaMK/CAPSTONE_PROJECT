import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';

@Component({
    selector: 'app-register',
    templateUrl: './register.component.html',
    styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

    user: any = {}

    registerForm!: FormGroup

    constructor(private authService: AuthService) { }

    ngOnInit(): void {
        this.registerForm = new FormGroup({
            firstname: new FormControl(null, [ Validators.required, Validators.maxLength(20) ]),
            lastname: new FormControl(null, [ Validators.required, Validators.maxLength(20) ]),
            username: new FormControl(null, [ Validators.required, Validators.maxLength(15) ]),
            email: new FormControl(null, [ Validators.required, Validators.email ]),
            password: new FormControl(null, Validators.required)
        })
    }

    onSubmit() {

        this.user = {
            firstname: this.registerForm.value.firstname,
            lastname: this.registerForm.value.lastname,
            username: this.registerForm.value.username,
            email: this.registerForm.value.email,
            password: this.registerForm.value.password,
            roles: ["ROLE_USER"]
        }

        console.log(this.user)

        this.authService.signUp("http://localhost:8080/api/auth/register", this.user).subscribe(data => console.log(data))

    }

}
