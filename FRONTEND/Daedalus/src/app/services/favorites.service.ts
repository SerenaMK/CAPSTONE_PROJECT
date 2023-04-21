import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class FavoritesService {

    localUser: any = JSON.parse(localStorage.getItem("user")!)

    // favorites; any = this.g

    constructor(private http: HttpClient) { }

    // getFavoritesByUser() {
    //     this.localUser.id
    // }

    getAllFavorites() {
        return this.http.get("http://localhost:8080/api/favorites")
    }

    getFavoritesById(id: number) {
        return this.http.get("http://localhost:8080/api/favorites/" + id)
    }

    updateFavorites(id: number, data: {}) {
        return this.http.put("http://localhost:8080/api/favorites/" + id, data)
    }

    deleteFavorites(id: number) {
        return this.http.delete("http://localhost:8080/api/favorites/" + id)
    }

}
