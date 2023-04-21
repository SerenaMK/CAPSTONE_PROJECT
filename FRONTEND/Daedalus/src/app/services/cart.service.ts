import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class CartService {

    localUser: any = JSON.parse(localStorage.getItem("user")!)

    // userCart = this.getCartById(this.localUser.account.cart.id)

    // thisCart: any = {
    //     id: this.userCart.id,
    //     products: this.userCart.products,
    //     quantity: 1
    // }

    constructor(private http: HttpClient) {}

    getAllCarts() {
        return this.http.get("http://localhost:8080/api/carts")
    }

    getCartById(id: number) {
        return this.http.get("http://localhost:8080/api/carts/" + id)
    }

    updateCart(id: number, data: {}) {
        return this.http.put("http://localhost:8080/api/carts/" + id, data)
    }

    deleteCart(id: number) {
        return this.http.delete("http://localhost:8080/api/carts/" + id)
    }

    // getCartByUser(username: string) {
    //     return this.http.get("http://localhost:8080/api/users/username?user=" + username)
    // }
}
