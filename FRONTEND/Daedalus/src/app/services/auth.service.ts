import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class AuthService {

    localUser: any = JSON.parse(localStorage.getItem("user")!)

    isLoggedIn = true
    isAdmin = false
    isMod = false

    constructor(private http: HttpClient) { }

    signUp(url: string, data: {}) {
        return this.http.post(url, data)
    }

    signIn(url: string, data: {}) {
        return this.http.post(url, data)
    }

    isAuthenticated() {
        if(this.localUser) {
            this.isLoggedIn = true
        } else {
            this.isLoggedIn = false
        }
        return this.isLoggedIn
    }

    isRoleAdmin() {
        return this.isAdmin
    }

    isRoleMod() {
        return this.isMod
    }

    logout() {
        localStorage.removeItem("user")
        this.isLoggedIn = false
    }

}
