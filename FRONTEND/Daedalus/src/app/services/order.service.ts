import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class OrderService {

    localUser: any = JSON.parse(localStorage.getItem("user")!)

    constructor(private http: HttpClient) { }

    getAllOrders() {
        return this.http.get("http://localhost:8080/api/orders")
    }

    getOrderById(id: number) {
        return this.http.get("http://localhost:8080/api/orders/" + id)
    }

    addOrder(ohid: number, cartid: number) {
    // addOrder(data: {}) {
        // return this.http.post("http://localhost:8080/api/orders", data)
        return this.http.post("http://localhost:8080/api/orders/" + ohid + "/" + cartid, {})
    }

    updateOrder(id: number, data: {}) {
        return this.http.put("http://localhost:8080/api/orders/" + id, data)
    }

    deleteOrder(id: number) {
        return this.http.delete("http://localhost:8080/api/orders/" + id)
    }
}
