import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class UserService {

    localUser: any = JSON.parse(localStorage.getItem("user")!)

    constructor(private http: HttpClient) { }

    getAllUsers() {
        return this.http.get("http://localhost:8080/api/users")
    }

    getUserById(id: number) {
        return this.http.get("http://localhost:8080/api/users/" + id)
    }

    updateUser(id: number, data: {}) {
        return this.http.put("http://localhost:8080/api/users/" + id, data)
    }

    deleteUser(id: number) {
        return this.http.delete("http://localhost:8080/api/users/" + id)
    }

    getUserByUsername(username: string) {
        return this.http.get("http://localhost:8080/api/users/username?user=" + username)
    }
    getUserByUsernamePrecise(username: string) {
        return this.http.get("http://localhost:8080/api/users/username-precise?user=" + username)
    }

}
