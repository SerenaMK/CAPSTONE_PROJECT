import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})
export class ProductsService {

    localUser: any = JSON.parse(localStorage.getItem("user")!)
    selection: any[] = []

    constructor(private http: HttpClient) { }

    getAllProducts() {
        return this.http.get("http://localhost:8080/shop/products")
    }

    getProductById(id: number) {
        return this.http.get("http://localhost:8080/shop/products/" + id)
    }

    addProduct(data: {}) {
        return this.http.post("http://localhost:8080/shop/products/", data)
    }

    updateProduct(id: number, data: {}) {
        return this.http.put("http://localhost:8080/shop/products/" + id, data)
    }

    deleteProduct(id: number) {
        return this.http.delete("http://localhost:8080/shop/products/" + id)
    }

    getProductByCategory(category: string) {
        return this.http.get("http://localhost:8080/shop/products/filter?category=" + category)
    }
}
