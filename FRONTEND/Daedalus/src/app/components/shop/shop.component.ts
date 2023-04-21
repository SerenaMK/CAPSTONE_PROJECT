import { Component, OnInit } from '@angular/core';
import { ProductsService } from 'src/app/services/products.service';

@Component({
    selector: 'app-shop',
    templateUrl: './shop.component.html',
    styleUrls: ['./shop.component.scss']
})
export class ShopComponent implements OnInit {

    colore = "pink"

    products: any = []

    constructor(private productsService: ProductsService) { }

    ngOnInit(): void {
        this.productsService.getAllProducts().subscribe(data => { this.products = data })
    }

}
