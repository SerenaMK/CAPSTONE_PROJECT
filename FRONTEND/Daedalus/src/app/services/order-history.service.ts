import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class OrderHistoryService {

    localUser: any = JSON.parse(localStorage.getItem("user")!)

    constructor(private http: HttpClient) { }

    getAllOrderHistories() {
        return this.http.get("http://localhost:8080/api/order-histories")
    }

    getOrderHistoryById(id: number) {
        return this.http.get("http://localhost:8080/api/order-histories/" + id)
    }

    updateOrderHistory(id: number, data: {}) {
        return this.http.put("http://localhost:8080/api/order-histories/" + id, data)
    }

    deleteOrderHistory(id: number) {
        return this.http.delete("http://localhost:8080/api/order-histories/" + id)
    }
}
